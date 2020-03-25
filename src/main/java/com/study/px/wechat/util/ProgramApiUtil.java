package com.study.px.wechat.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.study.px.wechat.aes.AesException;
import com.study.px.wechat.aes.WXBizMsgCrypt;
import com.study.px.wechat.common.MiniProgramBaseInfo.*;
import com.study.px.wechat.common.WxCommonRequest;
import com.study.px.wechat.common.WxRequestContentUtil;
import com.study.px.wechat.common.WxResponse;
import com.study.px.wechat.common.authorization.*;
import com.study.px.wechat.common.category.MiniProgramGetCategoryResponse;
import com.study.px.wechat.common.category.MiniProgramGetcCategoryRequest;
import com.study.px.wechat.common.code.*;
import com.study.px.wechat.common.codeTemplate.*;
import com.study.px.wechat.common.component.*;
import com.study.px.wechat.common.constants.ProgramConstants;
import com.study.px.wechat.common.member.*;
import com.study.px.wechat.common.msg.CustomMsgSendRequest;
import com.study.px.wechat.common.msg.CustomMsgSendResponse;
import com.study.px.wechat.common.msg.TemplateMsgSendRequest;
import com.study.px.wechat.common.msgTemplate.MsgTemplateListRequest;
import com.study.px.wechat.common.msgTemplate.MsgTemplateListResponse;
import com.study.px.wechat.constants.ExceptionErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.*;

/**
 * @description: 小程序工具类
 * @author: 苏定
 * @create: 2019-05-23 20:26
 **/
@Slf4j
public class ProgramApiUtil {
    private static final String REDIRECT_URL = "";

    private ProgramApiUtil() {
    }

    //token获取尝试次数
    private static final Integer TRY_TIMES = 3;

    //回调URI
    private static final String REDIRECT_URI = "/program/redirectUri";

    //授权参数key
    public static final String APP_AUTH_QUERY_CODE_KEY = "miniCode";

    //服务商信息api_authorizer_token
    private static final String COMPONENT_APP_INFO = "COMPONENT_APP_INFO-";

    //消息加密TOKEN
    private static final String TOKEN = "XIAOXITOKEN301244267471999000C296611310";

    //消息解密KEY
    private static final String ENCODING_AES_KEY = "TOKENJIEMI301244267471999000C29661131001234";

    //component_verify_ticket
    public static final String COMPONENT_VERIFY_TICKET = "ywwl-mini-program-component_verify_ticket-";

    //三方平台TOKEN
    private static final String COMPONENT_ACCESS_TOKEN_KEY = "ywwl-mini-program-component-access-token-";
    //更新component-access-token锁
    private static final String UPDATE_COMPONENT_ACCESS_TOKEN_KEY = "update-ywwl-mini-program-component-access-token-";

    // 小程序 授权信息
    private static final String AUTHORIZATION_INFO = "ywwl-mini-program-authorization-info-";
    private static final String UPDATE_AUTHORIZATION = "update-ywwl-mini-program-authorization-";
    //小程序授权token
    private static final String AUTHORIZATION_TOKEN = "ywwl-mini-program-authorization-token-";



    public static Map<String, String> dealCallback(String nonce, String timestamp, String msgSignature, String xmlMessage, String appId) {
        Map<String, String> map = ProgramApiUtil.decodeMsg(nonce, timestamp, msgSignature, xmlMessage, appId);
        log.info("解码后的xmlMessage={}", map);
        return map;
    }




    /**
     * 从微信获取 componentAccessToken
     *
     * @return
     */
    public static ComponentAccessTokenResponse getComponentAccessTokenFromWx(String componentAppId) {
        String componentVerifyTicket = getComponentVerifyTicket(componentAppId);
        if (StringUtils.isBlank(componentVerifyTicket)) {
            log.info("获取componentVerifyTicket失败,componentAppId={}", componentAppId);
            return null;
        }
        ComponentAccessTokenRequest componentAccessTokenRequest = new ComponentAccessTokenRequest();
        componentAccessTokenRequest.setComponentAppid(componentAppId);
        componentAccessTokenRequest.setComponentAppsecret(getComponentAppSecret(componentAppId));
        componentAccessTokenRequest.setComponentVerifyTicket(componentVerifyTicket);
        return WxClient.executePost(componentAccessTokenRequest);
    }

    private static String getComponentAppSecret(String componentAppId) {
        return null;
    }

    private static String getComponentVerifyTicket(String componentAppId) {
        return null;
    }


    /**
     * 获取预授权码
     *
     * @return
     */
    public static String getPreAuthCode(String componentAppId) {
        return preAuthCodeFromWx(componentAppId).getPreAuthCode();
    }

    /**
     * 获取预授权码
     *
     * @return
     */
    private static PreAuthCodeResponse preAuthCodeFromWx(String componentAppId) {
        PreAuthCodeRequest preAuthCodeRequest = new PreAuthCodeRequest();
        preAuthCodeRequest.setComponentAppid(componentAppId);
        preAuthCodeRequest.setComponentAccessToken(getComponentAccessToken(componentAppId));
        PreAuthCodeResponse response = WxClient.executePost(preAuthCodeRequest);
        if (!response.isSuccess()) {
            return response;
        }
        return response;
    }

    private static String getComponentAccessToken(String componentAppId) {
        return null;
    }

    /**
     * 小程序授权通知 设置授权信息
     *
     * @param authCode
     * @return
     */
    public static void setAuthorizationInfo(String componentAppId, String authCode) {
        getAuthorizationInfoFromWx(componentAppId, authCode);
    }

    /**
     * 根据授权码从微信获取授权信息
     *
     * @param authCode
     * @return
     */
    public static AuthorizationInfoResponse getAuthorizationInfoFromWx(String componentAppId, String authCode) {
        AuthorizationInfoRequest authorizationInfoRequest = new AuthorizationInfoRequest();
        authorizationInfoRequest.setComponentAppid(componentAppId);
        authorizationInfoRequest.setAuthorizationCode(authCode);
        authorizationInfoRequest.setComponentAccessToken(getComponentAccessToken(componentAppId));
        AuthorizationInfoResponse response = WxClient.executePost(authorizationInfoRequest);
        if (!response.isSuccess()) {
            return response;
        }
        AuthorizationInfo authorizationInfo = response.getAuthorizationInfo();
        authorizationInfo.setExpiresIn(authorizationInfo.getExpiresIn());
        setAuthorizationAccess(authorizationInfo);
        return response;
    }

    /**
     * 获取accessToken
     *
     * @param appId
     * @return
     */
    public static String getAuthorizationAccessToken(String appId) {
        return null;
    }


    /**
     * 刷新小程序token
     *
     * @param appId
     */
    private static void refreshAuthorizationAccessToken(String appId, String componentAppId) {
        RefreshAuthorizationInfoResponse response = getRefreshAuthorizationInfoResponse(appId);
        AuthorizerRefreshToken authorizerRefreshToken = new AuthorizerRefreshToken();
        authorizerRefreshToken.setAuthorizerAppId(response.getAuthorizerAppId());
        authorizerRefreshToken.setRefreshToken(response.getAuthorizerRefreshToken());
        refreshAuthorizationAccessToken(authorizerRefreshToken, componentAppId);
    }

    /**
     * 刷新 小程序 accessToken
     *
     * @param authorizerRefreshToken
     */
    public static void refreshAuthorizationAccessToken(AuthorizerRefreshToken authorizerRefreshToken, String componentAppId) {
        RefreshAuthorizationInfoRequest refreshAuthorizationInfoRequest = new RefreshAuthorizationInfoRequest();
        refreshAuthorizationInfoRequest.setAuthorizerAppid(authorizerRefreshToken.getAuthorizerAppId());
        refreshAuthorizationInfoRequest.setAuthorizerRefreshToken(authorizerRefreshToken.getRefreshToken());
        refreshAuthorizationInfoRequest.setComponentAppid(componentAppId);
        refreshAuthorizationInfoRequest.setComponentAccessToken(getComponentAccessToken(componentAppId));
        RefreshAuthorizationInfoResponse response = WxClient.executePost(refreshAuthorizationInfoRequest);
        if (!response.isSuccess()) {
            log.info("刷新小程序token失败,参数componentAppId={},appId={},原因errorCode={},errorMsg={}", authorizerRefreshToken.getAuthorizerAppId(),
                    componentAppId, response.getErrCode(), response.getErrMsg());
            Throwable throwable = new Throwable();
            StackTraceElement[] stackTrace = throwable.getStackTrace();
            log.info(JSON.toJSONString(stackTrace));
            return;
        }
        response.setAuthorizerAppId(authorizerRefreshToken.getAuthorizerAppId());
        setAuthAccessToken(response);
    }

    /**
     * 设置授权信息和accessToken
     *
     * @param authorizationInfo
     */
    public static void setAuthorizationAccess(AuthorizationInfo authorizationInfo) {
        Integer integer = authorizationInfo.getExpiresIn();
//        jedisUtil.set(AUTHORIZATION_INFO + authorizationInfo.getAuthorizerAppId(), JSON.toJSONString(authorizationInfo), integer == null ? 60 * 120 : integer);
        RefreshAuthorizationInfoResponse response = new RefreshAuthorizationInfoResponse();
        response.setAuthorizerAccessToken(authorizationInfo.getAuthorizerAccessToken());
        response.setAuthorizerAppId(authorizationInfo.getAuthorizerAppId());
        response.setAuthorizerRefreshToken(authorizationInfo.getAuthorizerRefreshToken());
        response.setExpiresIn(authorizationInfo.getExpiresIn());
        setAuthAccessToken(response);
    }



    /**
     * 设置小程序授权token
     *
     * @param response
     */
    private static void setAuthAccessToken(RefreshAuthorizationInfoResponse response) {
        Integer expiresIn = response.getExpiresIn();
        if (expiresIn == null) {
            expiresIn = 3600;
        }
        log.info("token 有效时间={}", expiresIn);
        response.setCreateTime(new Date());
        response.setSuccess(true);
//        jedisUtil.set(AUTHORIZATION_TOKEN + response.getAuthorizerAppId(), JSON.toJSONString(response), expiresIn);
    }

    /**
     * 获取小程序refresh Token
     *
     * @param appId
     * @return
     */
    public static RefreshAuthorizationInfoResponse getRefreshAuthorizationInfoResponse(String appId) {
//        String s = jedisUtil.get(AUTHORIZATION_TOKEN + appId);
//        if (StringUtils.isBlank(s)) {
//            //尝试从数据库获取refreshToken
//            SmallApp smallApp = smallAppService.selectByAppId(appId);
//            if (smallApp == null) {
//                log.info("获取小程序失败,请确认小程序是否已经授权appId={}", appId);
//                RefreshAuthorizationInfoResponse response = new RefreshAuthorizationInfoResponse();
//                return failResponse(response, ExceptionErrorCode.BIZ_SMALL_APP_NOT_AUTHORIZATION);
//            }
//            RefreshAuthorizationInfoResponse response = new RefreshAuthorizationInfoResponse();
//            response.setAuthorizerAppId(appId);
//            response.setAuthorizerRefreshToken(smallApp.getAuthorizerRefreshToken());
//            return response;
//        }
//        RefreshAuthorizationInfoResponse response = JSON.parseObject(s, RefreshAuthorizationInfoResponse.class);
//        response.setSuccess(true);
//        return response;
        return null;
    }


    /**
     * 消息解密
     *
     * @param
     * @param nonce
     * @param timestamp
     * @param msgSignature
     * @param fromXML
     * @return
     */
    public static Map<String, String> decodeMsg(String nonce, String timestamp, String msgSignature, String fromXML, String appId) {
        try {
//            Map<String, String> stringMap = XMLUtil.doXMLParse(fromXML);
//            appId = StringUtils.isBlank(stringMap.get("AppId")) ? appId : stringMap.get("AppId");
            WXBizMsgCrypt pc = new WXBizMsgCrypt(TOKEN, ENCODING_AES_KEY, appId);
//            fromXML = StringUtils.replace(fromXML, "AppId", "ToUserName");
            fromXML = parsingXml( fromXML, "Encrypt");
            String xmlMessage = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
//            Map<String, String> xmlDataMap = XMLUtil.doXMLParse(xmlMessage);
            Map<String, String> xmlDataMap = new HashMap<>();
            System.out.println(nonce.equals(xmlDataMap.get("Nonce")));
            System.out.println(timestamp.equals(xmlDataMap.get("TimeStamp")));
            System.out.println(msgSignature.equals(xmlDataMap.get("MsgSignature")));
            xmlDataMap.put("Nonce", nonce);
            xmlDataMap.put("TimeStamp", timestamp);
            xmlDataMap.put("MsgSignature", msgSignature);
            return xmlDataMap;
        } catch (AesException e) {
            log.error("decodeMsg AesException={}", e);
        }catch (IOException e) {
            log.error("decodeMsg IOException={}", e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    public static String parsingXml(String postData , String xmlKey) throws Exception{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        StringReader sr = new StringReader(postData);
        InputSource is = new InputSource(sr);
        Document document = db.parse(is);
        Element root = document.getDocumentElement();
        NodeList nodelist1 = root.getElementsByTagName(xmlKey);
        String value = nodelist1.item(0).getTextContent();
        return value;
    }

    /**
     * 获取授权链接
     */
    public static AuthUrlResponse getAuthCodeUrl(String componentAppId) {
        AuthUrlResponse response = new AuthUrlResponse();
        String preAuthCode = getPreAuthCode(componentAppId);
        if (StringUtils.isBlank(preAuthCode)) {
            return null;
        }
        String format = String.format(ProgramConstants.AUTH_URL, componentAppId, preAuthCode, REDIRECT_URL);
        response.setAuthUrl(format);
        response.setSuccess(true);
        return response;
    }

    /**
     * 获取二维码授权链接
     *
     * @return
     */
    public static QrCodeResponse qrCodeAuth(String componentAppId, String atc) {
        QrCodeResponse response = new QrCodeResponse();
        String preAuthCode = getPreAuthCode(componentAppId);
        if (StringUtils.isBlank(preAuthCode)) {
            return null;
        }
//        String redirectUrl = ConfInfoUtilService.getServerHostDomain() + REDIRECT_URI + "?" + APP_AUTH_QUERY_CODE_KEY + "=" + atc;
        String redirectUrl="";
        String qrCodeUrl = String.format(ProgramConstants.QR_CODE_AUTH_URL, componentAppId, preAuthCode, redirectUrl);
        response.setSuccess(true);
        response.setQrCodeUrl(qrCodeUrl);
        return response;
    }

    /***
     * 获取小程序账号基本信息
     * @param appId
     * @return
     */
    public static MiniProgramBaseInfoResponse getMiniProgramBaseInfo(String appId) {
        MiniProgramBaseInfoRequest miniProgramBaseInfoRequest = new MiniProgramBaseInfoRequest();
        String authorizerAccessToken = ProgramApiUtil.getAuthorizationAccessToken(appId);
        if (StringUtils.isBlank(authorizerAccessToken)) {
            return null;
        }
        String url = String.format(ProgramConstants.GET_ACCOUNT_BASIC_INFO, authorizerAccessToken);
        miniProgramBaseInfoRequest.setApi(url);
        return WxClient.executeGet(miniProgramBaseInfoRequest);
    }

    /**
     * 获取小程序账号已经设置的所有类目
     *
     * @param appId
     * @return
     */
    public static MiniProgramGetCategoryResponse getCategory(String appId) {
        MiniProgramGetcCategoryRequest miniProgramGetcCategoryRequest = new MiniProgramGetcCategoryRequest();
        String authorizerAccessToken = ProgramApiUtil.getAuthorizationAccessToken(appId);
        if (StringUtils.isBlank(authorizerAccessToken)) {
            return null;
        }
        String url = String.format(ProgramConstants.GET_CATEGORY, authorizerAccessToken);
        miniProgramGetcCategoryRequest.setApi(url);
        return WxClient.executePost(miniProgramGetcCategoryRequest);
    }


    public static MiniProgramModifySignatureResponse modifySignature(String appId, String signature) {
        MiniProgramModifySignatureRequest miniProgramModifySignatureRequest = new MiniProgramModifySignatureRequest();
        String authorizerAccessToken = ProgramApiUtil.getAuthorizationAccessToken(appId);
        if (StringUtils.isBlank(authorizerAccessToken)) {
            return null;
        }
        String url = String.format(ProgramConstants.MODIFY_SIGNATURE, authorizerAccessToken);
        miniProgramModifySignatureRequest.setApi(url);
        miniProgramModifySignatureRequest.setSignature(signature);
        return WxClient.executePost(miniProgramModifySignatureRequest);
    }

    public static MiniProgramNickNameResponse setNickName(String appId, String nickName, String idCard, String license, String namingOtherStuff1, String namingOtherStuff2, MultipartFile file) {
        MiniProgramNickNameRequest miniProgramNickNameRequest = new MiniProgramNickNameRequest();
        String authorizerAccessToken = ProgramApiUtil.getAuthorizationAccessToken(appId);
        if (StringUtils.isBlank(authorizerAccessToken)) {
            return null;
        }
        String tempMaterialUrl = String.format(ProgramConstants.TEMP_MATERIAL, authorizerAccessToken);
        miniProgramNickNameRequest.setApi(tempMaterialUrl);
        MiniProgramNickNameResponse miniProgramNickNameResponse1 = WxClient.executeFormPost(miniProgramNickNameRequest, file);
        if (!miniProgramNickNameResponse1.isSuccess()) {
            return null;
        }

        String url = String.format(ProgramConstants.SETNICK_NAME, authorizerAccessToken);
        miniProgramNickNameRequest.setApi(url);
        miniProgramNickNameRequest.setNickName(nickName);
        miniProgramNickNameRequest.setIdCard(idCard);
        miniProgramNickNameRequest.setLicense(license);
        miniProgramNickNameRequest.setNamingOtherStuff1(namingOtherStuff1);
        miniProgramNickNameRequest.setNamingOtherStuff2(namingOtherStuff2);
        return WxClient.executePost(miniProgramNickNameRequest);
    }

    /**
     * 绑定体验者
     *
     * @param appId
     * @param wechatId
     * @return
     */
    public static BindTesterResponse bindTester(String appId, String wechatId) {
        BindTesterRequest bindTesterRequest = new BindTesterRequest();
        String authorizerAccessToken = ProgramApiUtil.getAuthorizationAccessToken(appId);
        if (StringUtils.isBlank(authorizerAccessToken)) {
            return null;
        }
        String url = String.format(ProgramConstants.BIND_TESTER, authorizerAccessToken);
        bindTesterRequest.setApi(url);
        bindTesterRequest.setWechatId(wechatId);
        return WxClient.executePost(bindTesterRequest);
    }

    /**
     * 解绑绑定者
     *
     * @param appId
     * @param wechatId
     * @return
     */
    public static UnBindTesterResponse unBindTester(String appId, String wechatId) {
        UnBindTesterRequest unBindTesterRequest = new UnBindTesterRequest();
        String authorizerAccessToken = ProgramApiUtil.getAuthorizationAccessToken(appId);
        if (StringUtils.isBlank(authorizerAccessToken)) {
            return null;
        }
        String url = String.format(ProgramConstants.UNBIND_TESTER, authorizerAccessToken);
        unBindTesterRequest.setApi(url);
        unBindTesterRequest.setWechatId(wechatId);
        return WxClient.executePost(unBindTesterRequest);
    }


    public static GetBindTesterListResponse memberAuth(String appId) {
        GetBindTesterListRequest getBindTesterListRequest = new GetBindTesterListRequest();
        String authorizerAccessToken = ProgramApiUtil.getAuthorizationAccessToken(appId);
        if (StringUtils.isBlank(authorizerAccessToken)) {
            return null;
        }
        String url = String.format(ProgramConstants.MEMBER_AUTH, authorizerAccessToken);
        getBindTesterListRequest.setApi(url);
        getBindTesterListRequest.setAction("get_experiencer");
        return WxClient.executePost(getBindTesterListRequest);
    }

    /**
     * 小程序代码模版库管理
     * 获取草稿箱内的所有临时代码草稿
     *
     * @return
     */
    public static GetTemplateDraftListResponse getTemplatedRaftList(String ComponentAppId) {
        GetTemplatedRaftListRequest getTemplatedRaftListRequest = new GetTemplatedRaftListRequest();
        String componentAccessToken = ProgramApiUtil.getComponentAccessToken(ComponentAppId);
        String url = String.format(ProgramConstants.GET_TEMPLATE_DRAFT_LIST, componentAccessToken);
        getTemplatedRaftListRequest.setApi(url);
        return WxClient.executeGet(getTemplatedRaftListRequest);
    }


    /**
     * 获取代码模版库中的所有小程序代码模版
     *
     * @return
     */
    public static GetTemplatedListResponse getTemplateList(String ComponentAppId) {
        GetTemplatedListRequest getTemplatedListRequest = new GetTemplatedListRequest();
        String componentAccessToken = ProgramApiUtil.getComponentAccessToken(ComponentAppId);
        String url = String.format(ProgramConstants.GET_TEMPLATE_LIST, componentAccessToken);
        getTemplatedListRequest.setApi(url);
        return WxClient.executeGet(getTemplatedListRequest);
    }

    /**
     * 将草稿箱的草稿选为小程序代码模版
     *
     * @param draftId 草稿id
     * @return
     */
    public static AddTemplateResponse addToTemplate(String componentAppId, String draftId) {
        AddTemplateRequest addTemplateRequest = new AddTemplateRequest();
        String componentAccessToken = ProgramApiUtil.getComponentAccessToken(componentAppId);
        String url = String.format(ProgramConstants.ADD_TEMPLATE, componentAccessToken);
        addTemplateRequest.setApi(url);
        addTemplateRequest.setDraftId(draftId);
        return WxClient.executePost(addTemplateRequest);
    }

    /**
     * 删除指定小程序代码模版
     *
     * @param templateId 模板id
     * @return
     */
    public static DeleteTemplateResponse deleteTemplate(String componentAppId, String templateId) {
        DeleteTemplateRequest deleteTemplateRequest = new DeleteTemplateRequest();
        String componentAccessToken = ProgramApiUtil.getComponentAccessToken(componentAppId);
        String url = String.format(ProgramConstants.DELETED_TEMPLATE, componentAccessToken);
        deleteTemplateRequest.setApi(url);
        deleteTemplateRequest.setTemplateId(templateId);
        return WxClient.executePost(deleteTemplateRequest);
    }

    /**
     * 上传小程序代码
     *
     * @param request
     * @param appId
     * @return
     */
    public static UploadCodeResponse uploadCode(UploadCodeRequest request, String appId) {
        String authorizationAccessToken = getAuthorizationAccessToken(appId);
        request.setApi(String.format(ProgramConstants.CODE_COMMIT, authorizationAccessToken));
        return WxClient.executePost(request);
    }

    /**
     * 提交代码审核
     *
     * @param request
     * @return
     */
    public static SubmitAuditResponse submitAudit(SubmitAuditRequest request, String appId) {
        String authorizeAccessToken = getAuthorizationAccessToken(appId);
        request.setApi(String.format(ProgramConstants.SUBMIT_AUDIT, authorizeAccessToken));
        return WxClient.executePost(request);
    }

    /**
     * 查询指定发布审核单的审核状态
     *
     * @param
     * @param appId
     * @return
     */
    public static GetAuditStatusResponse getAuditStatus(String appId, String auditId) {
        GetAuditStatusRequest request = new GetAuditStatusRequest();
        String authorizeAccessToken = getAuthorizationAccessToken(appId);
        request.setApi(String.format(request.getApi(), authorizeAccessToken));
        request.setAuditId(auditId);
        return WxClient.executePost(request);
    }

    /**
     * 发布已通过审核的小程序
     *
     * @param appId
     * @return
     */
    public static WxResponse release(String appId) {
        WxCommonRequest request = new WxCommonRequest();
        String authorizeAccessToken = getAuthorizationAccessToken(appId);
        request.setApi(String.format(ProgramConstants.RELEASE, authorizeAccessToken));
        return WxClient.executePost(request);
    }


    /**
     * 获取体验二维码
     *
     * @param appId
     * @param path
     * @return
     */
    public static GetQrcodeResponse getQrcode(String appId, String path) {
        GetQrCodeRequest request = new GetQrCodeRequest();
        String authorizeAccessToken = getAuthorizationAccessToken(appId);
        String url;
        if (StringUtils.isBlank(path)) {
            String replace = ProgramConstants.GET_QRCODE.replace("path=%s", "");
            url = String.format(replace, authorizeAccessToken);
        } else {
            url = String.format(ProgramConstants.GET_QRCODE, authorizeAccessToken, path);
        }
        byte[] bytes = WxClient.executeGetForByte(url);
        if (bytes == null) {
            return null;
        }
        GetQrcodeResponse getQrcodeResponse = null;
        try {
            getQrcodeResponse = WxClient.dealResult(request, new String(bytes));
            if (!getQrcodeResponse.isSuccess()) {
                return getQrcodeResponse;
            }
        } catch (JSONException e) {
            getQrcodeResponse = new GetQrcodeResponse();
        }
//        String uploadPath = OssFileUtil.getUploadPath(ProgramConstants.QR_CODE_PATH_PREFIX, System.currentTimeMillis() + ".jpg");
//        Boolean aBoolean = OssFileUtil.uploadFile(new ByteArrayInputStream(bytes), uploadPath);
//        if (!aBoolean) {
//            return getQrcodeResponse;
//        }
//        String uploadFilePath = OssFileUtil.getUploadFilePath(uploadPath);
//        getQrcodeResponse.setOssUrl(uploadFilePath);
        getQrcodeResponse.setSuccess(true);
        return getQrcodeResponse;
    }

    /**
     * 设置小程序服务器域名
     *
     * @param appId
     * @param socketDomains
     * @param uploadDomains
     * @param downloadDomains
     * @return
     */
    public static ModifyDomainResponse modifyDomain(String appId, List<String> requestDomains, List<String> socketDomains, List<String> uploadDomains, List<String> downloadDomains) {
        String authorizeAccessToken = getAuthorizationAccessToken(appId);
        ModifyDomainRequest request = new ModifyDomainRequest();
        request.setApi(String.format(request.getApi(), authorizeAccessToken));
        request.setAction("add");
        if (CollectionUtils.isNotEmpty(downloadDomains)) {
            request.setDownloaddomain(downloadDomains.toArray(new String[downloadDomains.size()]));
        }
        if (CollectionUtils.isNotEmpty(requestDomains)) {
            request.setRequestdomain(requestDomains.toArray(new String[requestDomains.size()]));
        }
        if (CollectionUtils.isNotEmpty(uploadDomains)) {
            request.setUploaddomain(uploadDomains.toArray(new String[uploadDomains.size()]));
        }
        if (CollectionUtils.isNotEmpty(socketDomains)) {
            request.setWsrequestdomain(socketDomains.toArray(new String[socketDomains.size()]));
        }
        ModifyDomainResponse response = WxClient.executePost(request);
        if (!response.isSuccess()) {
            return response;
        }
        return response;
    }


    /**
     * 获取账号下已授权小程序列表
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    public static GetAuthorizerListResponse getAuthorizerList(Integer pageSize, Integer pageNum, String componentAppId) {
        GetAuthorizerListRequest request = new GetAuthorizerListRequest();
        request.setCount(pageSize);
        request.setOffset((pageNum - 1) * pageSize);
        request.setComponentAppid(componentAppId);
        request.setComponentAccessToken(getComponentAccessToken(componentAppId));
        return WxClient.executePost(request);
    }

    /**
     * 获取小程序账号信息
     *
     * @param appId
     * @return
     */
    public static GetAuthorizerInfoResponse getAuthorizerInfo(String appId, String componentAppId) {
        GetAuthorizerInfoRequest request = new GetAuthorizerInfoRequest();
        request.setAuthorizerAppid(appId);
        request.setComponentAppid(componentAppId);
        request.setComponentAccessToken(getComponentAccessToken(componentAppId));
        return WxClient.executePost(request);
    }

    public static MsgTemplateListResponse msgTemplateList(String appId, Integer offset, Integer count) {
        MsgTemplateListRequest msgTemplateAddRequest = new MsgTemplateListRequest();
        String authorizerAccessToken = ProgramApiUtil.getAuthorizationAccessToken(appId);
        String url = String.format(ProgramConstants.MSG_TEMPLATE_LIST, authorizerAccessToken);
        msgTemplateAddRequest.setApi(url);
        msgTemplateAddRequest.setOffset(offset);
        msgTemplateAddRequest.setCount(count);
        if (StringUtils.isBlank(authorizerAccessToken)) {
            return null;
        }
        return WxClient.executePost(msgTemplateAddRequest);
    }

    /**
     * 获取小程序页面配置
     *
     * @param appId
     * @return
     */
    public static GetPageResponse getPage(String appId) {
        GetPageRequest request = new GetPageRequest();
        String authorizationAccessToken = getAuthorizationAccessToken(appId);
        request.setApi(String.format(request.getApi(), authorizationAccessToken));
        return WxClient.executeGet(request);
    }

    /**
     * 获取审核时可填写的类目信息
     *
     * @param appId
     * @return
     */
    public static AuditGetCategoryResponse getAuditCanSetCategory(String appId) {
        String authorizerAccessToken = ProgramApiUtil.getAuthorizationAccessToken(appId);
        String format = String.format(ProgramConstants.CODE_GET_CATEGORY, authorizerAccessToken);
        AuditGetCategoryRequest request = new AuditGetCategoryRequest();
        request.setApi(format);
        AuditGetCategoryResponse response = WxClient.executeGet(request);
        if (!response.isSuccess()) {
            log.info("获取审核时可填写的类目信息失败");
        }
        return response;
    }

    /**
     * 查询最新一次提交的审核状态
     *
     * @param appId
     * @return
     */
    public static GetLastAuditStatusResponse getLastAuditStatus(String appId) {
        GetLastAuditStatusRequest request = new GetLastAuditStatusRequest();
        String authorizationAccessToken = getAuthorizationAccessToken(appId);
        request.setApi(String.format(ProgramConstants.GET_LATEST_AUDIT_STATUS, authorizationAccessToken));
        return WxClient.executeGet(request);
    }

    /**
     * 审核撤回
     *
     * @param appId
     * @return
     */
    public static WxResponse undoCodeAudit(String appId) {
        WxCommonRequest request = new WxCommonRequest();
        String authorizationAccessToken = getAuthorizationAccessToken(appId);
        request.setApi(String.format(ProgramConstants.UNDO_CODE_AUDIT, authorizationAccessToken));
        return WxClient.executeGet(request);
    }

    /**
     * 发送模板消息
     *
     * @param request
     * @param appId
     * @return
     */
    public static WxResponse sendTemplateMsg(TemplateMsgSendRequest request, String appId) {
        String accessToken = getAuthorizationAccessToken(appId);
        request.setApi(String.format(ProgramConstants.TEMPLATE_SEND, accessToken));
        return WxClient.executePost(request);
    }

    public static JsCode2SessionResponse jsCode2Session(String appId, String jsCode, String componentAppId) {
        JsCode2SessionRequest request = new JsCode2SessionRequest();
        String componentAccessToken = getComponentAccessToken(componentAppId);
        if (StringUtils.isBlank(componentAccessToken)) {
            return null;
        }
        String url = String.format(ProgramConstants.JS_CODE2_SESSION, appId, jsCode, componentAppId, componentAccessToken);
        request.setApi(url);
        return WxClient.executeGet(request);
    }

    /**
     * 发送客户消息
     *
     * @param request
     * @param appId
     * @return
     */
    public static CustomMsgSendResponse customMsgSend(CustomMsgSendRequest request, String appId) {
        String authorizationAccessToken = getAuthorizationAccessToken(appId);
        request.setApi(String.format(ProgramConstants.CUSTOM_SEND, authorizationAccessToken));
        return WxClient.executePost(request);
    }
}
