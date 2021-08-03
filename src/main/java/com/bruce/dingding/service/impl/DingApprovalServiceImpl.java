package com.bruce.dingding.service.impl;

import com.bruce.dingding.entity.constants.UrlConstant;
import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.service.DingApprovalService;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.request.OapiProcessinstanceGetRequest;
import com.dingtalk.api.request.OapiProcessinstanceListidsRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
import com.dingtalk.api.response.OapiProcessinstanceListidsResponse;
import com.taobao.api.ApiException;
import org.apache.commons.lang3.StringUtils;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 钉钉审批相关接口实现
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 10:48
 * @Author fzh
 */
public class DingApprovalServiceImpl extends DingBaseServiceImpl implements DingApprovalService {
    /**
     * @param agentId   应用agentId
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public DingApprovalServiceImpl(Long agentId, String appKey, String appSecret) {
        super(agentId, appKey, appSecret);
    }

    @Override
    public OapiProcessinstanceCreateResponse approvalCreate(OapiProcessinstanceCreateRequest req, String accessToken) throws DingDingException {
        if (req.getAgentId() == null) {
            throw new DingDingException("agentId 不能为空");
        }
        if (StringUtils.isEmpty(req.getProcessCode())) {
            throw new DingDingException("processCode 不能为空");
        }
        if (StringUtils.isEmpty(req.getOriginatorUserId())) {
            throw new DingDingException("发起人的 userId 不能为空");
        }
        if (StringUtils.isEmpty(req.getFormComponentValues())) {
            throw new DingDingException("form_component_values 不能为空");
        }
        req.setCcPosition("FINISH");
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient(UrlConstant.URL_PROCESSINSTANCE_START);
            OapiProcessinstanceCreateResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiProcessinstanceListidsResponse approvalList(OapiProcessinstanceListidsRequest req, String token) throws DingDingException {
        // TODO
        return null;
    }

    @Override
    public OapiProcessinstanceGetResponse approvalGet(OapiProcessinstanceGetRequest req, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(req.getProcessInstanceId())) {
            throw new DingDingException("审批实例id 不能为空");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.URL_PROCESSINSTANCE_GET);
            OapiProcessinstanceGetResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }
}
