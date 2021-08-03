package com.bruce.dingding.entity.msg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 链接消息
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 9:34
 * @Author fzh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LinkMsgReq {

    /**
     * messageUrl : http://s.dingtalk.com/market/dingtalk/error_code.php
     * picUrl : @lALOACZwe2Rk
     * title : 测试
     * text : 测试
     */
    /**
     * 消息点击链接地址，当发送消息为E应用时支持E应用跳转链接 必填
     */
    private String messageUrl;
    /**
     * 图片地址 必填
     */
    private String picUrl;
    /**
     * 消息标题 必填
     */
    private String title;
    /**
     * 消息描述 必填
     */
    private String text;

}