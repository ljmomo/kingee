package com.junly.controller.common.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	DabaseTablesService dabaseTablesService;
	
	@RequestMapping({ "/dabaseTableList" })
	@ResponseBody
	public Page<DabaseTable> userList(HttpServletRequest req, HttpServletResponse res, Page<DabaseTable> page) {
		List<DabaseTable> list = dabaseTablesService.find(null, page);
		page.setResults(list);
		return page;
	}

	@RequestMapping({ "/generatorCode" })
	@ResponseBody public Map<String, Object> generatorCode(Page<DabaseTable> page) {
		Map<String, Object> resultMap  = new HashMap<String, Object>();
		List<DabaseTable> list = dabaseTablesService.find(null, page);
		
		resultMap.put("status", Integer.valueOf(200));
	    resultMap.put("message", "生成成功！");
		try {
			dabaseTablesService.generatorCode(list);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", Integer.valueOf(500));
		    resultMap.put("message", "错误");
		}
		return resultMap;
	}

}
