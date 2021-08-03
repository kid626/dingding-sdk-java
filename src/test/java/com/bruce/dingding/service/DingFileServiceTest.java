package com.bruce.dingding.service;

import com.bruce.dingding.service.impl.DingFileServiceImpl;
import com.dingtalk.api.response.OapiMediaUploadResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 13:31
 * @Author fzh
 */
public class DingFileServiceTest extends DingBaseServiceTest {

    private DingFileService dingFileService;

    @Before
    public void setUp() {
        dingFileService = new DingFileServiceImpl(agentId, appKey, appSecret);
        token = dingFileService.getAccessToken();
    }

    @Test
    public void uploadFile() throws Exception {
        String type = "image";
        String fileName = "test.png";
        FileInputStream fis = new FileInputStream(fileName);
        OapiMediaUploadResponse resp = dingFileService.uploadFile(type, fileName, fis, token);
        System.out.println(resp);
    }
}