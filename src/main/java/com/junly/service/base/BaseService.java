package com.junly.service.base;

import java.util.List;

import com.junly.common.plugins.page.Page;

public  interface BaseService<K, V>
{
  public  List<V> selectList(V v);
  public  int deleteByPrimaryKey(K paramK);
  public  V insert(V paramV);
  public  V insertSelective(V paramV);
  public  V selectByPrimaryKey(K paramK);
  public  int updateByPrimaryKeySelective(V paramV);
  public  int updateByPrimaryKey(V paramV);
  public  List<V> find(V paramV, Page<V> page);
}
