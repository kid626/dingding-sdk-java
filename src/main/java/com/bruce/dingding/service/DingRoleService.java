package com.bruce.dingding.service;

import com.dingtalk.api.response.OapiRoleAddRoleResponse;
import com.dingtalk.api.response.OapiRoleAddrolegroupResponse;
import com.dingtalk.api.response.OapiRoleAddrolesforempsResponse;
import com.dingtalk.api.response.OapiRoleDeleteroleResponse;
import com.dingtalk.api.response.OapiRoleGetroleResponse;
import com.dingtalk.api.response.OapiRoleGetrolegroupResponse;
import com.dingtalk.api.response.OapiRoleListResponse;
import com.dingtalk.api.response.OapiRoleRemoverolesforempsResponse;
import com.dingtalk.api.response.OapiRoleScopeUpdateResponse;
import com.dingtalk.api.response.OapiRoleSimplelistResponse;
import com.dingtalk.api.response.OapiRoleUpdateRoleResponse;
import com.bruce.dingding.exception.DingDingException;

import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 角色管理 服务层接口 https://developers.dingtalk.com/document/app/add-role
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 9:34
 * @Author fzh
 */
public interface DingRoleService extends DingBaseService {

    /**
     * 获取角色列表 已测试
     *
     * @param offset      分页偏移，默认值：0
     * @param size        分页大小，默认值：20，最大值200
     * @param accessToken access_token
     * @return OapiRoleListResponse
     * @throws DingDingException DingDingException
     */
    OapiRoleListResponse list(Long offset, Long size, String accessToken) throws DingDingException;

    /**
     * 获取角色下的员工列表 已测试
     *
     * @param offset      分页偏移，默认值：0
     * @param size        分页大小，默认值：20，最大值200
     * @param roleId      角色id
     * @param accessToken access_token
     * @return OapiRoleSimplelistResponse
     * @throws DingDingException DingDingException
     */
    OapiRoleSimplelistResponse getRoleUser(Long offset, Long size, Long roleId, String accessToken) throws DingDingException;

    /**
     * 获取角色组 已测试
     *
     * @param groupId     角色组的Id
     * @param accessToken access_token
     * @return OapiRoleGetrolegroupResponse
     * @throws DingDingException DingDingException
     */
    OapiRoleGetrolegroupResponse getRoleGroup(Long groupId, String accessToken) throws DingDingException;

    /**
     * 获取角色详情 已测试
     *
     * @param roleId
     * @param accessToken access_token
     * @return OapiRoleGetroleResponse
     * @throws DingDingException DingDingException
     */
    OapiRoleGetroleResponse getRole(Long roleId, String accessToken) throws DingDingException;

    /**
     * 创建角色 已测试
     *
     * @param roleName    必须 角色名称
     * @param groupId     必须 角色组id
     * @param accessToken access_token
     * @return OapiRoleAddRoleResponse
     * @throws DingDingException DingDingException
     */
    OapiRoleAddRoleResponse add(String roleName, Long groupId, String accessToken) throws DingDingException;

    /**
     * 更新角色 已测试
     *
     * @param roleName    角色名称
     * @param roleId      角色id
     * @param accessToken access_token
     * @return OapiRoleUpdateRoleResponse
     * @throws DingDingException DingDingException
     */
    OapiRoleUpdateRoleResponse update(String roleName, Long roleId, String accessToken) throws DingDingException;

    /**
     * 删除角色 已测试
     *
     * @param roleId      角色id
     * @param accessToken access_token
     * @return OapiRoleDeleteroleResponse
     * @throws DingDingException DingDingException
     */
    OapiRoleDeleteroleResponse delete(Long roleId, String accessToken) throws DingDingException;

    /**
     * 创建角色组 已测试
     *
     * @param name
     * @param accessToken access_token
     * @return OapiRoleAddrolegroupResponse
     * @throws DingDingException DingDingException
     */
    OapiRoleAddrolegroupResponse addRoleGroup(String name, String accessToken) throws DingDingException;

    /**
     * 批量增加员工角色 已测试
     *
     * @param roleIds     角色id list，最大列表长度：20
     * @param userIds     员工id list，最大列表长度：100
     * @param accessToken access_token
     * @return OapiRoleAddrolesforempsResponse
     * @throws DingDingException DingDingException
     */
    OapiRoleAddrolesforempsResponse addRolesUsers(List<String> roleIds, List<String> userIds, String accessToken) throws DingDingException;

    /**
     * 批量删除员工角色 已测试
     *
     * @param roleIds     角色id list，最大列表长度：20
     * @param userIds     员工id list，最大列表长度：100
     * @param accessToken access_token
     * @return OapiRoleRemoverolesforempsResponse
     * @throws DingDingException DingDingException
     */
    OapiRoleRemoverolesforempsResponse deleteRolesUsers(List<String> roleIds, List<String> userIds, String accessToken) throws DingDingException;


    /**
     * 设定角色成员管理范围
     *
     * @param userId      员工在企业中的userid。
     * @param roleId      角色ID
     * @param deptIds     部门ID列表数，多个部门id之间使用逗号分隔，最多50个，不传则设置范围为所有人。
     * @param accessToken access_token
     * @return OapiRoleScopeUpdateResponse
     * @throws DingDingException DingDingException
     */
    OapiRoleScopeUpdateResponse updateRoleScope(String userId, Long roleId, List<String> deptIds, String accessToken) throws DingDingException;
}