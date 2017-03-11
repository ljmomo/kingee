package com.junly.dao.sys;

import com.junly.model.sys.UUser;
import java.util.Map;

public  interface UUserMapper
  extends BaseMapper<Object,UUser>
{
  public  UUser login(Map<String, Object> paramMap);
}
