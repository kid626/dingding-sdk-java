package com.bruce.dingding.service;

import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.entity.msg.*;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.request.OapiMessageCorpconversationStatusBarUpdateRequest;
import com.dingtalk.api.response.*;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 通知消息服务层接口 https://developers.dingtalk.com/document/app/message-notification-overview
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 15:48
 * @Author fzh
 */
public interface DingMsgService extends DingBaseService {

    /**
     * 发送文本消息 已测试
     *
     * @param noticeRequest NoticeReq
     * @param content       内容	必须
     * @param accessToken   access_token
     * @return OapiMessageCorpconversationAsyncsendV2Response
     * @throws DingDingException DingDingException
     */
    OapiMessageCorpconversationAsyncsendV2Response sendTextMsg(NoticeReq noticeRequest, String content, String accessToken) throws DingDingException;

    /**
     * 发送图片消息 已测试
     *
     * @param noticeRequest NoticeReq
     * @param mediaId       媒体文件id，可以通过媒体文件接口上传图片获取。建议宽600像素 x 400像素，宽高比3 : 2
     * @param accessToken   access_token
     * @return OapiMessageCorpconversationAsyncsendV2Response
     * @throws DingDingException DingDingException
     */
    OapiMessageCorpconversationAsyncsendV2Response sendImageMsg(NoticeReq noticeRequest, String mediaId, String accessToken) throws DingDingException;

    /**
     * 发送文件信息
     *
     * @param noticeRequest NoticeReq
     * @param mediaId       媒体文件id。引用的媒体文件最大10MB
     * @param accessToken   access_token
     * @return OapiMessageCorpconversationAsyncsendV2Response
     * @throws DingDingException DingDingException
     */
    OapiMessageCorpconversationAsyncsendV2Response sendFileMsg(NoticeReq noticeRequest, String mediaId, String accessToken) throws DingDingException;

    /**
     * 发送语音信息
     *
     * @param noticeRequest NoticeReq
     * @param mediaId       媒体文件id，可以通过媒体文件接口上传  媒体文件id。2MB，播放长度不超过60s，AMR格式
     * @param duration      正整数，小于60，表示音频时长
     * @param accessToken   access_token
     * @return OapiMessageCorpconversationAsyncsendV2Response
     * @throws DingDingException DingDingException
     */
    OapiMessageCorpconversationAsyncsendV2Response sendVoiceMsg(NoticeReq noticeRequest, String mediaId, int duration, String accessToken) throws DingDingException;

    /**
     * 链接消息
     *
     * @param noticeRequest  NoticeReq
     * @param linkMsgRequest LinkMsgReq
     * @param accessToken    access_token
     * @return OapiMessageCorpconversationAsyncsendV2Response
     * @throws DingDingException DingDingException
     */
    OapiMessageCorpconversationAsyncsendV2Response sendLinkMsg(NoticeReq noticeRequest, LinkMsgReq linkMsgRequest, String accessToken) throws DingDingException;


    /**
     * markdown 消息
     *
     * @param noticeRequest  NoticeReq
     * @param markdownMsgReq MarkdownMsgReq
     * @param accessToken    access_token
     * @return OapiMessageCorpconversationAsyncsendV2Response
     * @throws DingDingException DingDingException
     */
    OapiMessageCorpconversationAsyncsendV2Response sendMdMsg(NoticeReq noticeRequest, MarkdownMsgReq markdownMsgReq, String accessToken) throws DingDingException;


    /**
     * oa消息
     *
     * @param noticeRequest NoticeReq
     * @param oaMsgRequest  OapiMessageCorpconversationAsyncsendV2Request.OA
     * @param accessToken   access_token
     * @return OapiMessageCorpconversationAsyncsendV2Response
     * @throws DingDingException DingDingException
     */
    OapiMessageCorpconversationAsyncsendV2Response sendOaMsg(NoticeReq noticeRequest, OapiMessageCorpconversationAsyncsendV2Request.OA oaMsgRequest, String accessToken) throws DingDingException;

    /**
     * 卡片消息 整体跳转
     *
     * @param noticeRequest    NoticeReq
     * @param actionCardMsgReq ActionCardMsgReq
     * @param accessToken      access_token
     * @return OapiMessageCorpconversationAsyncsendV2Response
     * @throws DingDingException DingDingException
     */
    OapiMessageCorpconversationAsyncsendV2Response sendActionCardMsg(NoticeReq noticeRequest, ActionCardMsgReq actionCardMsgReq, String accessToken) throws DingDingException;


    /**
     * 卡片消息 独立跳转
     *
     * @param noticeRequest    NoticeReq
     * @param actionCardMsgReq ActionCardSingleMsgReq
     * @param accessToken      access_token
     * @return OapiMessageCorpconversationAsyncsendV2Response
     * @throws DingDingException DingDingException
     */
    OapiMessageCorpconversationAsyncsendV2Response sendActionCardMsg(NoticeReq noticeRequest, ActionCardSingleMsgReq actionCardMsgReq, String accessToken) throws DingDingException;

    /**
     * 查询工作通知消息的发送进度 已测试
     *
     * @param taskId      发送消息时钉钉返回的任务id
     * @param accessToken access_token
     * @return OapiMessageCorpconversationGetsendprogressResponse
     * @throws DingDingException DingDingException
     */
    OapiMessageCorpconversationGetsendprogressResponse getSendProgress(Long taskId, String accessToken) throws DingDingException;

    /**
     * 查询工作通知消息的发送结果 已测试
     *
     * @param taskId      工作通知主键
     * @param accessToken access_token
     * @return OapiMessageCorpconversationGetsendresultResponse
     * @throws DingDingException DingDingException
     */
    OapiMessageCorpconversationGetsendresultResponse getSendResult(Long taskId, String accessToken) throws DingDingException;


    /**
     * 工作通知消息撤回 已测试
     *
     * @param taskId      工作通知主键
     * @param accessToken access_token
     * @return OapiMessageCorpconversationRecallResponse
     * @throws DingDingException DingDingException
     */
    OapiMessageCorpconversationRecallResponse recall(Long taskId, String accessToken) throws DingDingException;


    /**
     * 更新工作通知状态栏
     *
     * @param request     OapiMessageCorpconversationStatusBarUpdateRequest
     * @param accessToken access_token
     * @return OapiMessageCorpconversationStatusBarUpdateResponse
     */
    OapiMessageCorpconversationStatusBarUpdateResponse updateStatusBar(OapiMessageCorpconversationStatusBarUpdateRequest request, String accessToken) throws DingDingException;

}
