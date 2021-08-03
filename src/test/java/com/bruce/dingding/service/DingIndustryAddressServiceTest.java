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

    @Before
    public void before() {
        dingIndustryAddressService = new DingIndustryAddressServiceImpl(agentId, appKey, appSecret);
        token = dingIndustryAddressService.getAccessToken();
    }

    @Test
    public void detail() {
        Long deptId = 1L;
        OapiIndustryDepartmentGetResponse response = dingIndustryAddressService.detail(deptId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getUserList() {
        OapiIndustryUserListRequest req = new OapiIndustryUserListRequest();
        req.setDeptId(1L);
        req.setSize(10L);
        req.setCursor(1L);
        OapiIndustryUserListResponse response = dingIndustryAddressService.getUserList(req, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getList() {
        //TODO:无数据
        OapiIndustryDepartmentListRequest req = new OapiIndustryDepartmentListRequest();
        req.setDeptId(1L);
        req.setSize(10L);
        req.setCursor(1L);
        OapiIndustryDepartmentListResponse response = dingIndustryAddressService.getList(req, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getUserById() {
        Long deptId = null;
        String userId = "";
        OapiIndustryUserGetResponse response = dingIndustryAddressService.getUserById(deptId, userId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getIndustryOrganization() {
        OapiIndustryOrganizationGetResponse response = dingIndustryAddressService.getIndustryOrganization(token);
        Assert.assertNotNull(response);
    }
}