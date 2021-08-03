package com.bruce.dingding.service.impl;

import com.bruce.dingding.entity.constants.UrlConstant;
import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.service.DingSmartWorkService;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 钉钉智能人事服务层
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:09
 * @Author fzh
 */
public class DingSmartWorkServiceImpl extends DingBaseServiceImpl implements DingSmartWorkService {

    /**
     * @param agentId   应用agentId
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public DingSmartWorkServiceImpl(Long agentId, String appKey, String appSecret) {
        super(agentId, appKey, appSecret);
    }

    @Override
    public OapiSmartworkHrmEmployeeListResponse list(List<String> userIdsList, List<String> fieldFilterList, String accessToken) throws DingDingException {
        if (userIdsList == null || userIdsList.size() == 0) {
            throw new DingDingException("userIdsList NOT EMPTY!");
        }
        int userMax = 50;
        if (userIdsList.size() > userMax) {
            throw new DingDingException("userIdsList max size is " + userMax + "!");
        }
        int fieldMax = 20;
        if (fieldFilterList != null && fieldFilterList.size() > fieldMax) {
            throw new DingDingException("fieldFilterList max size is " + fieldMax + "!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.SW_EMP_LIST);
            OapiSmartworkHrmEmployeeListRequest req = new OapiSmartworkHrmEmployeeListRequest();
            req.setUseridList(StringUtils.join(userIdsList.toArray(), ","));
            if (fieldFilterList != null && fieldFilterList.size() > 0) {
                req.setFieldFilterList(StringUtils.join(fieldFilterList.toArray(), ","));
            }
            OapiSmartworkHrmEmployeeListResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiSmartworkHrmEmployeeQuerypreentryResponse queryPreentry(int offset, int size, String accessToken) throws DingDingException {
        if (offset < 0) {
            throw new DingDingException("offset >= 0 !");
        }
        if (size > 50 || size < 1) {
            throw new DingDingException("size >= 1 and size<= 50 !");
        }

        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.SW_EMP_PRE);
            OapiSmartworkHrmEmployeeQuerypreentryRequest req = new OapiSmartworkHrmEmployeeQuerypreentryRequest();
            req.setOffset((long) offset);
            req.setSize((long) size);
            OapiSmartworkHrmEmployeeQuerypreentryResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiSmartworkHrmEmployeeQueryonjobResponse queryOnJob(List<String> statusList, int offset, int size, String accessToken) throws DingDingException {
        if (statusList == null || statusList.size() == 0) {
            throw new DingDingException("statusList NOT EMPTY!");
        }
        if (offset < 0) {
            throw new DingDingException("offset >= 0 !");
        }
        if (size > 50 || size < 1) {
            throw new DingDingException("size >= 1 and size<= 50 !");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.SW_EMP_ON_JOB);
            OapiSmartworkHrmEmployeeQueryonjobRequest req = new OapiSmartworkHrmEmployeeQueryonjobRequest();
            req.setStatusList(StringUtils.join(statusList.toArray(), ","));
            req.setOffset((long) offset);
            req.setSize((long) size);
            OapiSmartworkHrmEmployeeQueryonjobResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiSmartworkHrmEmployeeQuerydimissionResponse queryDimission(int offset, int size, String accessToken) throws DingDingException {
        if (offset < 0) {
            throw new DingDingException("offset >= 0 !");
        }
        if (size > 50 || size < 1) {
            throw new DingDingException("size >= 1 and size<= 50 !");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.SW_EMP_DISMISSION);
            OapiSmartworkHrmEmployeeQuerydimissionRequest req = new OapiSmartworkHrmEmployeeQuerydimissionRequest();
            req.setOffset((long) offset);
            req.setSize((long) size);
            OapiSmartworkHrmEmployeeQuerydimissionResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiSmartworkHrmEmployeeListdimissionResponse listDimission(List<String> userIdsList, String accessToken) throws DingDingException {
        if (userIdsList == null || userIdsList.size() == 0) {
            throw new DingDingException("userIdsList NOT EMPTY!");
        }
        int userMax = 50;
        if (userIdsList.size() > userMax) {
            throw new DingDingException("userIdsList max size is " + userMax + "!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.SW_EMP_LIST_DISMISSION);
            OapiSmartworkHrmEmployeeListdimissionRequest req = new OapiSmartworkHrmEmployeeListdimissionRequest();
            req.setUseridList(StringUtils.join(userIdsList.toArray(), ","));
            OapiSmartworkHrmEmployeeListdimissionResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiSmartworkHrmEmployeeAddpreentryResponse addPreentry(OapiSmartworkHrmEmployeeAddpreentryRequest.PreEntryEmployeeAddParam param, String accessToken) {
        if (param == null) {
            throw new DingDingException("param NOT NULL!");
        }
        if (StringUtils.isEmpty(param.getName())) {
            throw new DingDingException("name IS NOT EMPTY!");
        }
        if (StringUtils.isEmpty(param.getMobile())) {
            throw new DingDingException("mobile IS NOT EMPTY!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.SW_ADD_PRE);
            OapiSmartworkHrmEmployeeAddpreentryRequest req = new OapiSmartworkHrmEmployeeAddpreentryRequest();
            req.setParam(param);
            OapiSmartworkHrmEmployeeAddpreentryResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }
}
