package com.bruce.dingding.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bruce.dingding.service.impl.DingExtContactServiceImpl;
import com.dingtalk.api.request.OapiExtcontactCreateRequest;
import com.dingtalk.api.request.OapiExtcontactUpdateRequest;
import com.dingtalk.api.response.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:36
 * @Author fzh
 */
public class DingExtContactServiceTest extends DingBaseServiceTest {
    private DingExtContactService dingExtContactService;

    private String extUserId = "0839560363941584";

    @Before
    public void setUp() throws Exception {
        dingExtContactService = new DingExtContactServiceImpl(agentId, appKey, appSecret);
        token = dingExtContactService.getAccessToken();
    }

    @Test
    public void listLabelGroups() {
        OapiExtcontactListlabelgroupsResponse response = dingExtContactService.listLabelGroups(1L, 10L, token);
        System.out.println(JSONObject.toJSONString(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void list() {
        OapiExtcontactListResponse response = dingExtContactService.list(1L, 10L, token);
        System.out.println(JSONObject.toJSONString(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void get() {
        OapiExtcontactGetResponse response = dingExtContactService.get(extUserId, token);
        System.out.println(JSON.toJSONString(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void add() {
        OapiExtcontactCreateRequest.OpenExtContact openExtContact = new OapiExtcontactCreateRequest.OpenExtContact();
        openExtContact.setTitle("Title");
        openExtContact.setLabelIds(Arrays.asList(2126070635L, 2126070637L, 2126070644L));
        openExtContact.setShareDeptIds(Arrays.asList(Long.valueOf(deptId)));
        openExtContact.setAddress("地址");
        openExtContact.setRemark("备注");
        openExtContact.setFollowerUserId("");
        openExtContact.setName("王总");
        openExtContact.setStateCode("86");
        openExtContact.setCompanyName("企业名称");
        openExtContact.setShareUserIds(Arrays.asList("", ""));
        openExtContact.setMobile("");
        OapiExtcontactCreateResponse response = dingExtContactService.add(openExtContact, token);
        System.out.println(JSONObject.toJSONString(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void update() {
        OapiExtcontactUpdateRequest.OpenExtContact openExtContact = new OapiExtcontactUpdateRequest.OpenExtContact();
        openExtContact.setUserId(extUserId);
        openExtContact.setTitle("Title1");
        openExtContact.setLabelIds(Arrays.asList(2126070635L, 2126070637L, 2126070644L));
        openExtContact.setShareDeptIds(Arrays.asList(Long.valueOf(deptId)));
        openExtContact.setAddress("地址1");
        openExtContact.setRemark("备注1");
        openExtContact.setFollowerUserId("");
        openExtContact.setName("姓名1");
        openExtContact.setCompanyName("企业名称1");
        openExtContact.setShareUserIds(Arrays.asList(""));
        OapiExtcontactUpdateResponse response = dingExtContactService.update(openExtContact, token);
        System.out.println(JSONObject.toJSONString(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void delete() {
        OapiExtcontactDeleteResponse response = dingExtContactService.delete(extUserId, token);
        System.out.println(JSONObject.toJSONString(response));
        Assert.assertNotNull(response);
    }
}