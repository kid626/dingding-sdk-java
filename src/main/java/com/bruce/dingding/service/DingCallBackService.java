package com.bruce.dingding.service;

import com.dingtalk.api.request.OapiCallBackDeleteCallBackRequest;
import com.dingtalk.api.request.OapiCallBackRegisterCallBackRequest;
import com.dingtalk.api.response.OapiCallBackDeleteCallBackResponse;
import com.dingtalk.api.response.OapiCallBackRegisterCallBackResponse;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 钉钉回调接口 https://ding-doc.dingtalk.com/doc#/serverapi3/asmfzo
 * @ProjectName dingding-sdk
 * @Date 2021/8/2 10:48
 * @Author fzh
 */
public interface DingCallBackService extends DingBaseService {

    /**
     * 删除事件回调接口
     *
     * @param req OapiCallBackDeleteCallBackRequest
     * @return OapiCallBackDeleteCallBackResponse
     */
    OapiCallBackDeleteCallBackResponse callBackDelete(OapiCallBackDeleteCallBackRequest req, String token);

    /**
     * 注册业务事件回调接口
     *
     * @param req OapiCallBackRegisterCallBackRequest
     * @return OapiCallBackRegisterCallBackResponse
     */
    OapiCallBackRegisterCallBackResponse callBackRegister(OapiCallBackRegisterCallBackRequest req, String token);

}
