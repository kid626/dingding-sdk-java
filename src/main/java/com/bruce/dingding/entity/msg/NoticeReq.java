package com.bruce.dingding.entity.msg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 通知公用请求部分
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 15:48
 * @Author fzh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeReq implements Serializable {

    /**
     * 用户主键 可选(userid_list,dept_id_list, to_all_user必须有一个不能为空)
     */
    List<String> userIdList;
    /**
     * 部门主键
     */
    List<String> deptIdList;
    /**
     * 是否发送全体用户
     */
    boolean toAllUser;

}