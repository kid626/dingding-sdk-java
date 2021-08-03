package com.bruce.dingding.service;

import com.bruce.dingding.entity.msg.NoticeReq;
import com.bruce.dingding.service.impl.DingMsgServiceImpl;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:36
 * @Author fzh
 */
public class DingMsgServiceTest extends DingBaseServiceTest {

    private DingMsgService dingMsgService;

    private String userId = "";

    @Before
    public void setUp() throws Exception {
        dingMsgService = new DingMsgServiceImpl(agentId, appKey, appSecret);
        token = dingMsgService.getAccessToken();
    }

    @Test
    public void sendTextMsg() {
        NoticeReq noticeRequest = new NoticeReq();
        List<String> userIdList = new ArrayList<>();
        userIdList.add(userId);
        List<String> deptIdList = null;
        boolean toAllUser = false;
        String content = "在干嘛 测试";
        noticeRequest.setDeptIdList(deptIdList);
        noticeRequest.setUserIdList(userIdList);
        noticeRequest.setToAllUser(toAllUser);
        OapiMessageCorpconversationAsyncsendV2Response resp = dingMsgService.sendTextMsg(noticeRequest, content, token);
        Assert.assertNotNull(resp);
    }

    @Test
    public void sendImageMsg() {
        NoticeReq noticeRequest = new NoticeReq();
        List<String> userIdList = new ArrayList<>();
        userIdList.add(userId);
        List<String> deptIdList = null;
        boolean toAllUser = false;
        noticeRequest.setDeptIdList(deptIdList);
        noticeRequest.setUserIdList(userIdList);
        noticeRequest.setToAllUser(toAllUser);
        String mediaId = "@lADPDeC2uCIqUCXNBNfNBNc";
        OapiMessageCorpconversationAsyncsendV2Response resp = dingMsgService.sendImageMsg(noticeRequest, mediaId, token);
        Assert.assertNotNull(resp);
    }

    @Test
    public void sendFileMsg() {
    }

    @Test
    public void sendVoiceMsg() {
    }

    @Test
    public void sendLinkMsg() {
    }

    @Test
    public void testSendLinkMsg() {
    }

    @Test
    public void sendOaMsg() {
    }

    @Test
    public void sendActionCardMsg() {
    }

    @Test
    public void testSendActionCardMsg() {
    }

    @Test
    public void getSendProgress() {
    }

    @Test
    public void getSendResult() {
    }

    @Test
    public void recall() {
    }

    @Test
    public void updateStatusBar() {
    }
}