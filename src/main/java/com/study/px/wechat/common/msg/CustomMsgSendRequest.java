package com.study.px.wechat.common.msg;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-13 11:53
 **/
@Data
public class CustomMsgSendRequest extends WxRequest<CustomMsgSendResponse> {

    @JSONField(name="touser")
    private String toUser;//		是	接收者（用户）的 openid

    //msgtype 的合法值
    //text	文本消息
    //image	图片消息
    //link	图文链接
    //miniprogrampage	小程序卡片
    @JSONField(name="msgtype")
    private String msgType; //是	消息类型

    private Text text; //是	文本消息内容，msgtype="text" 时必填

    private Image image; //是	图片消息，msgtype="image" 时必填

    private String link; //是	图片消息，msgtype="link" 时必填

    @JSONField(name="miniprogrampage")
    private String miniProgramPage;//是	小程序卡片，msgtype="miniprogrampage" 时必填

    @Data
    @NoArgsConstructor
    public static class Text implements Serializable {

        @JSONField(name="content")
        private String content;

        public Text(String content) {
            this.content = content;
        }
    }

    @Data
    @NoArgsConstructor
    public static class Image implements Serializable {

        @JSONField(name="media_id")
        private String mediaId;

        public Image(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    @Data
    @NoArgsConstructor
    public static class Link implements Serializable {

        private String title;
        private String description;
        private String url;
        @JSONField(name="thumb_url")
        private String thumbUrl;

        public Link(String title, String description, String url, String thumbUrl) {
            this.title = title;
            this.description = description;
            this.url = url;
            this.thumbUrl = thumbUrl;
        }
    }

    @Data
    @NoArgsConstructor
    public static class MiniProgramCard implements Serializable {

        @JSONField(name="thumb_media_id")
        private String thumbMediaId;

        @JSONField(name="pagepath")
        private String pagePath;

        private String title;


        public MiniProgramCard(String thumbMediaId, String pagePath, String title) {
            this.thumbMediaId = thumbMediaId;
            this.pagePath = pagePath;
            this.title = title;
        }
    }


}