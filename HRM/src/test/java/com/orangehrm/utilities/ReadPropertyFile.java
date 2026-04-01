package com.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile 
{	
	public static String readData(String key) throws IOException
	{
		//FileInputStream fis=new FileInputStream(".//src//test//resources//PropertyFile//config.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/PropertyFile/config.properties");

		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}



