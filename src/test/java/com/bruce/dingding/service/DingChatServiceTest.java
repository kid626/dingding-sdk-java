package com.bruce.dingding.service;

import com.bruce.dingding.service.impl.DingChatServiceImpl;
import com.dingtalk.api.request.OapiChatCreateRequest;
import com.dingtalk.api.request.OapiChatSendRequest;
import com.dingtalk.api.response.OapiChatCreateResponse;
import com.dingtalk.api.response.OapiChatGetResponse;
import com.dingtalk.api.response.OapiChatSendResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:35
 * @Author fzh
 */
public class DingChatServiceTest extends DingBaseServiceTest {

    private DingChatService dingChatService;

    private String chatId = "chata7596baa8b1a5e0d60160ffd1debc65f";
    private String openConversationId = "cidrGctnJ7SE0kFbELwJJdjRQ==";

    @Before
    public void setUp() throws Exception {
        dingChatService = new DingChatServiceImpl(agentId, appKey, appSecret);
        token = dingChatService.getAccessToken();
    }

    @Test
    public void create() {
        OapiChatCreateRequest request = new OapiChatCreateRequest();
        request.setName("测试群001");
        request.setOwner(userId);
        request.setUseridlist(Arrays.asList(userId));
        OapiChatCreateResponse resp = dingChatService.create(token, request);
        System.out.println(resp.getOpenConversationId());
        System.out.println(resp.getChatid());
        System.out.println(resp);
    }

    @Test
    public void get() {
        // 没有权限，需要额外申请
        OapiChatGetResponse resp = dingChatService.get(token, chatId);
        System.out.println(resp.getChatInfo());
        System.out.println(resp);
    }

    @Test
    public void send() {
        OapiChatSendRequest request = new OapiChatSendRequest();
        request.setChatid(chatId);
        OapiChatSendRequest.Text text = new OapiChatSendRequest.Text();
        text.setContent("你好");
        OapiChatSendRequest.Msg msg = new OapiChatSendRequest.Msg();
        msg.setText(text);
        msg.setMsgtype("text");
        request.setMsg(msg);
        request.setText(text);
        OapiChatSendResponse resp = dingChatService.send(token, request);
        System.out.println(resp);
    }
}