package com.bruce.dingding.service;

import com.bruce.dingding.service.impl.DingApprovalServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:34
 * @Author fzh
 */
public class DingApprovalServiceTest extends DingBaseServiceTest {

    private DingApprovalService dingApprovalService;

    @Before
    public void before() {
        dingApprovalService = new DingApprovalServiceImpl(agentId, appKey, appSecret);
    }

    @Test
    public void approvalCreate() {
    }

    @Test
    public void approvalList() {
    }

    @Test
    public void approvalGet() {
    }
}