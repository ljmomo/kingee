package com.junly.service.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junly.common.enums.ViewShowEnums;
import com.junly.common.model.SessionUser;
import com.junly.common.util.JsonUtil;
import com.junly.common.util.ResponseObj;
import com.junly.common.util.SignUtils;
import com.junly.dao.user.SysUserInfoMapper;
import com.junly.model.user.TicketModel;
import com.junly.model.user.UserInfo;

@Service("loginHelper")
public class LoginHelper {
	
	@Autowired
	SysUserInfoMapper sysUserInfoMapper;
	@Autowired
	TicketHelper ticketHelper;
	
	 /** <p class="detail">
	 * 功能：用户登录
	 * </p>
	 * @author junly
	 * @date 2017年3月24日 
	 * @param userName
	 * @param passWord
	 * @param userTypes
	 * @param request
	 * @param response
	 * @param respObj
	 * @return    
	 */
	public ResponseObj login(String userName, String passWord, List<Integer> userTypes,
			HttpServletRequest request, HttpServletResponse response,ResponseObj respObj) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userName", userName);
		param.put("userTypes", userTypes);
		param.put("passWord", passWord);
		UserInfo userInfo = sysUserInfoMapper.selecLogintUserInfoByParam(param);
		if(userInfo==null)
		{
			respObj.setStatus(ViewShowEnums.ERROR_FAILED.getStatus());
			respObj.setShowMessage("用户不存在或密码错误！");
			respObj.setData(new Object());
			return respObj;
		}
		TicketModel ticketModel = new TicketModel();
		BeanUtils.copyProperties(userInfo, ticketModel);
		respObj.setData(ticketModel);
		return setTicket( ticketModel,  request, response,respObj);

	}
	
			
   private ResponseObj setTicket(TicketModel ticketModel, HttpServletRequest request,
		             HttpServletResponse response,ResponseObj respObj) {
		// 需要转ticket的对象
		SessionUser sessionUser = new SessionUser();
		sessionUser.setUserId(ticketModel.getUserId());
		sessionUser.setUserName(ticketModel.getUserName());
		sessionUser.setLoginTime(ticketModel.getLastLoginTime());
		sessionUser.setUserType(ticketModel.getUserType());
		sessionUser.setLoginIp(ticketModel.getLoginIp());
		// toJson头尾会产生空格出现%22 需要trim后塞入cookie
		String ticket = SignUtils.encrypt(StringUtils.trim(JsonUtil.toJson(sessionUser)));
		// 隐藏sessionUser,ticket中包含就够了
		ticketModel.setTicket(ticket);
		// 信任保存
		ticketHelper.setCookie(request, response, ticket);
		return respObj;
		}
	
	
	
	
}
