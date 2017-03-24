package com.junly.service.base;

import java.util.List;

import com.junly.common.util.Pager;

public  interface BaseService<K, V>
{
  public  List<V> selectList(V v);
  public  int deleteByPrimaryKey(K paramK);
  public  int insert(V paramV);
  public  int insertSelective(V paramV);
  public  V selectByPrimaryKey(K paramK);
  public  int updateByPrimaryKeySelective(V paramV);
  public  int updateByPrimaryKey(V paramV);
  public  List<V> listPager(V paramV, Pager page);
}
