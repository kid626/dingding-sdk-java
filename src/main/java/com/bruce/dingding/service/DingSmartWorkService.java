package com.bruce.dingding.service;

import com.bruce.dingding.exception.DingDingException;
import com.dingtalk.api.request.OapiSmartworkHrmEmployeeAddpreentryRequest;
import com.dingtalk.api.response.*;

import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 钉钉智能人事服务层 https://developers.dingtalk.com/document/app/intelligent-personnel-call-description
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:08
 * @Author fzh
 */
public interface DingSmartWorkService extends DingBaseService {

    /**
     * 获取员工花名册字段信息
     *
     * @param userIdsList     是 员工userid列表，最大列表长度：50
     * @param fieldFilterList 否 需要获取的花名册字段列表，最大列表长度：20。具体业务字段的code参见附录（大小写敏感）。不传入该参数时，企业可获取所有字段信息。
     * @param accessToken     access_token
     * @return OapiSmartworkHrmEmployeeListResponse
     * @throws DingDingException DingDingException
     */
    OapiSmartworkHrmEmployeeListResponse list(List<String> userIdsList, List<String> fieldFilterList, String accessToken) throws DingDingException;

    /**
     * 分页查询企业待入职员工userid列表。
     *
     * @param offset      分页游标，从0开始
     * @param size        分页大小，最大50
     * @param accessToken access_token
     * @return OapiSmartworkHrmEmployeeQuerypreentryResponse
     * @throws DingDingException DingDingException
     */
    OapiSmartworkHrmEmployeeQuerypreentryResponse queryPreentry(int offset, int size, String accessToken) throws DingDingException;

    /**
     * 分页查询企业在职员工userid列表。
     *
     * @param statusList  是 在职员工子状态筛选，其他状态无效。2，试用期；3，正式；5，待离职；-1，无状态
     * @param offset      是 分页游标，从0开始
     * @param size        是 分页大小，最大50
     * @param accessToken access_token
     * @return OapiSmartworkHrmEmployeeQueryonjobResponse
     * @throws DingDingException DingDingException
     */
    OapiSmartworkHrmEmployeeQueryonjobResponse queryOnJob(List<String> statusList, int offset, int size, String accessToken) throws DingDingException;

    /**
     * 分页查询企业离职员工userid列表。
     *
     * @param offset      是 分页游标，从0开始
     * @param size        是 分页大小，最大50
     * @param accessToken access_token
     * @return OapiSmartworkHrmEmployeeQuerydimissionResponse
     * @throws DingDingException DingDingException
     */
    OapiSmartworkHrmEmployeeQuerydimissionResponse queryDimission(int offset, int size, String accessToken) throws DingDingException;

    /**
     * 根据员工userid列表，批量查询员工的离职信息。传入非离职员工userid，不会返回信息。
     *
     * @param userIdsList 是 员工userid列表，最大长度50
     * @param accessToken access_token
     * @return OapiSmartworkHrmEmployeeListdimissionResponse
     * @throws DingDingException DingDingException
     */
    OapiSmartworkHrmEmployeeListdimissionResponse listDimission(List<String> userIdsList, String accessToken) throws DingDingException;

    /**
     * 添加企业待入职员工
     *
     * @param param       OapiSmartworkHrmEmployeeAddpreentryRequest.PreEntryEmployeeAddParam
     * @param accessToken access_token
     * @return OapiSmartworkHrmEmployeeAddpreentryResponse
     * @throws DingDingException DingDingException
     */
    OapiSmartworkHrmEmployeeAddpreentryResponse addPreentry(OapiSmartworkHrmEmployeeAddpreentryRequest.PreEntryEmployeeAddParam param, String accessToken) throws DingDingException;


}
