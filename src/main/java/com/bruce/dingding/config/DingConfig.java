package com.bruce.dingding.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 10:48
 * @Author fzh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DingConfig {

    private String appKey;
    private String appSecret;
    private Long agentId;

}
