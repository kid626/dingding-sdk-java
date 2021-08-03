package com.bruce.dingding.service;

import com.alibaba.fastjson.JSON;
import com.bruce.dingding.service.impl.DingRoleServiceImpl;
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
public class DingRoleServiceTest extends DingBaseServiceTest {

    private DingRoleService dingRoleService;

    @Before
    public void setUp() throws Exception {
        dingRoleService = new DingRoleServiceImpl(agentId, appKey, appSecret);
        token = dingRoleService.getAccessToken();
    }

    @Test
    public void list() {
        OapiRoleListResponse response = dingRoleService.list(1L, 1L, token);
        System.out.println(JSON.toJSONString(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void getRoleUser() {
        OapiRoleSimplelistResponse response = dingRoleService.getRoleUser(1L, 1L, 441958223L, token);
        System.out.println(JSON.toJSONString(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void getRoleGroup() {
        OapiRoleGetrolegroupResponse response = dingRoleService.getRoleGroup(441891578L, token);
        System.out.println(JSON.toJSONString(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void getRole() {
        OapiRoleGetroleResponse response = dingRoleService.getRole(441958223L, token);
        System.out.println(JSON.toJSONString(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void add() {
        //{"errmsg":"ok","roleId":441958223,"errcode":0}
        Long groupId = 0L;
        OapiRoleAddRoleResponse response = dingRoleService.add("角色3", groupId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void update() {
        Long roleId = 0L;
        OapiRoleUpdateRoleResponse response = dingRoleService.update("角色2", roleId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void delete() {
        Long roleId = 0L;
        OapiRoleDeleteroleResponse response = dingRoleService.delete(roleId, token);
        System.out.println(JSON.toJSONString(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void addRoleGroup() {
        OapiRoleAddrolegroupResponse response = dingRoleService.addRoleGroup("角色分组", token);
        Assert.assertNotNull(response);
    }

    @Test
    public void addRolesUsers() {
        List<String> roleIds = new ArrayList<>();
        roleIds.add("");
        List<String> userIds = new ArrayList<>();
        userIds.add("");

        OapiRoleAddrolesforempsResponse response = dingRoleService.addRolesUsers(roleIds, userIds, token);
        System.out.println(JSON.toJSONString(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void deleteRolesUsers() {
        List<String> roleIds = new ArrayList<>();
        roleIds.add("");
        List<String> userIds = new ArrayList<>();
        userIds.add("");

        OapiRoleRemoverolesforempsResponse response = dingRoleService.deleteRolesUsers(roleIds, userIds, token);
        System.out.println(JSON.toJSONString(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void updateRoleScope() {
        //TODO:参数错误
        String userId = "";
        Long roleId = 0L;
        List<String> deptIds = new ArrayList<>(1);
        deptIds.add("1");
        OapiRoleScopeUpdateResponse response = dingRoleService.updateRoleScope(userId, roleId, deptIds, token);
        Assert.assertNotNull(response);
    }
}