package com.junly.service.sys;

import com.junly.model.sys.UUser;
import com.junly.service.base.BaseService;

public abstract interface UUserService
  extends BaseService<Long, UUser>
{
  public abstract UUser login(String paramString1, String paramString2);
}
