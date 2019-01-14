package com.uniwareauto.cofig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.exec.OS;

public class FileUtil {
	Properties prop=new Properties();
	FileInputStream input=null;
	String value;
	
public static String separator=File.separator;
//public static String fileName = separator + "Constant.cfg";

public String getConstants(String constant) throws FileNotFoundException
{
	
	System.out.println(separator);
	String path=System.getProperty("user.dir")+separator+"environment.cfg";
	
	System.out.println(path);
	File fw=new File(path);
	if(fw.exists())
	{
	 input = new FileInputStream(path);
	 System.out.println("file found");
	}
	try {
		prop.load(input);
		System.out.println("properties loaded");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	value=prop.getProperty("environment");
	
	path=System.getProperty("user.dir")+separator+value+".cfg";
	System.out.println(path);
	 fw=new File(path);
	if(fw.exists())
	{
	 input = new FileInputStream(path);
	 System.out.println("file found");
	}
	try {
		prop.load(input);
		System.out.println("properties loaded");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(constant);
	value=prop.getProperty(constant);
	
	return value;
	
	
}
public String getEnvironment()
{
	value=System.getProperty("os.name");
	return value;
	
}
public String getPath()
{
	String value=System.getProperty("user.dir")+separator;
	return value;
	
}

}
