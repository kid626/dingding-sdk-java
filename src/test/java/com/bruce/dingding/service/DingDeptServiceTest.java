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

    private String deptId = "";
    private String userId = "";

    @Before
    public void setUp() throws Exception {
        dingDeptService = new DingDeptServiceImpl(agentId, appKey, appSecret);
        token = dingDeptService.getAccessToken();
    }

    @Test
    public void getSubDept() {
        OapiDepartmentListIdsResponse response = dingDeptService.getSubDept("1", token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getDeptList() {
        OapiDepartmentListResponse response = dingDeptService.getDeptList("", null, "", token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getDeptDetail() {
        OapiDepartmentGetResponse response = dingDeptService.getDeptDetail(null, "1", token);
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
        request.setParentid("1");
        request.setName("测试部门");
        OapiDepartmentCreateResponse response = dingDeptService.createDept(request, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void updateDept() {
        String deptId = "113011110";
        OapiDepartmentUpdateRequest request = new OapiDepartmentUpdateRequest();
        request.setName("应用研发部");
        request.setId(Long.valueOf(deptId));
        OapiDepartmentUpdateResponse response = dingDeptService.updateDept(request, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void deleteDept() {
        String deptId = "113011110";
        OapiDepartmentDeleteResponse response = dingDeptService.deleteDept(deptId, token);
        Assert.assertNotNull(response);
    }

    @Test
    public void getDepartmentListParentbyUser() {
        OapiV2DepartmentListparentbyuserResponse response = dingDeptService.getDepartmentListParentbyUser(userId, token);
        Assert.assertNotNull(response);
    }
}