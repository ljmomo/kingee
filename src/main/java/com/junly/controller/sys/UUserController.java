package com.junly.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.junly.common.plugins.page.Page;
import com.junly.model.sys.UUser;
import com.junly.service.sys.UUserService;

@Controller
@RequestMapping({"/user"})
public class UUserController
{
  @Autowired
  private UUserService uUserServiceImpl;
  
  @RequestMapping({"/getUserById"})
  @ResponseBody
  public UUser getUserById()
  {
    UUser selectByPrimaryKey = (UUser)this.uUserServiceImpl.selectByPrimaryKey(Long.valueOf(Long.parseLong("1")));
    return selectByPrimaryKey;
  }
  
  @RequestMapping({"/index"})
  public ModelAndView index(HttpServletRequest req, HttpServletResponse res)
  {
    return new ModelAndView("index");
  }
  
  @RequestMapping({"/login"})
  public ModelAndView login(HttpServletRequest req, HttpServletResponse res)
  {
    return new ModelAndView("login");
  }
  
  @RequestMapping(value={"submitLogin"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Map<String, Object> submitLogin(HttpServletRequest req, HttpServletResponse res, UUser user)
  {
    Map<String, Object> resultMap = new HashMap<String, Object>();
    UUser login = this.uUserServiceImpl.login(user.getEmail(), user.getPswd());
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
    UUser selectByPrimaryKey = (UUser)this.uUserServiceImpl.selectByPrimaryKey(Long.valueOf(1L));
    
    ModelAndView mv = new ModelAndView("user/userInfo");
    mv.addObject("user", selectByPrimaryKey);
    return mv;
  }
  
  @RequestMapping({"/userList"})
  public ModelAndView userList(HttpServletRequest req, HttpServletResponse res, Page page)
  {
    List<UUser> list = this.uUserServiceImpl.find(null, page);
    ModelAndView mv = new ModelAndView("user/userList");
    System.out.println(page.getPageNum());
    mv.addObject("userList", list);
    mv.addObject("page", page);
    return mv;
  }
}
