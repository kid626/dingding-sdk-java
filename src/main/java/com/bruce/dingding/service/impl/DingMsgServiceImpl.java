package com.bruce.dingding.service.impl;

import com.bruce.dingding.entity.constants.UrlConstant;
import com.bruce.dingding.entity.enums.MsgTypeEnum;
import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.entity.msg.*;
import com.bruce.dingding.service.DingMsgService;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 通知消息服务层接口 https://developers.dingtalk.com/document/app/message-notification-overview
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 15:48
 * @Author fzh
 */
public class DingMsgServiceImpl extends DingBaseServiceImpl implements DingMsgService {

    /**
     * @param agentId   应用agentId
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public DingMsgServiceImpl(Long agentId, String appKey, String appSecret) {
        super(agentId, appKey, appSecret);
    }

    /**
     * 消息公用部分参数校验
     *
     * @param noticeRequest NoticeReq
     * @return OapiMessageCorpconversationAsyncsendV2Request
     */
    private OapiMessageCorpconversationAsyncsendV2Request validateNotice(NoticeReq noticeRequest) {
        if (null == noticeRequest) {
            throw new DingDingException("noticeRequest NOT NULL!");
        }
        String userIds = "";
        String deptIds = "";
        List<String> userIdList = noticeRequest.getUserIdList();
        List<String> deptIdList = noticeRequest.getDeptIdList();
        // 若不是发给全部，userIdList 和 deptIdList 必须指定一个
        if (!noticeRequest.isToAllUser()) {
            //不能都为空
            boolean isNull = (CollectionUtils.isEmpty(userIdList)) && (CollectionUtils.isEmpty(deptIdList));
            if (isNull) {
                throw new DingDingException("userIdList and deptIdList not same NULL!");
            }
            //不能都不为空
            boolean isNotNull = (CollectionUtils.isNotEmpty(userIdList)) && (CollectionUtils.isNotEmpty(deptIdList));
            if (isNotNull) {
                throw new DingDingException("userIdList,deptIdList allow one not null!");
            }
            if (CollectionUtils.isNotEmpty(userIdList)) {
                userIds = StringUtils.join(userIdList, ",");
            }
            if (CollectionUtils.isNotEmpty(deptIdList)) {
                deptIds = StringUtils.join(deptIdList, ",");
            }
        }
        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        request.setAgentId(config.getAgentId());
        request.setDeptIdList(deptIds);
        request.setUseridList(userIds);
        request.setToAllUser(noticeRequest.isToAllUser());
        return request;
    }

    /**
     * 消息请求，公用
     *
     * @param request OapiMessageCorpconversationAsyncsendV2Request
     * @return OapiMessageCorpconversationAsyncsendV2Response
     */
    private OapiMessageCorpconversationAsyncsendV2Response noticeRequest(OapiMessageCorpconversationAsyncsendV2Request request, String accessToken) {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.MSG_SEND);
            OapiMessageCorpconversationAsyncsendV2Response resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiMessageCorpconversationAsyncsendV2Response sendTextMsg(NoticeReq noticeRequest, String content, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(content)) {
            throw new DingDingException("content NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        OapiMessageCorpconversationAsyncsendV2Request request = validateNotice(noticeRequest);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype(MsgTypeEnum.TEXT.getType());
        msg.setText(new OapiMessageCorpconversationAsyncsendV2Request.Text());
        msg.getText().setContent(content);
        request.setMsg(msg);
        return noticeRequest(request, accessToken);
    }

    @Override
    public OapiMessageCorpconversationAsyncsendV2Response sendImageMsg(NoticeReq noticeRequest, String mediaId, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(mediaId)) {
            throw new DingDingException("mediaId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        OapiMessageCorpconversationAsyncsendV2Request request = validateNotice(noticeRequest);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype(MsgTypeEnum.IMAGE.getType());
        msg.setImage(new OapiMessageCorpconversationAsyncsendV2Request.Image());
        msg.getImage().setMediaId(mediaId);
        request.setMsg(msg);
        return noticeRequest(request, accessToken);
    }

    @Override
    public OapiMessageCorpconversationAsyncsendV2Response sendFileMsg(NoticeReq noticeRequest, String mediaId, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(mediaId)) {
            throw new DingDingException("mediaId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        OapiMessageCorpconversationAsyncsendV2Request request = validateNotice(noticeRequest);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype(MsgTypeEnum.FILE.getType());
        msg.setFile(new OapiMessageCorpconversationAsyncsendV2Request.File());
        msg.getFile().setMediaId(mediaId);
        request.setMsg(msg);
        return noticeRequest(request, accessToken);
    }

    @Override
    public OapiMessageCorpconversationAsyncsendV2Response sendVoiceMsg(NoticeReq noticeRequest, String mediaId, int duration, String accessToken) throws DingDingException {
        if (duration <= 0 || duration > 60) {
            throw new DingDingException("duration BETWEEN 0 AND 60 !");
        }
        if (StringUtils.isEmpty(mediaId)) {
            throw new DingDingException("mediaId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        OapiMessageCorpconversationAsyncsendV2Request request = validateNotice(noticeRequest);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype(MsgTypeEnum.VOICE.getType());
        msg.setVoice(new OapiMessageCorpconversationAsyncsendV2Request.Voice());
        msg.getVoice().setMediaId(mediaId);
        msg.getVoice().setDuration(String.valueOf(duration));
        request.setMsg(msg);
        return noticeRequest(request, accessToken);
    }

    @Override
    public OapiMessageCorpconversationAsyncsendV2Response sendLinkMsg(NoticeReq noticeRequest, LinkMsgReq linkMsgRequest, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(linkMsgRequest.getMessageUrl())) {
            throw new DingDingException("messageUrl NOT NULL!");
        }
        if (StringUtils.isEmpty(linkMsgRequest.getPicUrl())) {
            throw new DingDingException("picUrl NOT NULL!");
        }
        if (StringUtils.isEmpty(linkMsgRequest.getTitle())) {
            throw new DingDingException("title NOT NULL!");
        }
        if (StringUtils.isEmpty(linkMsgRequest.getText())) {
            throw new DingDingException("text NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        OapiMessageCorpconversationAsyncsendV2Request request = validateNotice(noticeRequest);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype(MsgTypeEnum.LINK.getType());
        msg.setLink(new OapiMessageCorpconversationAsyncsendV2Request.Link());
        msg.getLink().setTitle(linkMsgRequest.getTitle());
        msg.getLink().setText(linkMsgRequest.getText());
        msg.getLink().setMessageUrl(linkMsgRequest.getMessageUrl());
        msg.getLink().setPicUrl(linkMsgRequest.getPicUrl());
        request.setMsg(msg);
        return noticeRequest(request, accessToken);
    }

    @Override
    public OapiMessageCorpconversationAsyncsendV2Response sendMdMsg(NoticeReq noticeRequest, MarkdownMsgReq markdownMsgReq, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(markdownMsgReq.getTitle())) {
            throw new DingDingException("title NOT NULL!");
        }
        if (StringUtils.isEmpty(markdownMsgReq.getText())) {
            throw new DingDingException("text NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        OapiMessageCorpconversationAsyncsendV2Request request = validateNotice(noticeRequest);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype(MsgTypeEnum.MARKDOWN.getType());
        msg.setMarkdown(new OapiMessageCorpconversationAsyncsendV2Request.Markdown());
        msg.getMarkdown().setTitle(markdownMsgReq.getTitle());
        msg.getMarkdown().setText(markdownMsgReq.getText());
        request.setMsg(msg);
        return noticeRequest(request, accessToken);
    }

    @Override
    public OapiMessageCorpconversationAsyncsendV2Response sendOaMsg(NoticeReq noticeRequest, OapiMessageCorpconversationAsyncsendV2Request.OA oaMsgRequest, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        OapiMessageCorpconversationAsyncsendV2Request request = validateNotice(noticeRequest);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setOa(oaMsgRequest);
        msg.setMsgtype(MsgTypeEnum.OA.getType());
        request.setMsg(msg);
        return noticeRequest(request, accessToken);
    }

    @Override
    public OapiMessageCorpconversationAsyncsendV2Response sendActionCardMsg(NoticeReq noticeRequest, ActionCardMsgReq actionCardMsgReq, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(actionCardMsgReq.getTitle())) {
            throw new DingDingException("title NOT NULL!");
        }
        if (StringUtils.isEmpty(actionCardMsgReq.getMarkdown())) {
            throw new DingDingException("markdown NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }

        OapiMessageCorpconversationAsyncsendV2Request request = validateNotice(noticeRequest);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setActionCard(new OapiMessageCorpconversationAsyncsendV2Request.ActionCard());
        msg.getActionCard().setTitle(actionCardMsgReq.getTitle());
        msg.getActionCard().setMarkdown(actionCardMsgReq.getMarkdown());
        msg.getActionCard().setSingleTitle(actionCardMsgReq.getSingleTitle());
        msg.getActionCard().setSingleUrl(actionCardMsgReq.getSingleUrl());
        msg.setMsgtype(MsgTypeEnum.ACTION_CARD.getType());
        request.setMsg(msg);
        return noticeRequest(request, accessToken);
    }

    @Override
    public OapiMessageCorpconversationAsyncsendV2Response sendActionCardMsg(NoticeReq noticeRequest, ActionCardSingleMsgReq actionCardMsgReq, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(actionCardMsgReq.getTitle())) {
            throw new DingDingException("title NOT NULL!");
        }
        if (StringUtils.isEmpty(actionCardMsgReq.getMarkdown())) {
            throw new DingDingException("markdown NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        OapiMessageCorpconversationAsyncsendV2Request request = validateNotice(noticeRequest);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setActionCard(new OapiMessageCorpconversationAsyncsendV2Request.ActionCard());
        msg.getActionCard().setTitle(actionCardMsgReq.getTitle());
        msg.getActionCard().setMarkdown(actionCardMsgReq.getMarkdown());
        msg.getActionCard().setBtnOrientation(actionCardMsgReq.getBtnOrientation());
        msg.getActionCard().setBtnJsonList(convert2BtnJsonList(actionCardMsgReq.getBtnJsonList()));
        msg.setMsgtype(MsgTypeEnum.ACTION_CARD.getType());
        request.setMsg(msg);
        return noticeRequest(request, accessToken);
    }

    private List<OapiMessageCorpconversationAsyncsendV2Request.BtnJsonList> convert2BtnJsonList(List<ActionCardSingleMsgReq.BtnJsonList> list) {
        List<OapiMessageCorpconversationAsyncsendV2Request.BtnJsonList> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(list)) {
            for (ActionCardSingleMsgReq.BtnJsonList btnJsonList : list) {
                OapiMessageCorpconversationAsyncsendV2Request.BtnJsonList btnJsonList1 = new OapiMessageCorpconversationAsyncsendV2Request.BtnJsonList();
                btnJsonList1.setTitle(btnJsonList.getTitle());
                btnJsonList1.setActionUrl(btnJsonList.getActionUrl());
                result.add(btnJsonList1);
            }
        }
        return result;
    }


    @Override
    public OapiMessageCorpconversationGetsendprogressResponse getSendProgress(Long taskId, String accessToken) throws DingDingException {
        if (null == taskId) {
            throw new DingDingException("taskId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.MSG_GET_SEND_PROGRESS);
            OapiMessageCorpconversationGetsendprogressRequest request = new OapiMessageCorpconversationGetsendprogressRequest();
            request.setAgentId(config.getAgentId());
            request.setTaskId(taskId);
            OapiMessageCorpconversationGetsendprogressResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiMessageCorpconversationGetsendresultResponse getSendResult(Long taskId, String accessToken) throws DingDingException {
        if (null == taskId) {
            throw new DingDingException("taskId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.MSG_GET_SEND_RESULT);
            OapiMessageCorpconversationGetsendresultRequest request = new OapiMessageCorpconversationGetsendresultRequest();
            request.setAgentId(config.getAgentId());
            request.setTaskId(taskId);
            OapiMessageCorpconversationGetsendresultResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiMessageCorpconversationRecallResponse recall(Long taskId, String accessToken) throws DingDingException {
        if (null == taskId) {
            throw new DingDingException("taskId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.MSG_RECALL);
            OapiMessageCorpconversationRecallRequest request = new OapiMessageCorpconversationRecallRequest();
            request.setAgentId(config.getAgentId());
            request.setMsgTaskId(taskId);
            OapiMessageCorpconversationRecallResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

    @Override
    public OapiMessageCorpconversationStatusBarUpdateResponse updateStatusBar(OapiMessageCorpconversationStatusBarUpdateRequest request, String accessToken) {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.MSG_UPDATE_STATUS_BAR);
            request.setAgentId(config.getAgentId());
            OapiMessageCorpconversationStatusBarUpdateResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e.getMessage());
        }
    }

}