package com.junly.service.sys;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junly.common.plugins.page.Page;
import com.junly.common.util.FreemarkGeneratorCodeUtil;
import com.junly.dao.sys.DabaseTableMapper;
import com.junly.model.sys.DabaseTable;
import com.junly.service.base.BaseService;

import freemarker.template.TemplateException;

@Service("dabaseTablesService")
public class DabaseTablesService implements BaseService<String, DabaseTable> {
    @Autowired
    DabaseTableMapper  dabaseTableMapper;
	@Override
	public List<DabaseTable> selectList(DabaseTable dabaseTable) {
		return null;
	}
	@Override
	public int deleteByPrimaryKey(String paramK) {
		return 0;
	}

	@Override
	public DabaseTable insert(DabaseTable paramV) {
		return null;
	}

	@Override
	public DabaseTable insertSelective(DabaseTable paramV) {
		return null;
	}

	@Override
	public DabaseTable selectByPrimaryKey(String paramK) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(DabaseTable paramV) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(DabaseTable paramV) {
		return 0;
	}

	@Override
	public List<DabaseTable> find(DabaseTable paramV, Page<DabaseTable> page) {
		return null;
	}
	
	
	public void generatorCode(List<DabaseTable> list) {
		for (DabaseTable dabaseTable : list) {
			try {
				getTableColumns(dabaseTable);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		}
	}

	//获取表的所有列信息
	private List<Map<String, String>> getTableColumns(DabaseTable dabaseTable) throws IOException, TemplateException {
		//获取所有列的信息
		List<Map<String, String>> queryColumns = dabaseTableMapper.queryColumns(dabaseTable.getTableName());
		FreemarkGeneratorCodeUtil.GeneratorEntity(queryColumns, dabaseTable);
		return queryColumns;
	}

}
