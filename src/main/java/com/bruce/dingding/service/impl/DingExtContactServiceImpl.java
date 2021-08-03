package com.bruce.dingding.service.impl;

import com.bruce.dingding.entity.constants.UrlConstant;
import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.service.DingExtContactService;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import org.apache.commons.lang3.StringUtils;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 外部联系人管理实现层
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 12:58
 * @Author fzh
 */
public class DingExtContactServiceImpl extends DingBaseServiceImpl implements DingExtContactService {
    /**
     * @param agentId   应用agentId
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public DingExtContactServiceImpl(Long agentId, String appKey, String appSecret) {
        super(agentId, appKey, appSecret);
    }

    @Override
    public OapiExtcontactListlabelgroupsResponse listLabelGroups(Long offset, Long size, String token) throws DingDingException {
        if (null == offset) {
            throw new DingDingException("offset NOT NULL!");
        }
        int offsetMax = 100;
        if (offset.intValue() > offsetMax) {
            throw new DingDingException("offsetMax max" + offsetMax + "!");
        }
        if (null == size) {
            throw new DingDingException("size NOT NULL!");
        }
        if (StringUtils.isEmpty(token)) {
            throw new DingDingException("token NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.EXT_CONTACT_LIST_LABEL_GROUPS);
            OapiExtcontactListlabelgroupsRequest request = new OapiExtcontactListlabelgroupsRequest();
            request.setOffset(offset);
            request.setSize(size);
            OapiExtcontactListlabelgroupsResponse resp = client.execute(request, token);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiExtcontactListResponse list(Long offset, Long size, String token) throws DingDingException {
        if (null == offset) {
            throw new DingDingException("offset NOT NULL!");
        }
        int offsetMax = 100;
        if (offset.intValue() > offsetMax) {
            throw new DingDingException("offsetMax max" + offsetMax + "!");
        }
        if (null == size) {
            throw new DingDingException("size NOT NULL!");
        }
        if (StringUtils.isEmpty(token)) {
            throw new DingDingException("token NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.EXT_CONTACT_LIST);
            OapiExtcontactListRequest request = new OapiExtcontactListRequest();
            request.setOffset(offset);
            request.setSize(size);
            OapiExtcontactListResponse resp = client.execute(request, token);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiExtcontactGetResponse get(String userId, String token) throws DingDingException {
        if (StringUtils.isEmpty(userId)) {
            throw new DingDingException("userId NOT NULL!");
        }
        if (StringUtils.isEmpty(token)) {
            throw new DingDingException("token NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.EXT_CONTACT_GET);
            OapiExtcontactGetRequest request = new OapiExtcontactGetRequest();
            request.setUserId(userId);
            OapiExtcontactGetResponse resp = client.execute(request, token);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiExtcontactCreateResponse add(OapiExtcontactCreateRequest.OpenExtContact openExtContact, String token) throws DingDingException {
        if (StringUtils.isEmpty(token)) {
            throw new DingDingException("token NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.EXT_CONTACT_CREATE);
            OapiExtcontactCreateRequest request = new OapiExtcontactCreateRequest();
            request.setContact(openExtContact);
            OapiExtcontactCreateResponse resp = client.execute(request, token);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiExtcontactUpdateResponse update(OapiExtcontactUpdateRequest.OpenExtContact openExtContact, String token) throws DingDingException {
        if (StringUtils.isEmpty(token)) {
            throw new DingDingException("token NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.EXT_CONTACT_UPDATE);
            OapiExtcontactUpdateRequest request = new OapiExtcontactUpdateRequest();
            request.setContact(openExtContact);
            OapiExtcontactUpdateResponse resp = client.execute(request, token);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiExtcontactDeleteResponse delete(String userId, String token) throws DingDingException {
        if (StringUtils.isEmpty(userId)) {
            throw new DingDingException("userId NOT NULL!");
        }
        if (StringUtils.isEmpty(token)) {
            throw new DingDingException("token NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.EXT_CONTACT_DELETE);
            OapiExtcontactDeleteRequest request = new OapiExtcontactDeleteRequest();
            request.setUserId(userId);
            OapiExtcontactDeleteResponse resp = client.execute(request, token);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

}