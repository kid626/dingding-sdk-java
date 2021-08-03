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

    Long agentId = 0L;
    String appKey = "ding****";
    String appSecret = "****";
    String token = "";
    private DingBaseService dingBaseService;

    @Before
    public void before() {
        dingBaseService = new DingBaseServiceImpl(agentId, appKey, appSecret);
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
        OapiGetJsapiTicketResponse resp = dingBaseService.getJsapiRealToken(dingBaseService.getAccessToken());
        System.out.println(resp);
    }

    @Test
    public void getJsapiToken() {
        String jsapiToken = dingBaseService.getJsapiToken(dingBaseService.getAccessToken());
        System.out.println(jsapiToken);
    }

    @Test
    public void getUserInfo() {
        OapiUserGetuserinfoResponse resp = dingBaseService.getUserInfo("code", dingBaseService.getAccessToken());
        System.out.println(resp);
    }

    @Test
    public void getUserInfoV2() {
        OapiV2UserGetuserinfoResponse resp = dingBaseService.getUserInfoV2("code", dingBaseService.getAccessToken());
        System.out.println(resp);
    }

    @Test
    public void getUserInfoByCode() {
        OapiSnsGetuserinfoBycodeResponse resp = dingBaseService.getUserInfoByCode("code");
        System.out.println(resp);
    }

}
