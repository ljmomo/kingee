package com.junly.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.junly.common.plugins.page.Page;
import com.junly.model.sys.UUser;
import com.junly.service.sys.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
@Controller
@RequestMapping({"/user"})
public class UUserController
{
  @Autowired
  private UserService userService;
  
  
  @ApiOperation(value="获取用户", notes="根据用户ID获取用户")
  @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "long")
  @RequestMapping(value="/getUserById",method=RequestMethod.POST)
  @ResponseBody
  public UUser getUserById(Long id)
  {
    UUser selectByPrimaryKey = this.userService.selectByPrimaryKey(Long.valueOf(Long.parseLong("1")));
    return selectByPrimaryKey;
  }
  
  @RequestMapping(value="index")
  public ModelAndView index(HttpServletRequest req, HttpServletResponse res)
  {
    return new ModelAndView("index");
  }
  
  @RequestMapping(value="/login")
  public ModelAndView login(HttpServletRequest req, HttpServletResponse res)
  {
    return new ModelAndView("login");
  }
  
  @RequestMapping(value="submitLogin", method=RequestMethod.POST)
  @ResponseBody
  public Map<String, Object> submitLogin(HttpServletRequest req, HttpServletResponse res, UUser user)
  {
    Map<String, Object> resultMap = new HashMap<String, Object>();
    UUser login = userService.login(user.getEmail(), user.getPswd());
    if (login != null)
    {
      resultMap.put("status", Integer.valueOf(200));
      resultMap.put("message", "登陆成功");
    }
    else
    {
      resultMap.put("status", Integer.valueOf(500));
      resultMap.put("message", "登陆失败");
    }
    return resultMap;
  }
  
  @RequestMapping({"/main"})
  public ModelAndView main(HttpServletRequest req, HttpServletResponse res)
  {
    return new ModelAndView("main");
  }
  
  @RequestMapping({"/userInfo"})
  public ModelAndView userInfo(HttpServletRequest req, HttpServletResponse res)
  {
    UUser selectByPrimaryKey = userService.selectByPrimaryKey(Long.valueOf(1L));
    
    ModelAndView mv = new ModelAndView("user/userInfo");
    mv.addObject("user", selectByPrimaryKey);
    return mv;
  }
  
  @RequestMapping({"/userList"})
  public ModelAndView userList(HttpServletRequest req, HttpServletResponse res, Page<UUser> page)
  {
    List<UUser> list = userService.find(null, page);
    ModelAndView mv = new ModelAndView("user/userList");
    System.out.println(page.getPageNum());
    mv.addObject("userList", list);
    mv.addObject("page", page);
    return mv;
  }
  @RequestMapping({"/addUser"})
  public ModelAndView addUser(HttpServletRequest req, HttpServletResponse res)
  {
	  ModelAndView mv = new ModelAndView("user/addUser");
	  mv.addObject("result", null);
	  return mv;
  }
  
  @RequestMapping({"/saveUser"})
   public ModelAndView saveUser(HttpServletRequest req, HttpServletResponse res,String username,String password)
  {
	  ModelAndView mv = new ModelAndView("user/addUser");
	  Map<String, Object> resultMap = new HashMap<String, Object>();
	  resultMap.put("status", Integer.valueOf(200));
      resultMap.put("message", "添加成功");
      mv.addObject("result", resultMap);
      return mv;
  }
}
