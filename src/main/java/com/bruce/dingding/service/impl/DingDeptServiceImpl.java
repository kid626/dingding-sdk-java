package com.bruce.dingding.service.impl;

import com.bruce.dingding.entity.constants.UrlConstant;
import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.service.DingDeptService;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import org.apache.commons.lang3.StringUtils;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 10:48
 * @Author fzh
 */
public class DingDeptServiceImpl extends DingBaseServiceImpl implements DingDeptService {
    /**
     * @param agentId   应用agentId
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public DingDeptServiceImpl(Long agentId, String appKey, String appSecret) {
        super(agentId, appKey, appSecret);
    }

    @Override
    public OapiDepartmentListIdsResponse getSubDept(String id, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(id)) {
            throw new DingDingException("id NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.DEPT_LIST_IDS);
            OapiDepartmentListIdsRequest request = new OapiDepartmentListIdsRequest();
            if (StringUtils.isEmpty(id)) {
                request.setId("1");
            }
            request.setId(id);
            request.setHttpMethod("GET");
            OapiDepartmentListIdsResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiDepartmentListResponse getDeptList(String lang, Boolean fetchChild, String id, String accessToken) throws DingDingException {
        OapiDepartmentListRequest request = new OapiDepartmentListRequest();
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        if (StringUtils.isEmpty(id)) {
            request.setId("1");
        }
        request.setId(id);
        if (StringUtils.isEmpty(lang)) {
            request.setLang(lang);
        }
        if (null != fetchChild) {
            request.setFetchChild(fetchChild);
        }
        request.setHttpMethod("GET");
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.DEPT_LIST);
            OapiDepartmentListResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiDepartmentGetResponse getDeptDetail(String lang, String id, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(id)) {
            throw new DingDingException("id NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.DEPT_GET);
            OapiDepartmentGetRequest request = new OapiDepartmentGetRequest();
            request.setId(id);
            if (StringUtils.isNotEmpty(lang)) {
                request.setLang(lang);
            }
            request.setHttpMethod("GET");
            OapiDepartmentGetResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiDepartmentListParentDeptsByDeptResponse getParentDeptsByDept(String id, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(id)) {
            throw new DingDingException("id NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.DEPT_LIST_PARENT_DEPTS_BY_DEPT);
            OapiDepartmentListParentDeptsByDeptRequest request = new OapiDepartmentListParentDeptsByDeptRequest();
            request.setId(id);
            request.setHttpMethod("GET");
            OapiDepartmentListParentDeptsByDeptResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiDepartmentDeleteResponse deleteDept(String id, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(id)) {
            throw new DingDingException("id NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.DEPT_DELETE);
            OapiDepartmentDeleteRequest request = new OapiDepartmentDeleteRequest();
            request.setId(id);
            request.setHttpMethod("GET");
            OapiDepartmentDeleteResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiDepartmentCreateResponse createDept(OapiDepartmentCreateRequest request, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.DEPT_CREATE);
            OapiDepartmentCreateResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiDepartmentUpdateResponse updateDept(OapiDepartmentUpdateRequest request, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.DEPT_UPDATE);
            OapiDepartmentUpdateResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }


    @Override
    public OapiV2DepartmentListparentbyuserResponse getDepartmentListParentbyUser(String userId, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("token NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.DEPT_LIST_PARENT_DEPT_BY_USER);
            OapiV2DepartmentListparentbyuserRequest req = new OapiV2DepartmentListparentbyuserRequest();
            req.setUserid(userId);
            OapiV2DepartmentListparentbyuserResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }
}