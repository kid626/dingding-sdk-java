package com.bruce.dingding.service.impl;

import com.bruce.dingding.entity.constants.UrlConstant;
import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.service.DingUserService;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 用户管理2.0 https://developers.dingtalk.com/document/app/user-information-creation
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 10:48
 * @Author fzh
 */
@Slf4j
public class DingUserServiceImpl extends DingBaseServiceImpl implements DingUserService {
    /**
     * @param agentId   应用agentId
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public DingUserServiceImpl(Long agentId, String appKey, String appSecret) {
        super(agentId, appKey, appSecret);
    }

    @Override
    public String getByUnionId(String unionId, String accessToken) {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_BY_UNION_ID);
            OapiUserGetbyunionidRequest req = new OapiUserGetbyunionidRequest();
            req.setUnionid(unionId);
            req.setHttpMethod("GET");
            OapiUserGetbyunionidResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp.getResult().getUserid();
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiV2UserGetResponse.UserGetResponse getByUserId(String userId, String accessToken) throws DingDingException {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_BY_USER_ID);
            OapiV2UserGetRequest req = new OapiV2UserGetRequest();
            req.setUserid(userId);
            req.setLanguage("zh_CN");
            OapiV2UserGetResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp.getResult();
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiUserGetDeptMemberResponse getDeptMemberIds(String deptId, String accessToken) throws DingDingException {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_DEPT_MEMBER);
            OapiUserGetDeptMemberRequest req = new OapiUserGetDeptMemberRequest();
            req.setDeptId(deptId);
            req.setHttpMethod("GET");
            OapiUserGetDeptMemberResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiUserSimplelistResponse getSimpleList(Long deptId, Long offset, Long size, String order, String accessToken) throws DingDingException {
        if (null == deptId) {
            throw new DingDingException("deptId NOT NULL!");
        }
        if (null == offset) {
            throw new DingDingException("offset NOT NULL!");
        }
        if (null == size) {
            throw new DingDingException("size NOT NULL!");
        }
        int maxSize = 100;
        if (size.intValue() > maxSize) {
            throw new DingDingException("size <= 100");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_SIMPLE_LIST);
            OapiUserSimplelistRequest request = new OapiUserSimplelistRequest();
            request.setDepartmentId(deptId);
            request.setOffset(offset);
            request.setSize(size);
            if (StringUtils.isNotEmpty(order)) {
                request.setOrder(order);
            }
            request.setHttpMethod("GET");
            OapiUserSimplelistResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiUserListbypageResponse getDetailList(Long deptId, Long offset, Long size, String order, String accessToken) throws DingDingException {
        if (null == deptId) {
            throw new DingDingException("deptId NOT NULL!");
        }
        if (null == offset) {
            throw new DingDingException("offset NOT NULL!");
        }
        if (null == size) {
            throw new DingDingException("size NOT NULL!");
        }
        if (size.intValue() > 100) {
            throw new DingDingException("size <= 100");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.LIST_BY_PAGE);
            OapiUserListbypageRequest request = new OapiUserListbypageRequest();
            request.setDepartmentId(deptId);
            request.setOffset(offset);
            request.setSize(size);
            if (StringUtils.isNotEmpty(order)) {
                request.setOrder(order);
            }
            request.setHttpMethod("GET");
            OapiUserListbypageResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiUserGetAdminResponse getAdmin(String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_ADMIN);
            OapiUserGetAdminRequest request = new OapiUserGetAdminRequest();
            request.setHttpMethod("GET");
            OapiUserGetAdminResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiUserGetAdminScopeResponse getAdminScope(String userId, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(userId)) {
            throw new DingDingException("userId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_ADMIN_SCOPE);
            OapiUserGetAdminScopeRequest request = new OapiUserGetAdminScopeRequest();
            request.setUserid(userId);
            OapiUserGetAdminScopeResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiUserCreateResponse create(OapiUserCreateRequest request, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.USER_CREATE);
            OapiUserCreateResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiUserUpdateResponse update(OapiUserUpdateRequest request, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.USER_UPDATE);
            OapiUserUpdateResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiUserDeleteResponse delete(String userId, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(userId)) {
            throw new DingDingException("userId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.USER_DELETE);
            OapiUserDeleteRequest request = new OapiUserDeleteRequest();
            request.setUserid(userId);
            request.setHttpMethod("GET");
            OapiUserDeleteResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiUserGetOrgUserCountResponse getOrgUserCount(boolean onlyActive, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_ORG_USER_COUNT);
            OapiUserGetOrgUserCountRequest request = new OapiUserGetOrgUserCountRequest();
            request.setOnlyActive(Long.valueOf(onlyActive ? "1" : "0"));
            request.setHttpMethod("GET");
            OapiUserGetOrgUserCountResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiInactiveUserV2GetResponse getInactiveUser(OapiInactiveUserV2GetRequest request, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.INACTIVE_USER_V2);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            request.setQueryDate(sdf.format(new Date()));
            OapiInactiveUserV2GetResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }


    @Override
    public OapiUserCanAccessMicroappResponse getAccessMicroapp(Long appId, String userId, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.CAN_ACCESS_MICROAPP);
            OapiUserCanAccessMicroappRequest request = new OapiUserCanAccessMicroappRequest();
            request.setAppId(appId);
            request.setUserId(userId);
            request.setHttpMethod("GET");
            OapiUserCanAccessMicroappResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiV2UserGetbymobileResponse getByMobile(String mobile, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_BY_MOBILE);
            OapiV2UserGetbymobileRequest req = new OapiV2UserGetbymobileRequest();
            req.setMobile(mobile);
            OapiV2UserGetbymobileResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiAuthScopesResponse getScopes(String token) throws DingDingException {
        if (StringUtils.isEmpty(token)) {
            throw new DingDingException("token NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.AUTH_SCOPES);
            OapiAuthScopesRequest request = new OapiAuthScopesRequest();
            request.setHttpMethod("GET");

            OapiAuthScopesResponse resp = client.execute(request, token);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }
}