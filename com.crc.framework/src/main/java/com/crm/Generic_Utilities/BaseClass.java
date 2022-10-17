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

import comcast.Vtiger.objectRepository.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{ 
	public  WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite ( groups={"smokeTest","regressionTest","sanityTest"})
	public void BS()
	{
	System.out.println("DataBase Connection");
	}
	
	@BeforeTest ( groups={"smokeTest","regressionTest","sanityTest"})
	public void BT()
	{
	System.out.println("Execute in Parallel mode");
	}
	file_utilty flib=new file_utilty();
	
	//@Parameters("BROWSER")
	//@BeforeClass (groups={"smokeTest","regressionTest","sanityTest"})
	//public void BC(String BROWSER) throws Throwable
	@BeforeClass
	public void BC() throws Throwable
	{
	System.out.println("Launching the Browser");
	String Browser = flib.getPropertyKeyValue("browser");
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
	sdriver=driver;
	}
	
	@BeforeMethod ( groups={"smokeTest","regressionTest","sanityTest"})
	public void BM() throws Throwable
	{
	System.out.println("Login To Application");
	 String URL = flib.getPropertyKeyValue("url");
	   	String username = flib.getPropertyKeyValue("un");
		String password = flib.getPropertyKeyValue("pw");
		driver.get(URL);
		Loginpage login = new Loginpage(driver);
		login.login(username, password);
	}
	
	@AfterMethod ( groups={"smokeTest","regressionTest","sanityTest"})
	public void AM()
	{
	System.out.println("Logout The Application");
	}
	@AfterClass ( groups={"smokeTest","regressionTest","sanityTest"})
	public void AC()
	{
		driver.quit();
	System.out.println("Close The Browser");
	}
	@AfterTest ( groups={"smokeTest","regressionTest","sanityTest"})
	public void AT()
	{
	System.out.println("Executed successfully");
	}
	@AfterSuite
	public void AS()
	{
	System.out.println("DataBase close");
	}
}
