package com.junly.common.util;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.formula.functions.T;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {  
  
    private static final String DEFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";  
    private static final ObjectMapper mapper;  
  
    static {  
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);  
        mapper = new ObjectMapper();  
        mapper.setDateFormat(dateFormat);  
    }  
      
    public static String toJson(Object obj) {  
        try {  
            return mapper.writeValueAsString(obj);  
        } catch (Exception e) {  
            throw new RuntimeException("转换json字符失败!");  
        }  
    }  
      
    public <t> T toObject(String json,Class<t> clazz) {  
        try {  
            return (T) mapper.readValue(json, clazz);  
        } catch (IOException e) {  
            throw new RuntimeException("将json字符转换为对象时失败!");  
        }  
    }  
}