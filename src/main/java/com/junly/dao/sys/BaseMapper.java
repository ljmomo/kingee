package com.junly.dao.sys;

import com.junly.common.plugins.page.Page;
import java.util.List;

public  interface BaseMapper<T>
{
  public  List<T> find(T paramT, Page<T> paramPage);
}
