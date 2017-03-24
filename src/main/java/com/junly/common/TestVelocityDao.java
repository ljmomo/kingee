package com.junly.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class TestVelocityDao {
    public static void main(String[] args) throws IOException {
    	Properties p = new Properties();
    	p.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, "C:/Users/李俊/workspace/kingee/src/main/java/com/junly/common/");
    	Velocity.init(p);
    	VelocityContext context = new VelocityContext();
    	context.put( "package", new String("com.it.junly") );
    	context.put( "className", new String("Person") );
    	context.put( "comments", new String("测试") );
    	context.put( "author", new String("李俊") );
    	context.put( "email", new String("1796518311@qq.com") );
    	context.put( "datetime", new String("2016-03-01") );
    	Template template = null;
    	 template = Velocity.getTemplate("Dao.java.vm");
    	 PrintWriter writer   = new PrintWriter("E:/" + "Person" + "Dao" + ".java"); 
    	 template.merge(context, writer );
    	 writer.flush(); 
	}
}
