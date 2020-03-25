package com.study.px.wechat.aes;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.util.Arrays;

/**
 * @author suding
 * @date 2020年03月24日 11:37
 */
@Slf4j
public class WXBizDataCrypt {
    // 算法名
    public static final String KEY_NAME = "AES";
    // 加解密算法/模式/填充方式
    // ECB模式只用密钥即可对数据进行加密解密，CBC模式需要添加一个iv
    public static final String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";

    public static void main(String[] args) {
        String encryptedData = "z0IgMtLY4TiM5ugLeAj5x9Gb+cj6UPqR+uXW2VwwL30z+Y/A/bGHxVbqaamCe23qmcCiVHIRUHmE+bnPgD7SiArQ22tbc1MIZqfupdIO5mIYR+aTrAYPUrG0TFEBtSH9bCYEAxMu5oEJlrryuMbw30GgIcfQClsHfceqwO6cIfVAUbE4oZP2wn/ljav3B9rsrBsHuOZaT65O06CAlH0OvzI0ZC/XphEFjXBW0Cywfks+gqwg3uYbwCLqA0zGoR1IFZbi+kIe+TKqJMVbcjSAqMtt3Gh+uSeC+21diC7rqbrNDfuipvWxPkTGe1D3tGGbe6t45TDbfAtY47DVrBEoGC8bEIut+Jwsc8vQMlq6RVdcezJ0XIluoPn/iXYm9mElGYCV8dWyqPRPp2LpF5ZYwgCadccTMy+wbPiSZTBXeZDzWaMnMmCcBvxkSjAC6m8pyWyfrkEIP11Zv8v1/y5WT3jRkmmYCjjFmvdlg274zvIfwbgvDOTlypBKjQ8oQBFi";

        String iv = "5pUNNylSWD0cGFARU9tyiw==";
        String session_key = "rxWCdUZTAskc0IXLoWq3xQ==";
        String s = WXBizDataCrypt.decryptData(encryptedData, session_key, iv);
        System.out.println(s);

    }

    static {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    public static String decryptData(String encryptedData, String sessionKey, String ivc) {
        String result = null;
        try {
            byte[] aesKey = Base64.decodeBase64(sessionKey);
            byte[] ivByte = Base64.decodeBase64(ivc);
            //设置解密模式为AES的CBC模式
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
            SecretKeySpec keySpec = new SecretKeySpec(aesKey, KEY_NAME);
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(ivByte, 0, 16));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
            //使用BASE64对密文进行解码
            byte[] encrypted = Base64.decodeBase64(encryptedData);
            // 解密
            byte[] original = cipher.doFinal(encrypted);
            // 去除补位字符
            byte[] bytes = PKCS7Encoder.decode(original);
            if (bytes.length > 0) {
                result = new String(bytes, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            log.error("decryptData fail. e={}", e);
        }
        return result;
    }

}
