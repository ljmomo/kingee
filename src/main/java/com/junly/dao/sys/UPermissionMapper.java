package com.junly.dao.sys;

import com.junly.model.sys.UPermission;

public abstract interface UPermissionMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(UPermission paramUPermission);
  
  public abstract int insertSelective(UPermission paramUPermission);
  
  public abstract UPermission selectByPrimaryKey(Long paramLong);
  
  public abstract int updateByPrimaryKeySelective(UPermission paramUPermission);
  
  public abstract int updateByPrimaryKey(UPermission paramUPermission);
}
