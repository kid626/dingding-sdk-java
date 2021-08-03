package com.bruce.dingding.service;

import com.dingtalk.api.request.OapiIndustryDepartmentListRequest;
import com.dingtalk.api.request.OapiIndustryUserListRequest;
import com.dingtalk.api.response.OapiIndustryDepartmentGetResponse;
import com.dingtalk.api.response.OapiIndustryDepartmentListResponse;
import com.dingtalk.api.response.OapiIndustryOrganizationGetResponse;
import com.dingtalk.api.response.OapiIndustryUserGetResponse;
import com.dingtalk.api.response.OapiIndustryUserListResponse;
import com.bruce.dingding.exception.DingDingException;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 行业通讯录 https://developers.dingtalk.com/document/app/apply-for-industry-contact-api-permission
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 15:08
 * @Author fzh
 */
public interface DingIndustryAddressService extends DingBaseService {

    /**
     * 获取部门详情
     *
     * @param deptId      部门主键
     * @param accessToken access_token
     * @return OapiIndustryDepartmentGetResponse
     * @throws DingDingException DingDingException
     */
    OapiIndustryDepartmentGetResponse detail(Long deptId, String accessToken) throws DingDingException;

    /**
     * 获取部门下人员列表
     *
     * @param request     OapiIndustryUserListRequest
     * @param accessToken access_token
     * @return OapiIndustryUserListResponse
     * @throws DingDingException DingDingException
     */
    OapiIndustryUserListResponse getUserList(OapiIndustryUserListRequest request, String accessToken) throws DingDingException;

    /**
     * 获取部门列表
     *
     * @param request     OapiIndustryDepartmentListRequest
     * @param accessToken access_token
     * @return OapiIndustryDepartmentListResponse
     * @throws DingDingException DingDingException
     */
    OapiIndustryDepartmentListResponse getList(OapiIndustryDepartmentListRequest request, String accessToken) throws DingDingException;


    /**
     * 获取部门用户详情
     *
     * @param deptId      部门主键
     * @param userId      用户主键
     * @param accessToken access_token
     * @return OapiIndustryUserGetResponse
     * @throws DingDingException DingDingException
     */
    OapiIndustryUserGetResponse getUserById(Long deptId, String userId, String accessToken) throws DingDingException;

    /**
     * 获取企业信息
     *
     * @param accessToken access_token
     * @return OapiIndustryOrganizationGetResponse
     * @throws DingDingException DingDingException
     */
    OapiIndustryOrganizationGetResponse getIndustryOrganization(String accessToken) throws DingDingException;

}
