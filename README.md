## 简介 ##

```markdown
钉钉 sdk java 版 
VERSION : 1.0.0
```

## 官方文档 ##

#### [服务端api](https://developers.dingtalk.com/document/app/server-api-overview) ####
- [身份验证免登](https://developers.dingtalk.com/document/app/sso-overview)
- [通讯录管理](https://developers.dingtalk.com/document/app/address-book-permissions)
- [群会话管理](https://developers.dingtalk.com/document/app/group-message-apply-for-permissions)
- [消息通知](https://developers.dingtalk.com/document/app/message-notification-overview)
- [智能人事](https://developers.dingtalk.com/document/app/intelligent-personnel-call-description)
- [文件存储](https://developers.dingtalk.com/document/app/upload-media-files)

## 引入方式 ##

```text
需要先引入第三方 jar 包 taobao-sdk-java-auto_1479188381469-20210727.jar
```

## 使用说明 ##

```java
public class XXXService {

    DingBaseService dingBaseService;

    public XXXService(Long agentId, String appKey, String appSecret) {
        dingBaseService = new DingBaseServiceImpl(agentId, appKey, appSecret);
    }

    public String getAccessToken() {
        return dingBaseService.getAccessToken();
    }

}
```