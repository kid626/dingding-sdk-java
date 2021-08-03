package com.bruce.dingding.service;

import com.bruce.dingding.exception.DingDingException;
import com.dingtalk.api.response.*;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 通用接口 https://developers.dingtalk.com/document/app/sso-overview
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 10:48
 * @Author fzh
 */
public interface DingBaseService {

    /**
     * 获取token，需要开发人员自己管理生命周期
     *
     * @return access_token
     * @throws DingDingException DingDingException
     */
    OapiGettokenResponse getRealToken() throws DingDingException;

    /**
     * 获取 token ，已做生命周期管理
     *
     * @return access_token
     * @throws DingDingException DingDingException
     */
    String getAccessToken() throws DingDingException;

    /**
     * 获取 jsapi token，需要开发人员自己管理生命周期
     *
     * @param accessToken access_token
     * @return jsapi_token
     * @throws DingDingException DingDingException
     */
    OapiGetJsapiTicketResponse getJsapiRealToken(String accessToken) throws DingDingException;

    /**
     * 获取 jsapi token ，已做生命周期管理
     *
     * @param accessToken access_token
     * @return jsapi_token
     * @throws DingDingException DingDingException
     */
    String getJsapiToken(String accessToken) throws DingDingException;

    /**
     * 通过免登码获取用户信息
     *
     * @param code        免登码
     * @param accessToken access_token
     * @return OapiUserGetuserinfoResponse
     * @throws DingDingException DingDingException
     */
    OapiUserGetuserinfoResponse getUserInfo(String code, String accessToken) throws DingDingException;

    /**
     * 通过免登码获取用户信息(v2)
     *
     * @param code        免登码
     * @param accessToken access_token
     * @return OapiV2UserGetuserinfoResponse
     * @throws DingDingException DingDingException
     */
    OapiV2UserGetuserinfoResponse getUserInfoV2(String code, String accessToken) throws DingDingException;


    /**
     * 根据sns临时授权码获取用户信息
     *
     * @param code 扫码登录的临时授权码
     * @return OapiSnsGetuserinfoBycodeResponse
     * @throws DingDingException DingDingException
     */
    OapiSnsGetuserinfoBycodeResponse getUserInfoByCode(String code) throws DingDingException;

}
