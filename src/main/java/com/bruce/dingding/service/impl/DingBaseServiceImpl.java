package com.bruce.dingding.service.impl;

import com.bruce.dingding.config.DingConfig;
import com.bruce.dingding.entity.DingToken;
import com.bruce.dingding.entity.constants.UrlConstant;
import com.bruce.dingding.entity.enums.TokenTypeEnum;
import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.service.DingBaseService;
import com.bruce.dingding.utils.FileUtils;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 10:48
 * @Author fzh
 */
@Slf4j
public class DingBaseServiceImpl implements DingBaseService {

    public DingConfig config;
    /**
     * 失效时间提前 5 分钟
     */
    private final static Long TIME_PERIOD = 60 * 5L;


    /**
     * @param agentId   应用agentId
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public DingBaseServiceImpl(Long agentId, String appKey, String appSecret) {
        config = new DingConfig(appKey, appSecret, agentId);
    }

    @Override
    public OapiGettokenResponse getRealToken() throws DingDingException {
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_TOKEN);
            OapiGettokenRequest request = new OapiGettokenRequest();
            request.setAppkey(config.getAppKey());
            request.setAppsecret(config.getAppSecret());
            request.setHttpMethod("GET");
            OapiGettokenResponse resp = client.execute(request);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public String getAccessToken() throws DingDingException {
        long curTime = System.currentTimeMillis() / 1000;
        DingToken dingToken = FileUtils.getValue(TokenTypeEnum.ACCESS_TOKEN, config.getAppKey());
        if (dingToken == null || (curTime - dingToken.getCreateTime()) >= (dingToken.getExpiresIn() - TIME_PERIOD)) {
            OapiGettokenResponse realToken = getRealToken();
            dingToken = new DingToken();
            dingToken.setAppKey(config.getAppKey());
            dingToken.setToken(realToken.getAccessToken());
            dingToken.setExpiresIn(realToken.getExpiresIn());
            dingToken.setCreateTime(curTime);
            FileUtils.write2File(dingToken, TokenTypeEnum.ACCESS_TOKEN);
        }
        return dingToken.getToken();
    }

    @Override
    public OapiGetJsapiTicketResponse getJsapiRealToken(String accessToken) throws DingDingException {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_JSAPI_TOKEN);
            OapiGetJsapiTicketRequest req = new OapiGetJsapiTicketRequest();
            req.setHttpMethod("GET");
            OapiGetJsapiTicketResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public String getJsapiToken(String accessToken) throws DingDingException {
        long curTime = System.currentTimeMillis() / 1000;
        DingToken dingToken = FileUtils.getValue(TokenTypeEnum.JSAPI_TOKEN, config.getAppKey());
        if (dingToken == null || (curTime - dingToken.getCreateTime()) >= (dingToken.getExpiresIn() - TIME_PERIOD)) {
            OapiGetJsapiTicketResponse realToken = getJsapiRealToken(accessToken);
            dingToken = new DingToken();
            dingToken.setAppKey(config.getAppKey());
            dingToken.setToken(realToken.getTicket());
            dingToken.setExpiresIn(realToken.getExpiresIn());
            dingToken.setCreateTime(curTime);
            FileUtils.write2File(dingToken, TokenTypeEnum.JSAPI_TOKEN);
        }
        return dingToken.getToken();
    }

    @Override
    public OapiUserGetuserinfoResponse getUserInfo(String code, String accessToken) throws DingDingException {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_USER_INFO);
            OapiUserGetuserinfoRequest req = new OapiUserGetuserinfoRequest();
            req.setCode(code);
            req.setHttpMethod("GET");
            OapiUserGetuserinfoResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiV2UserGetuserinfoResponse getUserInfoV2(String code, String accessToken) throws DingDingException {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_USER_INFO_V2);
            OapiV2UserGetuserinfoRequest req = new OapiV2UserGetuserinfoRequest();
            req.setCode(code);
            req.setHttpMethod("GET");
            OapiV2UserGetuserinfoResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiSnsGetuserinfoBycodeResponse getUserInfoByCode(String code) throws DingDingException {
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_USER_INFO_BY_CODE);
            OapiSnsGetuserinfoBycodeRequest req = new OapiSnsGetuserinfoBycodeRequest();
            req.setTmpAuthCode(code);
            OapiSnsGetuserinfoBycodeResponse resp = client.execute(req, config.getAppKey(), config.getAppSecret());
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

}