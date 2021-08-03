package com.bruce.dingding.exception;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 钉钉统一异常
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 10:48
 * @Author fzh
 */
public class DingDingException extends RuntimeException {

    public DingDingException() {
        // TODO Auto-generated constructor stub
    }

    public DingDingException(Throwable msg) {
        super(msg);
    }

    public DingDingException(String msg) {
        super(msg);
    }

    public DingDingException(String msg, Throwable e) {
        super(msg, e);
    }
}