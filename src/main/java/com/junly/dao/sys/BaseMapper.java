package com.junly.dao.sys;

import java.util.List;

import com.junly.common.plugins.page.Page;

public interface BaseMapper<K, T> {
	public List<T> find(T paramT, Page<T> paramPage);
	int deleteByPrimaryKey(Long paramLong);
	int insert(T t);
	int insertSelective(T t);
	T selectByPrimaryKey(K k);
	int updateByPrimaryKeySelective(T t);
	int updateByPrimaryKey(T t);
}
