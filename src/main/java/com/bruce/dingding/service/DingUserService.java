package com.bruce.dingding.service;

import com.bruce.dingding.exception.DingDingException;
import com.dingtalk.api.request.OapiInactiveUserV2GetRequest;
import com.dingtalk.api.request.OapiUserCreateRequest;
import com.dingtalk.api.request.OapiUserUpdateRequest;
import com.dingtalk.api.response.*;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 10:48
 * @Author fzh
 */
public interface DingUserService extends DingBaseService {


    /**
     * 根据unionid获取用户userid
     *
     * @param unionId     员工在当前开发者企业账号范围内的唯一标识
     * @param accessToken access_token
     * @return userId
     */
    String getByUnionId(String unionId, String accessToken);

    /**
     * 获取用户详情 已测试
     *
     * @param userId      用户 id
     * @param accessToken access_token
     * @return GetUserInfoResp.UserGetResponse
     * @throws DingDingException DingDingException
     */
    OapiV2UserGetResponse.UserGetResponse getByUserId(String userId, String accessToken) throws DingDingException;

    /**
     * 获取部门用户userid列表 已测试
     *
     * @param deptId      部门id
     * @param accessToken access_token
     * @return OapiUserGetDeptMemberResponse
     * @throws DingDingException DingDingException
     */
    OapiUserGetDeptMemberResponse getDeptMemberIds(String deptId, String accessToken) throws DingDingException;

    /**
     * 获取部门用户列表 返回的简单信息  已测试
     *
     * @param deptId      部门id不能为空 获取的部门id，1表示根部门
     * @param offset      支持分页查询，与size参数同时设置时才生效，此参数代表偏移量 不能为空
     * @param size        支持分页查询，与offset参数同时设置时才生效，此参数代表分页大小，最大100 不能为空
     * @param order       可以为空 支持分页查询，部门成员的排序规则，默认不传是按自定义排序；
     *                    entry_asc：代表按照进入部门的时间升序，
     *                    entry_desc：代表按照进入部门的时间降序，
     *                    modify_asc：代表按照部门信息修改时间升序，
     *                    modify_desc：代表按照部门信息修改时间降序，
     *                    custom：代表用户定义(未定义时按照拼音)排序
     * @param accessToken access_token
     * @return OapiUserSimplelistResponse
     * @throws DingDingException DingDingException
     */
    OapiUserSimplelistResponse getSimpleList(Long deptId, Long offset, Long size, String order, String accessToken) throws DingDingException;

    /**
     * 获取部门用户列表 返回的详细信息 已测试
     *
     * @param deptId      部门id不能为空 获取的部门id，1表示根部门
     * @param offset      支持分页查询，与size参数同时设置时才生效，此参数代表偏移量 不能为空
     * @param size        支持分页查询，与offset参数同时设置时才生效，此参数代表分页大小，最大100 不能为空
     * @param order       可以为空 支持分页查询，部门成员的排序规则，默认不传是按自定义排序；
     *                    entry_asc：代表按照进入部门的时间升序，
     *                    entry_desc：代表按照进入部门的时间降序，
     *                    modify_asc：代表按照部门信息修改时间升序，
     *                    modify_desc：代表按照部门信息修改时间降序，
     *                    custom：代表用户定义(未定义时按照拼音)排序
     * @param accessToken access_token
     * @return OapiUserListbypageResponse
     * @throws DingDingException DingDingException
     */
    OapiUserListbypageResponse getDetailList(Long deptId, Long offset, Long size, String order, String accessToken) throws DingDingException;


    /**
     * 获取管理员 已测试
     *
     * @param accessToken access_token
     * @return OapiUserGetAdminResponse
     * @throws DingDingException DingDingException
     */
    OapiUserGetAdminResponse getAdmin(String accessToken) throws DingDingException;

    /**
     * 获取管理员通讯录权限范围 已测试
     *
     * @param userId      员工id
     * @param accessToken access_token
     * @return OapiUserGetAdminScopeResponse
     * @throws DingDingException DingDingException
     */
    OapiUserGetAdminScopeResponse getAdminScope(String userId, String accessToken) throws DingDingException;

    /**
     * 创建用户
     *
     * @param request     OapiUserCreateRequest
     * @param accessToken access_token
     * @return OapiUserCreateResponse
     * @throws DingDingException DingDingException
     */
    OapiUserCreateResponse create(OapiUserCreateRequest request, String accessToken) throws DingDingException;

    /**
     * 更新用户
     *
     * @param request     OapiUserUpdateRequest
     * @param accessToken access_token
     * @return OapiUserUpdateResponse
     * @throws DingDingException DingDingException
     */
    OapiUserUpdateResponse update(OapiUserUpdateRequest request, String accessToken) throws DingDingException;

    /**
     * 删除用户
     *
     * @param userId      员工id
     * @param accessToken access_token
     * @return OapiUserDeleteResponse
     * @throws DingDingException DingDingException
     */
    OapiUserDeleteResponse delete(String userId, String accessToken) throws DingDingException;

    /**
     * 获取企业员工人数
     *
     * @param onlyActive  false：包含未激活钉钉的人员数量
     *                    true：不包含未激活钉钉的人员数量
     * @param accessToken access_token
     * @return OapiUserGetOrgUserCountResponse
     * @throws DingDingException DingDingException
     */
    OapiUserGetOrgUserCountResponse getOrgUserCount(boolean onlyActive, String accessToken) throws DingDingException;

    /**
     * 获取未登录钉钉的员工列表
     *
     * @param accessToken access_token
     * @return OapiInactiveUserV2GetResponse
     * @throws DingDingException DingDingException
     */
    OapiInactiveUserV2GetResponse getInactiveUser(OapiInactiveUserV2GetRequest request, String accessToken) throws DingDingException;

    /**
     * 获取管理员的应用管理权限
     *
     * @param appId       应用ID。可在开发者后台 > 第三方企业应用的应用详情页获取AppID
     * @param userId      要查询的管理员员工ID
     * @param accessToken access_token
     * @return OapiUserCanAccessMicroappResponse
     * @throws DingDingException DingDingException
     */
    OapiUserCanAccessMicroappResponse getAccessMicroapp(Long appId, String userId, String accessToken) throws DingDingException;

    /**
     * 根据手机号获取userid
     *
     * @param mobile      手机号
     * @param accessToken access_token
     * @return OapiV2UserGetbymobileResponse
     * @throws DingDingException DingDingException
     */
    OapiV2UserGetbymobileResponse getByMobile(String mobile, String accessToken) throws DingDingException;


    /**
     * 通讯录权限范围 已测试
     *
     * @param token access_token
     * @return OapiAuthScopesResponse
     * @throws DingDingException
     */
    OapiAuthScopesResponse getScopes(String token) throws DingDingException;

}
