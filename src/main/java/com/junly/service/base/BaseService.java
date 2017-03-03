package com.junly.service.base;

import com.junly.common.plugins.page.Page;
import com.junly.model.sys.UUser;

import java.util.List;

public abstract interface BaseService<K, V>
{
  public  List<V> selectList();
  
  public  int deleteByPrimaryKey(K paramK);
  
  public  V insert(V paramV);
  
  public  V insertSelective(V paramV);
  
  public  V selectByPrimaryKey(K paramK);
  
  public  int updateByPrimaryKeySelective(V paramV);
  
  public  int updateByPrimaryKey(V paramV);
  
  public  List<V> find(V paramV, Page<V> page);
}
