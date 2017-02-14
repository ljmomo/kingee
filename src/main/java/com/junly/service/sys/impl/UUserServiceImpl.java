package com.junly.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junly.common.plugins.page.Page;
import com.junly.dao.sys.UUserMapper;
import com.junly.model.sys.UUser;
import com.junly.service.sys.UUserService;

@Service("uUserServiceImpl")
public class UUserServiceImpl
  implements UUserService
{
  @Autowired
  UUserMapper uUserMapper;
  
  public List<UUser> selectList()
  {
    return null;
  }
  
  public int deleteByPrimaryKey(Long id)
  {
    return 0;
  }
  
  public UUser insert(UUser record)
  {
    return null;
  }
  
  public UUser insertSelective(UUser record)
  {
    return null;
  }
  
  public UUser selectByPrimaryKey(Long id)
  {
    return this.uUserMapper.selectByPrimaryKey(id);
  }
  
  public int updateByPrimaryKeySelective(UUser record)
  {
    return 0;
  }
  
  public int updateByPrimaryKey(UUser record)
  {
    return 0;
  }
  
  public UUser login(String email, String pswd)
  {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("email", email);
    map.put("pswd", pswd);
    return this.uUserMapper.login(map);
  }
  
@Override
public List<UUser> find(UUser paramV, Page<UUser> paramPage) {
	return this.uUserMapper.find(paramV, paramPage);
}
}
