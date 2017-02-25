package com.junly.common.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.springframework.core.io.UrlResource;

public class Ts {
   public static void main(String[] args) throws IOException {
	   UrlResource ur = new UrlResource("file:src/log4j.properties");
	System.out.println(ur.getFilename());
	
	 Properties p = new Properties();
	 p.load(ur.getInputStream());
	 String property = p.getProperty("log4j.rootLogger");
	 System.out.println(property);
}
}
