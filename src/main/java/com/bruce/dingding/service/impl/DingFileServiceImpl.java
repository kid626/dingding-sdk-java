package com.bruce.dingding.service.impl;

import com.bruce.dingding.entity.constants.UrlConstant;
import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.service.DingFileService;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMediaUploadRequest;
import com.dingtalk.api.response.OapiMediaUploadResponse;
import com.taobao.api.ApiException;
import com.taobao.api.FileItem;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.Arrays;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:42
 * @Author fzh
 */
public class DingFileServiceImpl extends DingBaseServiceImpl implements DingFileService {

    /**
     * @param agentId   应用agentId
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public DingFileServiceImpl(Long agentId, String appKey, String appSecret) {
        super(agentId, appKey, appSecret);
    }


    @Override
    public OapiMediaUploadResponse uploadFile(String type, String fileName, InputStream inputStream, String token) throws DingDingException {
        if (StringUtils.isEmpty(token)) {
            throw new DingDingException("token NOT NULL!");
        }
        if (StringUtils.isEmpty(type)) {
            throw new DingDingException("type NOT NULL!");
        }
        String[] types = {"image", "voice", "file"};
        boolean flag = Arrays.asList(types).contains(type);
        if (!flag) {
            throw new DingDingException("type allow image or voice or file");
        }
        DingTalkClient client = new DefaultDingTalkClient(UrlConstant.FILE_UPLOAD);
        OapiMediaUploadRequest request = new OapiMediaUploadRequest();
        request.setType(type);
        request.setMedia(new FileItem(fileName, inputStream));
        OapiMediaUploadResponse response;
        try {
            response = client.execute(request, token);
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
        return response;
    }
}
