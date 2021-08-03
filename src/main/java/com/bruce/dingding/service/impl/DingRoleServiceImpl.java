package com.bruce.dingding.service.impl;

import com.bruce.dingding.entity.constants.UrlConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import com.bruce.dingding.exception.DingDingException;
import com.bruce.dingding.service.DingRoleService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 角色管理 服务层接口 https://developers.dingtalk.com/document/app/add-role
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/3 9:34
 * @Author fzh
 */
public class DingRoleServiceImpl extends DingBaseServiceImpl implements DingRoleService {

    /**
     * @param agentId   应用agentId
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public DingRoleServiceImpl(Long agentId, String appKey, String appSecret) {
        super(agentId, appKey, appSecret);
    }

    @Override
    public OapiRoleListResponse list(Long offset, Long size, String accessToken) throws DingDingException {
        if (null == offset) {
            throw new DingDingException("offset NOT NULL!");
        }
        int offsetMax = 200;
        if (offset.intValue() > offsetMax) {
            throw new DingDingException("offsetMax max" + offsetMax + "!");
        }
        if (null == size) {
            throw new DingDingException("size NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.ROLE_LIST);
            OapiRoleListRequest request = new OapiRoleListRequest();
            request.setOffset(offset);
            request.setSize(size);
            OapiRoleListResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiRoleSimplelistResponse getRoleUser(Long offset, Long size, Long roleId, String accessToken) throws DingDingException {
        if (null == offset) {
            throw new DingDingException("offset NOT NULL!");
        }
        int offsetMax = 200;
        if (offset.intValue() > offsetMax) {
            throw new DingDingException("offsetMax max" + offsetMax + "!");
        }
        if (null == size) {
            throw new DingDingException("size NOT NULL!");
        }
        if (roleId == null) {
            throw new DingDingException("roleId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.ROLE_SIMPLE_LIST);
            OapiRoleSimplelistRequest request = new OapiRoleSimplelistRequest();
            request.setRoleId(roleId);
            request.setOffset(offset);
            request.setSize(size);
            OapiRoleSimplelistResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiRoleGetrolegroupResponse getRoleGroup(Long groupId, String accessToken) throws DingDingException {
        if (groupId == null) {
            throw new DingDingException("groupId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.ROLE_GET_GROUP);
            OapiRoleGetrolegroupRequest request = new OapiRoleGetrolegroupRequest();
            request.setGroupId(groupId);
            OapiRoleGetrolegroupResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiRoleGetroleResponse getRole(Long roleId, String accessToken) throws DingDingException {
        if (roleId == null) {
            throw new DingDingException("roleId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.ROLE_GET_ROLE);
            OapiRoleGetroleRequest request = new OapiRoleGetroleRequest();
            request.setRoleId(roleId);
            OapiRoleGetroleResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiRoleAddRoleResponse add(String roleName, Long groupId, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(roleName)) {
            throw new DingDingException("roleName NOT NULL!");
        }
        if (groupId == null) {
            throw new DingDingException("groupId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.ROLE_ADD);
            OapiRoleAddRoleRequest request = new OapiRoleAddRoleRequest();
            request.setRoleName(roleName);
            request.setGroupId(groupId);
            OapiRoleAddRoleResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiRoleUpdateRoleResponse update(String roleName, Long roleId, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(roleName)) {
            throw new DingDingException("roleName NOT NULL!");
        }
        if (roleId == null) {
            throw new DingDingException("roleId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.ROLE_UPDATE);
            OapiRoleUpdateRoleRequest request = new OapiRoleUpdateRoleRequest();
            request.setRoleId(roleId);
            request.setRoleName(roleName);
            OapiRoleUpdateRoleResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiRoleDeleteroleResponse delete(Long roleId, String accessToken) throws DingDingException {
        if (roleId == null) {
            throw new DingDingException("roleId NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.ROLE_DELETE);
            OapiRoleDeleteroleRequest request = new OapiRoleDeleteroleRequest();
            request.setRoleId(roleId);
            OapiRoleDeleteroleResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiRoleAddrolegroupResponse addRoleGroup(String name, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(name)) {
            throw new DingDingException("name NOT NULL!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.ROLE_GROUP_ADD);
            OapiRoleAddrolegroupRequest request = new OapiRoleAddrolegroupRequest();
            request.setName(name);
            OapiRoleAddrolegroupResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiRoleAddrolesforempsResponse addRolesUsers(List<String> roleIds, List<String> userIds, String accessToken) throws DingDingException {
        if (CollectionUtils.isEmpty(roleIds)) {
            throw new DingDingException("roleIds NOT NULL!");
        }
        if (CollectionUtils.isEmpty(userIds)) {
            throw new DingDingException("userIds NOT NULL!");
        }
        int maxRoles = 20;
        int maxUserIds = 100;
        if (roleIds.size() > maxRoles) {
            throw new DingDingException("roleIds max size" + maxRoles + "!");
        }
        if (userIds.size() > maxUserIds) {
            throw new DingDingException("userIds max size" + maxUserIds + "!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.ROLE_ADD_FOR_EMPS);
            OapiRoleAddrolesforempsRequest request = new OapiRoleAddrolesforempsRequest();
            request.setRoleIds(StringUtils.join(roleIds.toArray(), ","));
            request.setUserIds(StringUtils.join(userIds.toArray(), ","));
            OapiRoleAddrolesforempsResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiRoleRemoverolesforempsResponse deleteRolesUsers(List<String> roleIds, List<String> userIds, String accessToken) throws DingDingException {
        if (roleIds == null || roleIds.isEmpty()) {
            throw new DingDingException("roleIds NOT NULL!");
        }
        if (userIds == null || userIds.isEmpty()) {
            throw new DingDingException("userIds NOT NULL!");
        }
        int maxRoles = 20;
        int maxUserIds = 100;
        if (roleIds.size() > maxRoles) {
            throw new DingDingException("roleIds max size" + maxRoles + "!");
        }
        if (userIds.size() > maxUserIds) {
            throw new DingDingException("userIds max size" + maxUserIds + "!");
        }
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.ROLE_REMOVE_FOR_EMPS);
            OapiRoleRemoverolesforempsRequest request = new OapiRoleRemoverolesforempsRequest();
            request.setRoleIds(StringUtils.join(roleIds.toArray(), ","));
            request.setUserIds(StringUtils.join(userIds.toArray(), ","));
            OapiRoleRemoverolesforempsResponse resp = client.execute(request, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }

    @Override
    public OapiRoleScopeUpdateResponse updateRoleScope(String userId, Long roleId, List<String> deptIds, String accessToken) throws DingDingException {
        if (StringUtils.isEmpty(accessToken)) {
            throw new DingDingException("accessToken NOT NULL!");
        }

        if (StringUtils.isEmpty(userId)) {
            throw new DingDingException("userId NOT NULL!");
        }

        if (null == roleId) {
            throw new DingDingException("roleId NOT NULL!");
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient(UrlConstant.ROLE_SCOPE_UPDATE);
            OapiRoleScopeUpdateRequest req = new OapiRoleScopeUpdateRequest();
            req.setUserid(userId);
            req.setRoleId(roleId);
            req.setDeptIds(StringUtils.join(deptIds.toArray(), ","));
            OapiRoleScopeUpdateResponse resp = client.execute(req, accessToken);
            if (!resp.isSuccess()) {
                throw new DingDingException(resp.getErrmsg());
            }
            return resp;
        } catch (ApiException e) {
            throw new DingDingException(e);
        }
    }
}