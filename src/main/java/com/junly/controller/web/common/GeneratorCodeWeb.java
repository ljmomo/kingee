package com.junly.controller.web.common;

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

import com.junly.common.util.Pager;
import com.junly.model.sys.DabaseTable;
import com.junly.service.sys.DabaseTablesService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("generator")
public class GeneratorCodeWeb {
	@Autowired
	DabaseTablesService dabaseTablesService;
	@ApiOperation(value="数据库有关", notes="获取库中所有的表")
	 @ApiImplicitParams({
         @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int"),
         @ApiImplicitParam(name = "pageSize", value = "一页显示多少条", required = true, dataType = "int"),
         @ApiImplicitParam(name = "totalRecord", value = "总条数", required = false, dataType = "int"),
         @ApiImplicitParam(name = "totalPage", value = "总页数", required = false, dataType = "int")
    })
	@RequestMapping(value= "/dabaseTableList" ,method=RequestMethod.GET)
	@ResponseBody
	public List<DabaseTable> userList(HttpServletRequest req, HttpServletResponse res, Pager page) {
		List<DabaseTable> list = dabaseTablesService.listPager(null, page);
		return list;
	}

	@RequestMapping(value="/generatorCode" ,method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> generatorCode(Pager page) {
		Map<String, Object> resultMap  = new HashMap<String, Object>();
		List<DabaseTable> list = dabaseTablesService.listPager(null, page);
		
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
