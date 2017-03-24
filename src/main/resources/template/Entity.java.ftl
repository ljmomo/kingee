package com.junly.objects;  
import java.io.Serializable;
import java.util.Date;
public class ${class} implements Serializable {  
  private static final long serialVersionUID = 1L;
  
  <#list columns as column>  
     /**
	 * ${column.comments}
	 */
    private ${column.type} ${column.name};  
  </#list>  
  
  <#list columns as column>  
  
    /**
	 * 获取：${column.comments}
	 */
    public ${column.type} get${column.name?cap_first}(){  
      return ${column.name};  
    }  
     /**
	 * 设置：${column.comments}
	 */
    public void set${column.name?cap_first}(${column.type} ${column.name}){  
      this.${column.name} = ${column.name};  
    }  
  </#list>  
  
}  