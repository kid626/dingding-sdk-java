package com.bruce.dingding.entity;

import lombok.Data;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 11:01
 * @Author fzh
 */
@Data
public class DingToken {

    /**
     * appKey
     */
    private String appKey;

    /**
     * 接口调用凭证 access_token 或 jsapi_token
     */
    private String token;

    /**
     * 过期时间
     */
    private Long expiresIn;

    /**
     * token开始时间
     */
    private Long createTime;

}
