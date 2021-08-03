package com.bruce.dingding.service.impl;

import com.bruce.dingding.entity.constants.UrlConstant;
import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.service.DingIndustryAddressService;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import org.apache.commons.lang3.StringUtils;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 行业通讯录
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 15:08
 * @Author fzh
 */
public class DingIndustryAddressServiceImpl extends DingBaseServiceImpl implements DingIndustryAddressService {

    /**
     * @param agentId   应用agentId
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public DingIndustryAddressServiceImpl(Long agentId, String appKey, String appSecret) {
        super(agentId, appKey, appSecret);
    }

    @Override
    public OapiIndustryDepartmentGetResponse detail(Long deptId, String accessToken) throws DingDingException {
        if (null == deptId) {
            throw new DingDingException("deptId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_INDUSTRY_DEPARTMENT);
            OapiIndustryDepartmentGetRequest request = new OapiIndustryDepartmentGetRequest();
            request.setDeptId(deptId);
            OapiIndustryDepartmentGetResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }

    }


    @Override
    public OapiIndustryUserListResponse getUserList(OapiIndustryUserListRequest request, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_INDUSTRY_USER_LIST);
            OapiIndustryUserListResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiIndustryDepartmentListResponse getList(OapiIndustryDepartmentListRequest request, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_INDUSTRY_DEPARTMENT_LIST);
            OapiIndustryDepartmentListResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiIndustryUserGetResponse getUserById(Long deptId, String userId, String accessToken) throws DingDingException {
        if (null == deptId) {
            throw new DingDingException("deptId NOT NULL!");
        }
        if (StringUtils.isEmpty(userId)) {
            throw new DingDingException("userId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_INDUSTRY_USER_DETAIL);
            OapiIndustryUserGetRequest req = new OapiIndustryUserGetRequest();
            req.setDeptId(deptId);
            req.setUserid(userId);
            OapiIndustryUserGetResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiIndustryOrganizationGetResponse getIndustryOrganization(String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_INDUSTRY_ORGANIZATION);
            OapiIndustryOrganizationGetRequest req = new OapiIndustryOrganizationGetRequest();
            OapiIndustryOrganizationGetResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

}
