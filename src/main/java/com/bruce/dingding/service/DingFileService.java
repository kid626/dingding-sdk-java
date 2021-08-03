package com.bruce.dingding.service;

import com.bruce.dingding.exception.DingDingException;
import com.dingtalk.api.response.OapiMediaUploadResponse;

import java.io.InputStream;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc    文件存储 https://developers.dingtalk.com/document/app/upload-media-files
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 11:41
 * @Author fzh
 */
public interface DingFileService extends DingBaseService{

    /**
     * 上传文件
     *
     * @param type        媒体文件类型，分别有图片（image）、语音（voice）、普通文件(file)
     * @param fileName    文件名，xx.jpg
     * @param inputStream 输入流
     * @return OapiMediaUploadResponse
     * @throws DingDingException DingDingException
     */
    OapiMediaUploadResponse uploadFile(String type, String fileName, InputStream inputStream, String token) throws DingDingException;



}
