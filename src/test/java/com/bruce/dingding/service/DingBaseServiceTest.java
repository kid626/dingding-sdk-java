package com.bruce.dingding.service;

import com.bruce.dingding.service.impl.DingBaseServiceImpl;
import com.dingtalk.api.response.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:29
 * @Author fzh
 */
public class DingBaseServiceTest {

    Long agentId = 852473199L;
    String appKey = "***";
    String appSecret = "***";
    String token = "";
    // 一些用户信息
    String userId = "***";
    String unionId = "***";
    String deptId = "1";
    private DingBaseService dingBaseService;

    @Before
    public void before() {
        dingBaseService = new DingBaseServiceImpl(agentId, appKey, appSecret);
        token = dingBaseService.getAccessToken();
    }


    @Test
    public void getRealToken() {
        OapiGettokenResponse resp = dingBaseService.getRealToken();
        System.out.println(resp);
    }

    @Test
    public void getAccessToken() {
        String token = dingBaseService.getAccessToken();
        System.out.println(token);
    }

    @Test
    public void getJsapiRealToken() {
        OapiGetJsapiTicketResponse resp = dingBaseService.getJsapiRealToken(token);
        System.out.println(resp);
    }

    @Test
    public void getJsapiToken() {
        String jsapiToken = dingBaseService.getJsapiToken(token);
        System.out.println(jsapiToken);
    }

    @Test
    public void getUserInfo() {
        OapiUserGetuserinfoResponse resp = dingBaseService.getUserInfo("ff53a60e927a344e8fe981018b1a5222", token);
        System.out.println(resp);
    }

    @Test
    public void getUserInfoV2() {
        OapiV2UserGetuserinfoResponse resp = dingBaseService.getUserInfoV2("2d8bf4d9e154343abd144c76bfdd823e", token);
        System.out.println(resp);
    }

    @Test
    public void getUserInfoByCode() {
        OapiSnsGetuserinfoBycodeResponse resp = dingBaseService.getUserInfoByCode("code");
        System.out.println(resp);
    }

}
