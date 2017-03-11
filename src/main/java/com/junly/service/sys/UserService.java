package com.junly.service.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junly.common.plugins.page.Page;
import com.junly.dao.sys.UUserMapper;
import com.junly.model.sys.UUser;
import com.junly.service.base.BaseService;
@Service("userService")
public class UserService implements BaseService<Long, UUser> {

	@Autowired
	UUserMapper uUserMapper;

	@Override
	public List<UUser> selectList(UUser user) {
		return null;
	}

	@Override
	public int deleteByPrimaryKey(Long paramK) {
		return 0;
	}

	@Override
	public UUser insert(UUser paramV) {
		return null;
	}

	@Override
	public UUser insertSelective(UUser paramV) {
		return null;
	}

	@Override
	public UUser selectByPrimaryKey(Long paramK) {
		return uUserMapper.selectByPrimaryKey(paramK);
	}

	@Override
	public int updateByPrimaryKeySelective(UUser paramV) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(UUser paramV) {
		return 0;
	}

	@Override
	public List<UUser> find(UUser paramV, Page<UUser> page) {
		return this.uUserMapper.find(paramV, page);
	}

	public UUser login(String email, String pswd) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("pswd", pswd);
		return this.uUserMapper.login(map);
	}

}
