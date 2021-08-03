package com.bruce.dingding.entity.enums;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 9:34
 * @Author fzh
 */
public enum MsgTypeEnum {

    /**
     * 消息类型枚举类
     */
    TEXT("text"),
    IMAGE("image"),
    VOICE("voice"),
    FILE("file"),
    LINK("link"),
    OA("oa"),
    MARKDOWN("markdown"),
    ACTION_CARD("action_card");

    MsgTypeEnum(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
