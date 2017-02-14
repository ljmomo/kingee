package com.junly.dao.sys;

import com.junly.model.sys.URole;

public abstract interface URoleMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(URole paramURole);
  
  public abstract int insertSelective(URole paramURole);
  
  public abstract URole selectByPrimaryKey(Long paramLong);
  
  public abstract int updateByPrimaryKeySelective(URole paramURole);
  
  public abstract int updateByPrimaryKey(URole paramURole);
}
