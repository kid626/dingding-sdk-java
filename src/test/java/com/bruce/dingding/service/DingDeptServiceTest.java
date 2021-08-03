package com.bruce.dingding.service;

import com.bruce.dingding.service.impl.DingDeptServiceImpl;
import com.dingtalk.api.request.OapiDepartmentCreateRequest;
import com.dingtalk.api.request.OapiDepartmentUpdateRequest;
import com.dingtalk.api.response.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:35
 * @Author fzh
 */
public class DingDeptServiceTest extends DingBaseServiceTest {

    private DingDeptService dingDeptService;

    @Before
    public void setUp() throws Exception {
        dingDeptService = new DingDeptServiceImpl(agentId, appKey, appSecret);
        token = dingDeptService.getAccessToken();
    }

    @Test
    public void getSubDept() {
        OapiDepartmentListIdsResponse response = dingDeptService.getSubDept(deptId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getDeptList() {
        OapiDepartmentListResponse response = dingDeptService.getDeptList("", null, "", token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getDeptDetail() {
        OapiDepartmentGetResponse response = dingDeptService.getDeptDetail(null, deptId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getParentDeptsByDept() {
        OapiDepartmentListParentDeptsByDeptResponse response = dingDeptService.getParentDeptsByDept(deptId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void createDept() {
        OapiDepartmentCreateRequest request = new OapiDepartmentCreateRequest();
        request.setParentid(deptId);
        request.setName("测试部门");
        OapiDepartmentCreateResponse response = dingDeptService.createDept(request, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void updateDept() {
        String deptId = "516091209";
        OapiDepartmentUpdateRequest request = new OapiDepartmentUpdateRequest();
        request.setName("测试部门007");
        request.setId(Long.valueOf(deptId));
        OapiDepartmentUpdateResponse response = dingDeptService.updateDept(request, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void deleteDept() {
        String deptId = "516091209";
        OapiDepartmentDeleteResponse response = dingDeptService.deleteDept(deptId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getDepartmentListParentbyUser() {
        OapiV2DepartmentListparentbyuserResponse response = dingDeptService.getDepartmentListParentbyUser(userId, token);
        Assert.assertNotNull(response);
    }
}