package com.bruce.dingding.service;

import com.bruce.dingding.service.impl.DingCallBackServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:35
 * @Author fzh
 */
public class DingCallBackServiceTest extends DingBaseServiceTest {

    private DingCallBackService dingCallBackService;

    @Before
    public void setUp() throws Exception {
        dingCallBackService = new DingCallBackServiceImpl(agentId, appKey, appSecret);
    }

    @Test
    public void callBackDelete() {
    }

    @Test
    public void callBackRegister() {
    }
}