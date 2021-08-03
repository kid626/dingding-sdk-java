package com.bruce.dingding.service;

import com.dingtalk.api.request.OapiChatCreateRequest;
import com.dingtalk.api.request.OapiChatSendRequest;
import com.dingtalk.api.response.OapiChatCreateResponse;
import com.dingtalk.api.response.OapiChatGetResponse;
import com.dingtalk.api.response.OapiChatSendResponse;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 群会话管理相关接口 https://developers.dingtalk.com/document/app/group-message-apply-for-permissions
 * @ProjectName dingding-sdk
 * @Date 2021/7/7 13:34
 * @Author fzh
 */
public interface DingChatService extends DingBaseService {

    /**
     * 创建群会话
     *
     * @param token   access_token
     * @param request OapiChatCreateRequest
     * @return OapiChatCreateResponse
     */
    OapiChatCreateResponse create(String token, OapiChatCreateRequest request);

    /**
     * 获取群会话(申请权限需要审批)
     *
     * @param token  access_token
     * @param chadId 创建群会话时返回的 chatId
     * @return OapiChatGetResponse
     */
    OapiChatGetResponse get(String token, String chadId);

    /**
     * 发送群消息
     *
     * @param token   access_token
     * @param request OapiChatSendRequest
     * @return OapiChatSendResponse
     */
    OapiChatSendResponse send(String token, OapiChatSendRequest request);

}
