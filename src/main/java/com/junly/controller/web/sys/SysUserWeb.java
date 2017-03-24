package com.junly.controller.web.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junly.common.enums.ViewShowEnums;
import com.junly.common.util.PageModel;
import com.junly.common.util.Pager;
import com.junly.common.util.ResponseObj;
import com.junly.model.sys.SysUser;
import com.junly.service.sys.SysUserService;

@Controller
@RequestMapping("web/sysUser")
public class SysUserWeb {

  @Autowired
  SysUserService sysUserService;
  
  @RequestMapping(value="/getList",method = RequestMethod.GET)
  @ResponseBody
  public ResponseObj  getList(SysUser user,Pager page)
  {
	ResponseObj obj = new ResponseObj(ViewShowEnums.INFO_SUCCESS.getStatus(), ViewShowEnums.INFO_SUCCESS.getDetail());
	List<SysUser> list =  sysUserService.listPager(user,page);
	obj.setData(new PageModel(page, list));
	return obj;
  }
  
  @RequestMapping(value="/getSysUser/{userId}", method = RequestMethod.GET)
  @ResponseBody
  public SysUser getSysUser(@PathVariable String userId)
  {
	SysUser selectByPrimaryKey = sysUserService.selectByPrimaryKey(userId);
	return selectByPrimaryKey;
  }
  
  @RequestMapping(value="/update", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObj update(SysUser user)
  {
	ResponseObj obj = new ResponseObj(ViewShowEnums.INFO_SUCCESS.getStatus(), ViewShowEnums.INFO_SUCCESS.getDetail());
	int updateByPrimaryKeySelective = sysUserService.updateByPrimaryKeySelective(user);
	if(updateByPrimaryKeySelective<=0)
	{
		obj.setStatus(ViewShowEnums.ERROR_FAILED.getStatus());
		obj.setShowMessage(ViewShowEnums.ERROR_FAILED.getDetail());
	}
	obj.setData(new Object());
	return obj;
  }
  
}
