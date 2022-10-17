package cim.crc.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunParameter 
{ 
	public WebDriver driver;
	
	@Test
public void method()
{
	//System.out.println("method running");
String BROWSER=System.getProperty("browser");
System.out.println(BROWSER);
WebDriver driver;
if(BROWSER.equalsIgnoreCase("chrome"))
{
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	String URL=System.getProperty("url");
	driver.get(URL);
	
	}
}
