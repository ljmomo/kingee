package com.junly.service.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junly.common.util.Pager;
import com.junly.dao.sys.SysUserMapper;
import com.junly.model.sys.SysUser;
import com.junly.service.base.BaseService;

@Service
public class SysUserService implements BaseService<String, SysUser> {

	@Autowired
	SysUserMapper sysUserMapper;
	@Override
	public List<SysUser> selectList(SysUser v) {
		return sysUserMapper.list(v);
	}

	@Override
	public int deleteByPrimaryKey(String paramK) {
		return sysUserMapper.deleteByPrimaryKey(paramK);
	}

	@Override
	public int insert(SysUser paramV) {
		return sysUserMapper.insert(paramV);
	}

	@Override
	public int insertSelective(SysUser paramV) {
		return sysUserMapper.insertSelective(paramV);
	}

	@Override
	public SysUser selectByPrimaryKey(String  paramK) {
		return sysUserMapper.selectByPrimaryKey(paramK);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUser paramV) {
		return sysUserMapper.updateByPrimaryKeySelective(paramV);
	}

	@Override
	public int updateByPrimaryKey(SysUser paramV) {
		return sysUserMapper.updateByPrimaryKey(paramV);
	}

	@Override
	public List<SysUser> listPager(SysUser paramV, Pager page) {
		Map<String,Object> param = new HashMap<>();
		param.put("record", paramV);
		param.put("page",page);
		return sysUserMapper.listPager(param);
	}


}
