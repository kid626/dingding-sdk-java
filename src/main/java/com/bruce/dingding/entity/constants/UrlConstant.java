package com.bruce.dingding.entity.constants;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName dingding-sdk-java
 * @Date 2021/8/2 10:56
 * @Author fzh
 */
public class UrlConstant {

    public static final String HOST = "https://oapi.dingtalk.com/";


    // ****************************************  base  ****************************************
    /**
     * 获取企业内部 access_token
     */
    public static final String GET_TOKEN = HOST + "/gettoken";
    /**
     * 获取 jsapi_ticket
     */
    public static final String GET_JSAPI_TOKEN = HOST + "/get_jsapi_ticket";
    /**
     * 通过免登码获取用户信息
     */
    public static final String GET_USER_INFO = HOST + "/user/getuserinfo";
    /**
     * 通过免登码获取用户信息(V2)
     */
    public static final String GET_USER_INFO_V2 = HOST + "/topapi/v2/user/getuserinfo";
    /**
     * 根据sns临时授权码获取用户信息
     */
    public static final String GET_USER_INFO_BY_CODE = HOST + "/sns/getuserinfo_bycode";


    // ****************************************  user  ****************************************
    /**
     * 根据unionid获取用户userid
     */
    public static final String GET_BY_UNION_ID = HOST + "/topapi/user/getbyunionid";
    /**
     * 根据userid获取用户详情
     */
    public static final String GET_BY_USER_ID = HOST + "/topapi/v2/user/get";
    /**
     * 获取部门用户userid列表
     */
    public static final String GET_DEPT_MEMBER = HOST + "/user/getDeptMember";
    /**
     * 获取部门用户列表 返回的简单信息
     */
    public static final String GET_SIMPLE_LIST = HOST + "/user/simplelist";
    /**
     * 获取部门用户列表 返回的详细信息
     */
    public static final String LIST_BY_PAGE = HOST + "/user/listbypage";
    /**
     * 获取管理员
     */
    public static final String GET_ADMIN = HOST + "/user/get_admin";
    /**
     * 获取管理员通讯录权限范围
     */
    public static final String GET_ADMIN_SCOPE = HOST + "/topapi/user/get_admin_scope";
    /**
     * 创建用户
     */
    public static final String USER_CREATE = HOST + "/user/create";
    /**
     * 更新用户
     */
    public static final String USER_UPDATE = HOST + "/user/update";
    /**
     * 删除用户
     */
    public static final String USER_DELETE = HOST + "/user/delete";
    /**
     * 获取企业员工人数
     */
    public static final String GET_ORG_USER_COUNT = HOST + "/user/get_org_user_count";
    /**
     * 获取未登录钉钉的员工列表
     */
    public static final String INACTIVE_USER_V2 = HOST + "/topapi/inactive/user/v2/get";
    /**
     * 获取管理员的应用管理权限
     */
    public static final String CAN_ACCESS_MICROAPP = HOST + "/user/can_access_microapp";
    /**
     * 根据手机号获取userid
     */
    public static final String GET_BY_MOBILE = HOST + "/topapi/v2/user/getbymobile";
    /**
     * 获取通讯录权限范围
     */
    public static final String AUTH_SCOPES = HOST + "/auth/scopes";


    // ****************************************  dept  ****************************************
    /**
     * 获取所有子部门
     */
    public static final String DEPT_LIST_IDS = HOST + "/department/list_ids";
    /**
     * 获取部门列表
     */
    public static final String DEPT_LIST = HOST + "/department/list";
    /**
     * 获取部门详情
     */
    public static final String DEPT_GET = HOST + "/department/get";
    /**
     * 查询部门的所有上级父部门路径
     */
    public static final String DEPT_LIST_PARENT_DEPTS_BY_DEPT = HOST + "/department/list_parent_depts_by_dept";
    /**
     * 创建部门
     */
    public static final String DEPT_CREATE = HOST + "/department/create";
    /**
     * 更新部门
     */
    public static final String DEPT_UPDATE = HOST + "/department/update";
    /**
     * 删除部门
     */
    public static final String DEPT_DELETE = HOST + "/department/delete";
    /**
     * 获取指定用户的所有父部门列表
     */
    public static final String DEPT_LIST_PARENT_DEPT_BY_USER = HOST + "/topapi/v2/department/listparentbyuser";


    // ****************************************  approval  ****************************************
    /**
     * 发起审批实例的接口url
     */
    public static final String URL_PROCESSINSTANCE_START = HOST + "/topapi/processinstance/create";
    /**
     * 获取审批实例的接口url
     */
    public static final String URL_PROCESSINSTANCE_GET = HOST + "/topapi/processinstance/get";


    // ****************************************  callback  ****************************************
    /**
     * 删除企业回调接口url
     */
    public static final String DELETE_CALLBACK = "https://oapi.dingtalk.com/call_back/delete_call_back";
    /**
     * 注册企业回调接口url
     */
    public static final String REGISTER_CALLBACK = "https://oapi.dingtalk.com/call_back/register_call_back";


    // ****************************************  chat  ****************************************
    /**
     * 创建群会话
     */
    public static final String CHAT_CREATE = HOST + "/chat/create";
    /**
     * 获取群会话
     */
    public static final String CHAT_GET = HOST + "/chat/get";
    /**
     * 发送消息到群
     */
    public static final String CHAT_SEND = HOST + "/chat/send";


    // ****************************************  extcontact  ****************************************
    /**
     * 获取外部联系人标签列表
     */
    public static final String EXT_CONTACT_LIST_LABEL_GROUPS = HOST + "/topapi/extcontact/listlabelgroups";
    /**
     * 获取外部联系人列表
     */
    public static final String EXT_CONTACT_LIST = HOST + "/topapi/extcontact/list";
    /**
     * 获取企业外部联系人详情
     */
    public static final String EXT_CONTACT_GET = HOST + "/topapi/extcontact/get";
    /**
     * 添加外部联系人
     */
    public static final String EXT_CONTACT_CREATE = HOST + "/topapi/extcontact/create";
    /**
     * 更新外部联系人
     */
    public static final String EXT_CONTACT_UPDATE = HOST + "/topapi/extcontact/update";
    /**
     * 删除外部联系人
     */
    public static final String EXT_CONTACT_DELETE = HOST + "/topapi/extcontact/delete";


    // ****************************************  industry  ****************************************
    /**
     * 获取部门详情
     */
    public static final String GET_INDUSTRY_DEPARTMENT = HOST + "/topapi/industry/department/get";
    /**
     * 获取部门下人员列表
     */
    public static final String GET_INDUSTRY_USER_LIST = HOST + "/topapi/industry/user/list";
    /**
     * 获取部门列表
     */
    public static final String GET_INDUSTRY_DEPARTMENT_LIST = HOST + "/topapi/industry/department/list";
    /**
     * 获取部门用户详情
     */
    public static final String GET_INDUSTRY_USER_DETAIL = HOST + "/topapi/industry/user/get";
    /**
     * 获取企业信息
     */
    public static final String GET_INDUSTRY_ORGANIZATION = HOST + "/topapi/industry/organization/get";


    // ****************************************  msg  ****************************************
    /**
     * 发送工作通知
     */
    public static final String MSG_SEND = HOST + "/topapi/message/corpconversation/asyncsend_v2";
    /**
     * 查询工作通知消息的发送进度
     */
    public static final String MSG_GET_SEND_PROGRESS = HOST + "/topapi/message/corpconversation/getsendprogress";
    /**
     * 查询工作通知消息的发送结果
     */
    public static final String MSG_GET_SEND_RESULT = HOST + "/topapi/message/corpconversation/getsendresult";
    /**
     * 撤回工作通知消息
     */
    public static final String MSG_RECALL = HOST + "/topapi/message/corpconversation/recall";
    /**
     * 更新工作通知状态栏
     */
    public static final String MSG_UPDATE_STATUS_BAR = HOST + "/topapi/message/corpconversation/status_bar/update";


    // ****************************************  role  ****************************************
    /**
     * 获取角色列表
     */
    public static final String ROLE_LIST = HOST + "/topapi/role/list";
    /**
     * 获取角色下的员工列表
     */
    public static final String ROLE_SIMPLE_LIST = HOST + "/topapi/role/simplelist";
    /**
     * 获取角色组
     */
    public static final String ROLE_GET_GROUP = HOST + "/topapi/role/getrolegroup";
    /**
     * 获取角色详情
     */
    public static final String ROLE_GET_ROLE = HOST + "/topapi/role/getrole";
    /**
     * 创建角色
     */
    public static final String ROLE_ADD = HOST + "/role/add_role";
    /**
     * 更新角色
     */
    public static final String ROLE_UPDATE = HOST + "/role/update_role";
    /**
     * 删除角色
     */
    public static final String ROLE_DELETE = HOST + "/topapi/role/deleterole";
    /**
     * 创建角色组
     */
    public static final String ROLE_GROUP_ADD = HOST + "/role/add_role_group";
    /**
     * 批量增加员工角色
     */
    public static final String ROLE_ADD_FOR_EMPS = HOST + "/topapi/role/addrolesforemps";
    /**
     * 批量删除员工角色
     */
    public static final String ROLE_REMOVE_FOR_EMPS = HOST + "/topapi/role/removerolesforemps";
    /**
     * 设定角色成员管理范围
     */
    public static final String ROLE_SCOPE_UPDATE = HOST + "/topapi/role/scope/update";


    // ****************************************  smartwork  ****************************************
    /**
     * 获取员工花名册字段信息
     */
    public static final String SW_EMP_LIST = HOST + "/topapi/smartwork/hrm/employee/list";
    /**
     * 获取待入职员工列表
     */
    public static final String SW_EMP_PRE = HOST + "/topapi/smartwork/hrm/employee/querypreentry";
    /**
     * 获取在职员工列表
     */
    public static final String SW_EMP_ON_JOB = HOST + "/topapi/smartwork/hrm/employee/queryonjob";
    /**
     * 获取离职员工列表
     */
    public static final String SW_EMP_DISMISSION = HOST + "/topapi/smartwork/hrm/employee/querydimission";
    /**
     * 获取员工离职信息
     */
    public static final String SW_EMP_LIST_DISMISSION = HOST + "/topapi/smartwork/hrm/employee/listdimission";
    /**
     * 添加企业待入职员工
     */
    public static final String SW_ADD_PRE = HOST + "/topapi/smartwork/hrm/employee/addpreentry";


    // ****************************************  file  ****************************************
    /**
     * 上传媒体文件
     */
    public static final String FILE_UPLOAD = HOST + "/media/upload";


}
