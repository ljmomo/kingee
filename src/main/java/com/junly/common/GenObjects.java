package com.junly.common;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;  
  
public class GenObjects {  
  
    public static void main(String[] args) throws IOException,  
            TemplateException {  
  
        /* ------------------------------------------------------------------- */  
        /* You usually do it only once in the whole application life-cycle: */  
  
        /* Create and adjust the configuration */  
        Configuration cfg = new Configuration();  
        cfg.setDirectoryForTemplateLoading(new File(  
                "C:/Users/李俊/workspace/kingee/src/main/java/com/junly/common"));  
        cfg.setObjectWrapper(new DefaultObjectWrapper());  
  
        /* ------------------------------------------------------------------- */  
        /* You usually do these for many times in the application life-cycle: */  
  
        /* Get or create a template */  
        Template temp = cfg.getTemplate("Enty.ftl");  
  
        /* Create a data-model */  
        Map<String, Object> root = new HashMap<String, Object>();  
        root.put("class", "Person");  
        Collection<Map<String, String>> properties = new HashSet<Map<String, String>>();  
        root.put("properties", properties);  
  
        /* subfield 1: currency */  
        Map<String, String> currency = new HashMap<String, String>();  
        currency.put("name", "currency");  
        currency.put("type", "String");  
        properties.add(currency);  
  
        /* subfield 2: amount */  
        Map<String, String> amount = new HashMap<String, String>();  
        amount.put("name", "amount");  
        amount.put("type", "Double");  
        properties.add(amount);  
  
        /* Merge data-model with template */  
   /*     File file = new File("E:/Person.java");
        if (!file.exists()) {
            file.createNewFile();
           }
        FileOutputStream fop = new FileOutputStream(file);
        Writer out = new OutputStreamWriter(fop);  */
        
        PrintWriter writer   = new PrintWriter("E:/Person.java"); 
        temp.process(root, writer);  
        writer.flush();  
        
    }  
  
} 