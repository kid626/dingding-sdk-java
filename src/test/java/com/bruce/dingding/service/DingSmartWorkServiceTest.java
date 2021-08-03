package com.bruce.dingding.service;

import com.bruce.dingding.service.impl.DingSmartWorkServiceImpl;
import com.dingtalk.api.request.OapiSmartworkHrmEmployeeAddpreentryRequest;
import com.dingtalk.api.response.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:36
 * @Author fzh
 */
public class DingSmartWorkServiceTest extends DingBaseServiceTest {

    private DingSmartWorkService dingSmartWorkService;

    @Before
    public void setUp() throws Exception {
        dingSmartWorkService = new DingSmartWorkServiceImpl(agentId, appKey, appSecret);
        token = dingSmartWorkService.getAccessToken();
    }

    @Test
    public void list() {
        List<String> userIdsList = new ArrayList<>();
        userIdsList.add("1");
        OapiSmartworkHrmEmployeeListResponse response = dingSmartWorkService.list(userIdsList, null, token);
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void queryPreentry() {
        OapiSmartworkHrmEmployeeQuerypreentryResponse response = dingSmartWorkService.queryPreentry(0, 50, token);
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void queryOnJob() {
        List<String> statusList = new ArrayList<>();
        OapiSmartworkHrmEmployeeQueryonjobResponse response = dingSmartWorkService.queryOnJob(statusList, 0, 50, token);
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void queryDimission() {
        OapiSmartworkHrmEmployeeQuerydimissionResponse response = dingSmartWorkService.queryDimission(0, 50, token);
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void listDimission() {
        List<String> userIdsList = new ArrayList<>();
        OapiSmartworkHrmEmployeeListdimissionResponse response = dingSmartWorkService.listDimission(userIdsList, token);
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void addPreentry() {
        OapiSmartworkHrmEmployeeAddpreentryRequest.PreEntryEmployeeAddParam param = new OapiSmartworkHrmEmployeeAddpreentryRequest.PreEntryEmployeeAddParam();
        OapiSmartworkHrmEmployeeAddpreentryResponse response = dingSmartWorkService.addPreentry(param, token);
        Assert.assertTrue(response.isSuccess());
    }
}