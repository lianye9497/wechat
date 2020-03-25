package com.study.px.wechat.common.category;

import com.study.px.wechat.common.WxRequest;
import lombok.Data;

/**
 * 小程序获取类目request
 */
@Data
public class MiniProgramGetcCategoryRequest extends WxRequest<MiniProgramGetCategoryResponse> {
    private String api;
}
