package com.junly.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.junly.common.util.Pager;
import com.junly.dao.user.SysUserInfoMapper;
import com.junly.model.user.SysUserInfo;
import com.junly.service.base.BaseService;

public class SysUserInfoService implements BaseService<String, SysUserInfo> {

    @Autowired
    SysUserInfoMapper sysUserInfoMapper;

	@Override
	public List<SysUserInfo> selectList(SysUserInfo v) {
		return sysUserInfoMapper.list(v);
	}

	@Override
	public int deleteByPrimaryKey(String paramK) {
		return sysUserInfoMapper.deleteByPrimaryKey(paramK);
	}

	@Override
	public int insert(SysUserInfo paramV) {
		return sysUserInfoMapper.insert(paramV);
	}

	@Override
	public int insertSelective(SysUserInfo paramV) {
		return sysUserInfoMapper.insertSelective(paramV);
	}

	@Override
	public SysUserInfo selectByPrimaryKey(String paramK) {
		return sysUserInfoMapper.selectByPrimaryKey(paramK);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUserInfo paramV) {
		return sysUserInfoMapper.updateByPrimaryKeySelective(paramV);
	}

	@Override
	public int updateByPrimaryKey(SysUserInfo paramV) {
		return sysUserInfoMapper.updateByPrimaryKey(paramV);
	}

	@Override
	public List<SysUserInfo> listPager(SysUserInfo paramV, Pager page) {
		Map<String ,Object> param = new HashMap<String, Object>();
		param.put("record", paramV);
		param.put("page", page);
		return sysUserInfoMapper.listPager(param);
	}
	
	

}
