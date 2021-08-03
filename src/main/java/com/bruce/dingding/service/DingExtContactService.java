package com.bruce.dingding.service;

import com.dingtalk.api.request.OapiExtcontactCreateRequest;
import com.dingtalk.api.request.OapiExtcontactUpdateRequest;
import com.dingtalk.api.response.*;
import com.bruce.dingding.exception.DingDingException;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 外部联系人管理 https://developers.dingtalk.com/document/app/add-enterprise-external-contacts
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 12:58
 * @Author fzh
 */
public interface DingExtContactService extends DingBaseService {

    /**
     * 获取外部联系人标签列表 已测试
     *
     * @param offset      分页偏移量
     * @param size        分页大小，最大100
     * @param accessToken access_token
     * @return OapiExtcontactListlabelgroupsResponse
     * @throws DingDingException DingDingException
     */
    OapiExtcontactListlabelgroupsResponse listLabelGroups(Long offset, Long size, String accessToken) throws DingDingException;

    /**
     * 获取外部联系人列表 已测试
     *
     * @param offset      分页偏移量
     * @param size        分页大小，最大100
     * @param accessToken access_token
     * @return OapiExtcontactListResponse
     * @throws DingDingException DingDingException
     */
    OapiExtcontactListResponse list(Long offset, Long size, String accessToken) throws DingDingException;

    /**
     * 获取企业外部联系人详情 已测试
     *
     * @param userId      外部联系人的userId
     * @param accessToken access_token
     * @return OapiExtcontactGetResponse
     * @throws DingDingException DingDingException
     */
    OapiExtcontactGetResponse get(String userId, String accessToken) throws DingDingException;

    /**
     * 添加外部联系人 已测试
     *
     * @param openExtContact OpenExtContact
     * @param accessToken    access_token
     * @return OapiExtcontactCreateResponse
     * @throws DingDingException DingDingException
     */
    OapiExtcontactCreateResponse add(OapiExtcontactCreateRequest.OpenExtContact openExtContact, String accessToken) throws DingDingException;

    /**
     * 更新外部联系人 已测试
     *
     * @param openExtContact OpenExtContact
     * @param accessToken    access_token
     * @return OapiExtcontactUpdateResponse
     * @throws DingDingException DingDingException
     */
    OapiExtcontactUpdateResponse update(OapiExtcontactUpdateRequest.OpenExtContact openExtContact, String accessToken) throws DingDingException;

    /**
     * 删除外部联系人 已测试
     *
     * @param userId      外部联系人的userId
     * @param accessToken access_token
     * @return OapiExtcontactDeleteResponse
     * @throws DingDingException DingDingException
     */
    OapiExtcontactDeleteResponse delete(String userId, String accessToken) throws DingDingException;

}
