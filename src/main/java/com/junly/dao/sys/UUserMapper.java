package com.junly.dao.sys;

import com.junly.model.sys.UUser;
import java.util.Map;

public  interface UUserMapper
  extends BaseMapper<UUser>
{
  public  int deleteByPrimaryKey(Long paramLong);
  
  public  int insert(UUser paramUUser);
  
  public  int insertSelective(UUser paramUUser);
  
  public  UUser selectByPrimaryKey(Long paramLong);
  
  public  int updateByPrimaryKeySelective(UUser paramUUser);
  
  public  int updateByPrimaryKey(UUser paramUUser);
  
  public  UUser login(Map<String, Object> paramMap);
}
