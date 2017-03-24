package com.junly.common.base;

import java.util.List;
import java.util.Map;

public interface BaseMapper<K, T> {
	public List<T> listPager(Map<String,Object> map);
	public List<T> list(T paramT);
	int deleteByPrimaryKey(K paramLong);
	int insert(T t);
	int insertSelective(T t);
	T selectByPrimaryKey(K k);
	int updateByPrimaryKeySelective(T t);
	int updateByPrimaryKey(T t);
}
