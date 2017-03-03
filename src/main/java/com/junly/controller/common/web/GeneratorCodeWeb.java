package com.junly.controller.common.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junly.common.plugins.page.Page;
import com.junly.model.sys.DabaseTable;
import com.junly.service.sys.DabaseTablesService;

@Controller
@RequestMapping("generator")
public class GeneratorCodeWeb {
	@Autowired
	DabaseTablesService dabaseTablesServiceImpl;
	  @RequestMapping({"/dabaseTableList"})
	  @ResponseBody public Page<DabaseTable>  userList(HttpServletRequest req, HttpServletResponse res, Page<DabaseTable> page)
	  {
	    List<DabaseTable> list = this.dabaseTablesServiceImpl.find(null, page);
	    page.setResults(list);
	    return page;
	  }
}
