package com.bruce.dingding.service;

import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.request.OapiProcessinstanceGetRequest;
import com.dingtalk.api.request.OapiProcessinstanceListidsRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
import com.dingtalk.api.response.OapiProcessinstanceListidsResponse;
import com.bruce.dingding.exception.DingDingException;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 钉钉审批相关接口 https://ding-doc.dingtalk.com/doc#/serverapi2/cmct1a
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 10:48
 * @Author fzh
 */
public interface DingApprovalService extends DingBaseService {

    /**
     * 发起审批实例
     *
     * @param req OapiProcessinstanceCreateRequest
     * @return OapiProcessinstanceCreateResponse
     */
    OapiProcessinstanceCreateResponse approvalCreate(OapiProcessinstanceCreateRequest req, String token) throws DingDingException;

    /**
     * 批量获取审理实例 id
     *
     * @param req OapiProcessinstanceListidsRequest
     * @return OapiProcessinstanceListidsResponse
     */
    OapiProcessinstanceListidsResponse approvalList(OapiProcessinstanceListidsRequest req, String token) throws DingDingException;

    /**
     * 获取审批实例详情
     *
     * @param req OapiProcessinstanceGetRequest
     * @return OapiProcessinstanceGetResponse
     */
    OapiProcessinstanceGetResponse approvalGet(OapiProcessinstanceGetRequest req, String token) throws DingDingException;


}
