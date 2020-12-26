package com.deng.malltiny.dao;

import com.deng.malltiny.mbg.model.UmsPermission;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface UmsAdminRoleRelationDao {
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

}
