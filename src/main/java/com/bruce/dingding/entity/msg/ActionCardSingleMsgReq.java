package com.bruce.dingding.entity.msg;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 独立跳转卡片消息
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 9:34
 * @Author fzh
 */
@Data
public class ActionCardSingleMsgReq {

    /**
     * title : 是透出到会话列表和通知的文案
     * markdown : 支持markdown格式的正文内容
     * btn_orientation : 1
     * btn_json_list : [{"title":"一个按钮","action_url":"https://www.taobao.com"},{"title":"两个按钮","action_url":"https://www.tmall.com"}]
     */

    private String title;
    private String markdown;
    /**
     * 使用独立跳转ActionCard样式时的按钮排列方式，竖直排列(0)，横向排列(1)；必须与btn_json_list同时设置
     */
    @JSONField(name = "btn_orientation")
    private String btnOrientation;
    @JSONField(name = "btn_json_list")
    private List<BtnJsonList> btnJsonList;

    @Data
    public static class BtnJsonList {

        private String title;

        @JSONField(name = "action_url")
        private String actionUrl;

    }

}
