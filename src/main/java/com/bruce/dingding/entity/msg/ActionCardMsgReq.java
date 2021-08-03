package com.bruce.dingding.entity.msg;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 整体跳转卡片消息
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 9:34
 * @Author fzh
 */
@Data
public class ActionCardMsgReq {

    /**
     * title : 是透出到会话列表和通知的文案
     * markdown : 支持markdown格式的正文内容
     * single_title : 查看详情
     * single_url : https://open.dingtalk.com
     */
    /**
     * 透出到会话列表和通知的文案 必填
     */
    private String title;
    /**
     * 消息内容，支持markdown，语法参考标准markdown语法。 必填
     */
    private String markdown;
    /**
     * 使用整体跳转ActionCard样式时的标题，必须与single_url同时设置
     */
    @JSONField(name = "single_title")
    private String singleTitle;
    /**
     * 消息点击链接地址，当发送消息为E应用时支持E应用跳转链接
     */
    @JSONField(name = "single_url")
    private String singleUrl;

}