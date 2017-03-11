package com.junly.dao.sys;

import java.util.List;
import java.util.Map;

import com.junly.model.sys.DabaseTable;

public interface DabaseTableMapper extends BaseMapper<Object,DabaseTable>{
	List<Map<String, String>> queryColumns(String tableName);
}
