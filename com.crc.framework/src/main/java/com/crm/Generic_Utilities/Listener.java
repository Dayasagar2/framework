package com.crm.Generic_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
	String data=result.getMethod().getMethodName();
	EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
	File src=edriver.getScreenshotAs(OutputType.FILE);
	try
	{
	File des=new File("./com.crc.framework/Screenshot/"+data+"");
	FileUtils.copyFile(src, des);
	}
catch(Exception e)
{
e.printStackTrace();
}
	}
}
