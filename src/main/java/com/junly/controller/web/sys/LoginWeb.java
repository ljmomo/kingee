package com.junly.controller.web.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junly.common.enums.ViewShowEnums;
import com.junly.common.util.ResponseObj;
import com.junly.common.util.UserTypesUtil;
import com.junly.form.sys.LoginFormWeb;
import com.junly.service.helper.LoginHelper;

@Controller
@RequestMapping("/userweb/")
public class LoginWeb {
	
	  @Autowired
	  LoginHelper loginHelper;
	  @RequestMapping(value = "/login.do", produces = { "application/json;charset=UTF-8" },method = RequestMethod.POST)
	  @ResponseBody
	  public  ResponseObj  login( @Valid LoginFormWeb loginFormWeb, BindingResult result,
	                        HttpServletRequest request, HttpServletResponse response) {
		  ResponseObj ajaxResponseObj  =new ResponseObj(ViewShowEnums.INFO_SUCCESS.getStatus(), ViewShowEnums.INFO_SUCCESS.getDetail());
	        if (result.hasErrors()) {
	                 ajaxResponseObj = new ResponseObj(ViewShowEnums.ERROR_FAILED.getStatus(),
	                result.getAllErrors().get(0).getDefaultMessage());

	            return ajaxResponseObj;
	        }
	        return loginHelper.login( loginFormWeb.getUserName(),loginFormWeb.getPassWord(), UserTypesUtil.getWebuserTypes(), request, response,ajaxResponseObj);

	    }
}
