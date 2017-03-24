package com.junly.dao.user;

import java.util.Map;

import com.junly.common.base.BaseMapper;
import com.junly.model.user.SysUserInfo;
import com.junly.model.user.UserInfo;

public interface SysUserInfoMapper extends BaseMapper<String,SysUserInfo>{
	//UserInfo  selecLogintUserInfoByParam(String userName, String passWord,int status, List<Integer> userTypes);
	UserInfo  selecLogintUserInfoByParam(Map<String ,Object> map);

}