package com.bruce.dingding.entity.msg;

import lombok.Data;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc markdown 消息
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 10:04
 * @Author fzh
 */
@Data
public class MarkdownMsgReq {

    private String title;

    private String text;

}
