package com.deng.malltiny.service;

import com.deng.malltiny.mbg.model.UmsAdmin;
import com.deng.malltiny.mbg.model.UmsPermission;

import java.util.List;

public interface UmsAdminService {
    /**
     *
     * 根据用户名获取后台管理员
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     * @param umsAdminParam
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登入功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的jwt的token
     */
    String login(String username,String password);

    /**
     * 获取用户所有权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
