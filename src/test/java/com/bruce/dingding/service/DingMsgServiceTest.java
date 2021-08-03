package com.bruce.dingding.service;

import com.alibaba.fastjson.JSONObject;
import com.bruce.dingding.entity.msg.*;
import com.bruce.dingding.service.impl.DingMsgServiceImpl;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.request.OapiMessageCorpconversationStatusBarUpdateRequest;
import com.dingtalk.api.response.*;
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

    private Long taskId = 409530772750L;

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
        List<String> deptIdList = new ArrayList<>();
        boolean toAllUser = false;
        String content = "测试信息111";
        noticeRequest.setDeptIdList(deptIdList);
        noticeRequest.setUserIdList(userIdList);
        noticeRequest.setToAllUser(toAllUser);
        OapiMessageCorpconversationAsyncsendV2Response resp = dingMsgService.sendTextMsg(noticeRequest, content, token);
        System.out.println(resp.getTaskId());
        Assert.assertNotNull(resp);
    }

    @Test
    public void sendImageMsg() {
        NoticeReq noticeRequest = new NoticeReq();
        List<String> userIdList = new ArrayList<>();
        userIdList.add(userId);
        List<String> deptIdList = new ArrayList<>();
        boolean toAllUser = false;
        noticeRequest.setDeptIdList(deptIdList);
        noticeRequest.setUserIdList(userIdList);
        noticeRequest.setToAllUser(toAllUser);
        OapiMessageCorpconversationAsyncsendV2Response resp = dingMsgService.sendImageMsg(noticeRequest, mediaId, token);
        Assert.assertNotNull(resp);
    }

    @Test
    public void sendFileMsg() {
        NoticeReq noticeRequest = new NoticeReq();
        List<String> userIdList = new ArrayList<>();
        userIdList.add(userId);
        List<String> deptIdList = new ArrayList<>();
        boolean toAllUser = false;
        noticeRequest.setDeptIdList(deptIdList);
        noticeRequest.setUserIdList(userIdList);
        noticeRequest.setToAllUser(toAllUser);
        OapiMessageCorpconversationAsyncsendV2Response resp = dingMsgService.sendFileMsg(noticeRequest, mediaId, token);
        Assert.assertNotNull(resp);
    }

    @Test
    public void sendVoiceMsg() {
        NoticeReq noticeRequest = new NoticeReq();
        List<String> userIdList = new ArrayList<>();
        userIdList.add(userId);
        List<String> deptIdList = new ArrayList<>();
        boolean toAllUser = false;
        noticeRequest.setDeptIdList(deptIdList);
        noticeRequest.setUserIdList(userIdList);
        noticeRequest.setToAllUser(toAllUser);
        OapiMessageCorpconversationAsyncsendV2Response resp = dingMsgService.sendVoiceMsg(noticeRequest, mediaId, 10, token);
        Assert.assertNotNull(resp);
    }

    @Test
    public void sendLinkMsg() {
        NoticeReq noticeRequest = new NoticeReq();
        List<String> userIdList = new ArrayList<>();
        userIdList.add(userId);
        List<String> deptIdList = new ArrayList<>();
        boolean toAllUser = false;
        noticeRequest.setDeptIdList(deptIdList);
        noticeRequest.setUserIdList(userIdList);
        noticeRequest.setToAllUser(toAllUser);
        LinkMsgReq req = new LinkMsgReq();
        req.setText("text");
        req.setTitle("title");
        // req.setPicUrl(mediaId);
        req.setPicUrl("https://www.wsgsoft.com/pld/images/big/07.jpg");
        req.setMessageUrl("https://www.baidu.com");
        OapiMessageCorpconversationAsyncsendV2Response resp = dingMsgService.sendLinkMsg(noticeRequest, req, token);
        Assert.assertNotNull(resp);
    }

    @Test
    public void testSendMdMsg() {
        NoticeReq noticeRequest = new NoticeReq();
        List<String> userIdList = new ArrayList<>();
        userIdList.add(userId);
        List<String> deptIdList = new ArrayList<>();
        boolean toAllUser = false;
        noticeRequest.setDeptIdList(deptIdList);
        noticeRequest.setUserIdList(userIdList);
        noticeRequest.setToAllUser(toAllUser);
        MarkdownMsgReq req = new MarkdownMsgReq();
        req.setText("# 这是支持markdown的文本   \n   ## 标题2    \n   * 列表1   \n  ![alt 啊](https://img.alicdn.com/tps/TB1XLjqNVXXXXc4XVXXXXXXXXXX-170-64.png)");
        req.setTitle("title");
        OapiMessageCorpconversationAsyncsendV2Response resp = dingMsgService.sendMdMsg(noticeRequest, req, token);
        Assert.assertNotNull(resp);
    }

    @Test
    public void sendOaMsg() {
        NoticeReq noticeRequest = new NoticeReq();
        List<String> userIdList = new ArrayList<>();
        userIdList.add(userId);
        List<String> deptIdList = new ArrayList<>();
        boolean toAllUser = false;
        noticeRequest.setDeptIdList(deptIdList);
        noticeRequest.setUserIdList(userIdList);
        noticeRequest.setToAllUser(toAllUser);
        OapiMessageCorpconversationAsyncsendV2Request.OA req = new OapiMessageCorpconversationAsyncsendV2Request.OA();
        req.setHead(new OapiMessageCorpconversationAsyncsendV2Request.Head());
        req.getHead().setText("头部标题1");
        req.getHead().setBgcolor("FFBBBBBB");
        req.setMessageUrl("https://dingtalk.com");
        req.setPcMessageUrl("https://dingtalk.com");
        /**
         * 审批状态颜色参考
         * 已同意 0xFF78C06E
         * 已拒绝 0xFFF65E5E
         * 已撤销 0xFF858E99
         * 待审批 0xFFFF9D46
         */
        req.setStatusBar(new OapiMessageCorpconversationAsyncsendV2Request.StatusBar());
        req.getStatusBar().setStatusBg("0xFFFF9D46");
        req.getStatusBar().setStatusValue("待审批");
        req.setBody(new OapiMessageCorpconversationAsyncsendV2Request.Body());
        req.getBody().setTitle("正文标题");
        req.getBody().setAuthor("bruce");
        req.getBody().setFileCount("3");
        req.getBody().setImage(mediaId);
        req.getBody().setContent("大段文本大段文本大段文本大段文本大段文本大段文本");
        req.getBody().setRich(new OapiMessageCorpconversationAsyncsendV2Request.Rich());
        req.getBody().getRich().setNum("15.6");
        req.getBody().getRich().setUnit("￥");
        List<OapiMessageCorpconversationAsyncsendV2Request.Form> forms = new ArrayList<>();
        OapiMessageCorpconversationAsyncsendV2Request.Form form1 = new OapiMessageCorpconversationAsyncsendV2Request.Form();
        form1.setKey("姓名:");
        form1.setValue("bruce");
        forms.add(form1);
        OapiMessageCorpconversationAsyncsendV2Request.Form form2 = new OapiMessageCorpconversationAsyncsendV2Request.Form();
        form2.setKey("年龄:");
        form2.setValue("24");
        forms.add(form2);
        OapiMessageCorpconversationAsyncsendV2Request.Form form3 = new OapiMessageCorpconversationAsyncsendV2Request.Form();
        form3.setKey("身高:");
        form3.setValue("1.85");
        forms.add(form3);
        OapiMessageCorpconversationAsyncsendV2Request.Form form4 = new OapiMessageCorpconversationAsyncsendV2Request.Form();
        form4.setKey("体重:");
        form4.setValue("160");
        forms.add(form4);
        OapiMessageCorpconversationAsyncsendV2Request.Form form5 = new OapiMessageCorpconversationAsyncsendV2Request.Form();
        form5.setKey("学历:");
        form5.setValue("本科");
        forms.add(form5);
        OapiMessageCorpconversationAsyncsendV2Request.Form form6 = new OapiMessageCorpconversationAsyncsendV2Request.Form();
        form6.setKey("爱好:");
        form6.setValue("打球、听音乐");
        forms.add(form6);
        req.getBody().setTitle("正文标题");
        req.getBody().setForm(forms);
        OapiMessageCorpconversationAsyncsendV2Response resp = dingMsgService.sendOaMsg(noticeRequest, req, token);
        System.out.println(resp.getTaskId());
        Assert.assertNotNull(resp);
    }

    @Test
    public void sendActionCardMsg() {
        NoticeReq noticeRequest = new NoticeReq();
        List<String> userIdList = new ArrayList<>();
        userIdList.add(userId);
        List<String> deptIdList = new ArrayList<>();
        boolean toAllUser = false;
        noticeRequest.setDeptIdList(deptIdList);
        noticeRequest.setUserIdList(userIdList);
        noticeRequest.setToAllUser(toAllUser);
        ActionCardMsgReq req = new ActionCardMsgReq();
        req.setTitle("是透出到会话列表和通知的文案");
        req.setMarkdown("支持markdown格式的正文内容");
        req.setSingleTitle("查看详情");
        req.setSingleUrl("https://open.dingtalk.com");
        OapiMessageCorpconversationAsyncsendV2Response resp = dingMsgService.sendActionCardMsg(noticeRequest, req, token);
        Assert.assertNotNull(resp);
    }

    @Test
    public void testSendActionCardMsg() {
        NoticeReq noticeRequest = new NoticeReq();
        List<String> userIdList = new ArrayList<>();
        userIdList.add(userId);
        List<String> deptIdList = new ArrayList<>();
        boolean toAllUser = false;
        noticeRequest.setDeptIdList(deptIdList);
        noticeRequest.setUserIdList(userIdList);
        noticeRequest.setToAllUser(toAllUser);
        ActionCardSingleMsgReq req = new ActionCardSingleMsgReq();
        req.setTitle("是透出到会话列表和通知的文案");
        req.setMarkdown("支持markdown格式的正文内容");
        req.setBtnOrientation("1");
        ArrayList<ActionCardSingleMsgReq.BtnJsonList> list = new ArrayList<>();
        ActionCardSingleMsgReq.BtnJsonList btnJsonList1 = new ActionCardSingleMsgReq.BtnJsonList();
        btnJsonList1.setTitle("淘宝");
        btnJsonList1.setActionUrl("https://www.taobao.com");
        list.add(btnJsonList1);
        ActionCardSingleMsgReq.BtnJsonList btnJsonList2 = new ActionCardSingleMsgReq.BtnJsonList();
        btnJsonList2.setTitle("天猫");
        btnJsonList2.setActionUrl("https://www.tmall.com");
        list.add(btnJsonList2);
        req.setBtnJsonList(list);
        OapiMessageCorpconversationAsyncsendV2Response resp = dingMsgService.sendActionCardMsg(noticeRequest, req, token);
        Assert.assertNotNull(resp);
    }

    @Test
    public void getSendProgress() {
        OapiMessageCorpconversationGetsendprogressResponse resp = dingMsgService.getSendProgress(taskId, token);
        System.out.println(JSONObject.toJSONString(resp));
    }

    @Test
    public void getSendResult() {
        OapiMessageCorpconversationGetsendresultResponse resp = dingMsgService.getSendResult(taskId, token);
        System.out.println(JSONObject.toJSONString(resp));
    }

    @Test
    public void recall() {
        OapiMessageCorpconversationRecallResponse resp = dingMsgService.recall(taskId, token);
        System.out.println(JSONObject.toJSONString(resp));
    }

    @Test
    public void updateStatusBar() {
        OapiMessageCorpconversationStatusBarUpdateRequest req = new OapiMessageCorpconversationStatusBarUpdateRequest();
        req.setTaskId(taskId);
        /**
         * 审批状态颜色参考
         * 已同意 0xFF78C06E
         * 已拒绝 0xFFF65E5E
         * 已撤销 0xFF858E99
         * 待审批 0xFFFF9D46
         */
        req.setStatusValue("已同意");
        req.setStatusBg("0xFF78C06E");
        OapiMessageCorpconversationStatusBarUpdateResponse resp = dingMsgService.updateStatusBar(req, token);
        System.out.println(JSONObject.toJSONString(resp));
    }
}