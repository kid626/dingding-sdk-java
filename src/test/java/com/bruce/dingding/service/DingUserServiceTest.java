package com.bruce.dingding.service;

import com.bruce.dingding.service.impl.DingUserServiceImpl;
import com.dingtalk.api.request.OapiInactiveUserV2GetRequest;
import com.dingtalk.api.response.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:37
 * @Author fzh
 */
public class DingUserServiceTest extends DingBaseServiceTest {

    private DingUserService dingUserService = null;

    @Before
    public void setUp() {
        dingUserService = new DingUserServiceImpl(agentId, appKey, appSecret);
        token = dingUserService.getAccessToken();
    }


    @Test
    public void getByUnionId() {
        String unionid = "";
        String userId = dingUserService.getByUnionId(unionid, token);
        Assert.assertNotNull(userId);
    }

    @Test
    public void getByUserId() {
        String userId = "";
        OapiV2UserGetResponse.UserGetResponse response = dingUserService.getByUserId(userId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getDeptMemberIds() {
        String deptId = "1";
        OapiUserGetDeptMemberResponse response = dingUserService.getDeptMemberIds(deptId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getSimpleList() {
        OapiUserSimplelistResponse response = dingUserService.getSimpleList(1L, 1L, 10L, null, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getDetailList() {
        OapiUserListbypageResponse response = dingUserService.getDetailList(379753107L, 1L, 100L, null, token);
        for (OapiUserListbypageResponse.Userlist user : response.getUserlist()) {
            System.out.println(user);
        }
        Assert.assertNotNull(response);
    }

    @Test
    public void getAdmin() {
        OapiUserGetAdminResponse response = dingUserService.getAdmin(token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getAdminScope() {
        String userId = "1";
        OapiUserGetAdminScopeResponse response = dingUserService.getAdminScope(userId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void create() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getOrgUserCount() {
        OapiUserGetOrgUserCountResponse response = dingUserService.getOrgUserCount(true, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getInactiveUser() {
        OapiInactiveUserV2GetRequest req = new OapiInactiveUserV2GetRequest();
        req.setIsActive(false);
        //req.setDeptIds("1,2,3");
        req.setOffset(0L);
        req.setSize(100L);
        req.setQueryDate("");
        OapiInactiveUserV2GetResponse response = dingUserService.getInactiveUser(req, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getAccessMicroapp() {
        Long appId = null;
        String userId = "";
        OapiUserCanAccessMicroappResponse response = dingUserService.getAccessMicroapp(appId, userId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getByMobile() {
        OapiV2UserGetbymobileResponse response = dingUserService.getByMobile("", token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getScopes() {
        OapiAuthScopesResponse resp = dingUserService.getScopes(token);
        System.out.println(resp);
    }
}