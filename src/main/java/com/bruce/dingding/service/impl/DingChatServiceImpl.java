package com.bruce.dingding.service.impl;

import com.bruce.dingding.entity.constants.UrlConstant;
import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.service.DingChatService;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiChatCreateRequest;
import com.dingtalk.api.request.OapiChatGetRequest;
import com.dingtalk.api.request.OapiChatSendRequest;
import com.dingtalk.api.response.OapiChatCreateResponse;
import com.dingtalk.api.response.OapiChatGetResponse;
import com.dingtalk.api.response.OapiChatSendResponse;
import com.taobao.api.ApiException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk
 * @Date 2021/7/7 13:36
 * @Author fzh
 */
public class DingChatServiceImpl extends DingBaseServiceImpl implements DingChatService {

    /**
     * @param agentId   应用agentId
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public DingChatServiceImpl(Long agentId, String appKey, String appSecret) {
        super(agentId, appKey, appSecret);
    }

    @Override
    public OapiChatCreateResponse create(String token, OapiChatCreateRequest request) {
        if (StringUtils.isEmpty(request.getName())) {
            throw new DingDingException("名称不能为空");
        }
        if (StringUtils.isEmpty(request.getOwner())) {
            throw new DingDingException("群主不能为空");
        }
        if (CollectionUtils.isEmpty(request.getUseridlist())) {
            throw new DingDingException("群成员列表不能为空");
        }
        if (!request.getUseridlist().contains(request.getOwner())) {
            throw new DingDingException("群主必须在群成员列表中");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.CHAT_CREATE);
            OapiChatCreateResponse resp = client.execute(request, token);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiChatGetResponse get(String token, String chadId) {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.CHAT_GET);
            OapiChatGetRequest request = new OapiChatGetRequest();
            request.setChatid(chadId);
            OapiChatGetResponse resp = client.execute(request, token);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiChatSendResponse send(String token, OapiChatSendRequest request) {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.CHAT_SEND);
            if (StringUtils.isEmpty(request.getChatid())) {
                throw new DingDingException("群会话主键不能为空!");
            }
            OapiChatSendResponse resp = client.execute(request, token);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }
}
