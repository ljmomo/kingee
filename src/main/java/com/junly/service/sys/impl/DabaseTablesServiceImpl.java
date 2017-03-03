package com.junly.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junly.common.plugins.page.Page;
import com.junly.dao.sys.DabaseTableMapper;
import com.junly.model.sys.DabaseTable;
import com.junly.service.sys.DabaseTablesService;
@Service("dabaseTablesServiceImpl")
public class DabaseTablesServiceImpl implements DabaseTablesService {
    @Autowired
    DabaseTableMapper  dabaseTableMapper;
	@Override
	public List<DabaseTable> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPrimaryKey(String paramK) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DabaseTable insert(DabaseTable paramV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DabaseTable insertSelective(DabaseTable paramV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DabaseTable selectByPrimaryKey(String paramK) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(DabaseTable paramV) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(DabaseTable paramV) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DabaseTable> find(DabaseTable paramV, Page<DabaseTable> page) {
		return dabaseTableMapper.find(paramV, page);
	}


}
