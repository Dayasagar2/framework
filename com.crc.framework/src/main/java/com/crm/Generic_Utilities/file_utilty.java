package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;
public class file_utilty 
{
	/**
	 * 
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author Sagar
	 */
public String getPropertyKeyValue(String Key) throws Throwable
{
	///FileInputStream fis = new FileInputStream("./notepad.properties.txt");
	FileInputStream fis = new FileInputStream(ipathConstant.PROPERTYFILE_PATH);
	Properties pro = new Properties();
	pro.load(fis);
	String value = pro.getProperty(Key);
	return value;
}
}