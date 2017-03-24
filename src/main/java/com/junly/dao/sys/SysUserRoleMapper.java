package com.junly.dao.sys;

import com.junly.model.sys.SysUserRole;

public interface SysUserRoleMapper {
    int insert(SysUserRole record);
    int insertSelective(SysUserRole record);
}