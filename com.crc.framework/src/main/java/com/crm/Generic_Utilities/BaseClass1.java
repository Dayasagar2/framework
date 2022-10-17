package com.crm.Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1
{
	public WebDriver driver;
	@BeforeSuite ( groups={"smokeTest","regressionTest","sanityTest"})
	public void BS()
	{
		System.out.println("database connection");
	}
	
	@BeforeTest ( groups={"smokeTest","regressionTest","sanityTest"})
	public void BT()
	{
		System.out.println("Execute in Parallel mode");
	}
	
	file_utilty flib=new file_utilty();
	@BeforeClass ( groups={"smokeTest","regressionTest","sanityTest"})
	public void BC() throws Throwable
	{
		String Browser = flib.getPropertyKeyValue("browser");
		System.out.println("Launching the browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
			{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
			}
		else if(Browser.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		}	
	}
	@BeforeMethod ( groups={"smokeTest","regressionTest","sanityTest"})
	public void BM()
	{
		System.out.println("login the appilication");
	}
	
	@AfterMethod ( groups={"smokeTest","regressionTest","sanityTest"})
	public void AM()
	{
		System.out.println("logout the application");
	}
	@AfterClass ( groups={"smokeTest","regressionTest","sanityTest"})
	public void AC()
	{
		System.out.println("close the browser");
}
	@AfterTest ( groups={"smokeTest","regressionTest","sanityTest"})
	public void AT()
	{
		System.out.println("executed successfully");
	}
	@AfterSuite ( groups={"smokeTest","regressionTest","sanityTest"})
	public void AS()
	{
		System.out.println("database close");
	}
}