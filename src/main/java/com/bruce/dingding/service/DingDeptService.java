package com.bruce.dingding.service;

import com.bruce.dingding.exception.DingDingException;
import com.dingtalk.api.request.OapiDepartmentCreateRequest;
import com.dingtalk.api.request.OapiDepartmentUpdateRequest;
import com.dingtalk.api.response.*;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 部门管理2.0 https://developers.dingtalk.com/document/app/create-a-department-v2
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 10:48
 * @Author fzh
 */
public interface DingDeptService extends DingBaseService {
    /**
     * 获取所有子部门 已测试
     *
     * @param id          父部门id。根部门的话传1 (如果不传，默认部门为根部门，根部门ID为1）
     * @param accessToken access_token
     * @return OapiDepartmentListIdsResponse
     * @throws DingDingException DingDingException
     */
    OapiDepartmentListIdsResponse getSubDept(String id, String accessToken) throws DingDingException;

    /**
     * 获取部门列表 已测试
     *
     * @param lang        通讯录语言（默认zh_CN，未来会支持en_US）
     * @param fetchChild  是否递归部门的全部子部门，ISV微应用固定传递false
     * @param id          父部门id（如果不传，默认部门为根部门，根部门ID为1）
     * @param accessToken access_token
     * @return OapiDepartmentListResponse
     * @throws DingDingException DingDingException
     */
    OapiDepartmentListResponse getDeptList(String lang, Boolean fetchChild, String id, String accessToken) throws DingDingException;

    /**
     * 获取部门详情 已测试
     *
     * @param lang  通讯录语言(默认zh_CN，未来会支持en_US)
     * @param id    部门id 必填
     * @param token access_token
     * @return OapiDepartmentGetResponse
     * @throws DingDingException DingDingException
     */
    OapiDepartmentGetResponse getDeptDetail(String lang, String id, String token) throws DingDingException;

    /**
     * 查询部门的所有上级父部门路径 已测试
     *
     * @param id          部门 id
     * @param accessToken access_token
     * @return OapiDepartmentListParentDeptsByDeptResponse
     * @throws DingDingException DingDingException
     */
    OapiDepartmentListParentDeptsByDeptResponse getParentDeptsByDept(String id, String accessToken) throws DingDingException;


    /**
     * 创建部门 已测试  https://open-doc.dingtalk.com/microapp/serverapi2/dubakq
     *
     * @param request     OapiDepartmentCreateRequest
     * @param accessToken access_token
     * @return OapiDepartmentCreateResponse
     * @throws DingDingException DingDingException
     */
    OapiDepartmentCreateResponse createDept(OapiDepartmentCreateRequest request, String accessToken) throws DingDingException;

    /**
     * 更新部门 已测试
     *
     * @param request     OapiDepartmentUpdateRequest
     * @param accessToken access_token
     * @return OapiDepartmentUpdateResponse
     * @throws DingDingException DingDingException
     */
    OapiDepartmentUpdateResponse updateDept(OapiDepartmentUpdateRequest request, String accessToken) throws DingDingException;

    /**
     * 删除部门  已测试
     *
     * @param id          (注：不能删除根部门；不能删除含有子部门、成员的部门)
     * @param accessToken access_token
     * @return OapiDepartmentDeleteResponse
     * @throws DingDingException DingDingException
     */
    OapiDepartmentDeleteResponse deleteDept(String id, String accessToken) throws DingDingException;


    /**
     * 获取指定用户的所有父部门列表
     *
     * @param userId      用户 id
     * @param accessToken access_token
     * @return OapiV2DepartmentListparentbyuserResponse
     * @throws DingDingException DingDingException
     */
    OapiV2DepartmentListparentbyuserResponse getDepartmentListParentbyUser(String userId, String accessToken) throws DingDingException;

}
