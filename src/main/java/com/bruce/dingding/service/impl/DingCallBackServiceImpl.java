package com.bruce.dingding.service.impl;

import com.bruce.dingding.entity.constants.UrlConstant;
import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.service.DingCallBackService;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiCallBackDeleteCallBackRequest;
import com.dingtalk.api.request.OapiCallBackRegisterCallBackRequest;
import com.dingtalk.api.response.OapiCallBackDeleteCallBackResponse;
import com.dingtalk.api.response.OapiCallBackRegisterCallBackResponse;
import com.taobao.api.ApiException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 钉钉回调接口实现
 * @ProjectName dingding-sdk
 * @Date 2021/8/2 10:48
 * @Author fzh
 */
public class DingCallBackServiceImpl extends DingBaseServiceImpl implements DingCallBackService {

    /**
     * @param agentId   应用agentId
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public DingCallBackServiceImpl(Long agentId, String appKey, String appSecret) {
        super(agentId, appKey, appSecret);
    }

    @Override
    public OapiCallBackDeleteCallBackResponse callBackDelete(OapiCallBackDeleteCallBackRequest req, String accessToken) {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.DELETE_CALLBACK);
            OapiCallBackDeleteCallBackRequest request = new OapiCallBackDeleteCallBackRequest();
            request.setHttpMethod("GET");
            OapiCallBackDeleteCallBackResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiCallBackRegisterCallBackResponse callBackRegister(OapiCallBackRegisterCallBackRequest req, String accessToken) {
        OapiCallBackRegisterCallBackRequest registerRequest = new OapiCallBackRegisterCallBackRequest();
        if (StringUtils.isEmpty(req.getToken())) {
            throw new DingDingException("加密解密的 token 不能为空");
        }
        if (StringUtils.isEmpty(req.getAesKey())) {
            throw new DingDingException("数据加密密钥不能为空");
        }
        if (StringUtils.isEmpty(req.getUrl())) {
            throw new DingDingException("回调地址不能为空");
        }
        if (CollectionUtils.isEmpty(req.getCallBackTag())) {
            throw new DingDingException("监听事件类型不能为空");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.REGISTER_CALLBACK);
            OapiCallBackRegisterCallBackResponse resp = client.execute(registerRequest, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }
}
