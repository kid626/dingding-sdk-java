package com.bruce.dingding.service;

import com.bruce.dingding.service.impl.DingIndustryAddressServiceImpl;
import com.dingtalk.api.request.OapiIndustryDepartmentListRequest;
import com.dingtalk.api.request.OapiIndustryUserListRequest;
import com.dingtalk.api.response.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:36
 * @Author fzh
 */
public class DingIndustryAddressServiceTest extends DingBaseServiceTest {

    private DingIndustryAddressService dingIndustryAddressService;

    private Long extDeptId = 1L;

    @Before
    public void before() {
        dingIndustryAddressService = new DingIndustryAddressServiceImpl(agentId, appKey, appSecret);
        token = dingIndustryAddressService.getAccessToken();
    }

    @Test
    public void detail() {
        OapiIndustryDepartmentGetResponse response = dingIndustryAddressService.detail(extDeptId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getUserList() {
        OapiIndustryUserListRequest req = new OapiIndustryUserListRequest();
        req.setDeptId(extDeptId);
        req.setSize(10L);
        req.setCursor(1L);
        OapiIndustryUserListResponse response = dingIndustryAddressService.getUserList(req, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getList() {
        //TODO:无数据
        OapiIndustryDepartmentListRequest req = new OapiIndustryDepartmentListRequest();
        req.setDeptId(extDeptId);
        req.setSize(10L);
        req.setCursor(1L);
        OapiIndustryDepartmentListResponse response = dingIndustryAddressService.getList(req, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getUserById() {
        OapiIndustryUserGetResponse response = dingIndustryAddressService.getUserById(extDeptId, userId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getIndustryOrganization() {
        OapiIndustryOrganizationGetResponse response = dingIndustryAddressService.getIndustryOrganization(token);
        Assert.assertNotNull(response);
    }
}