package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact 
{
	@Test(dataProvider="dataProvider_Test")
public void contactdetails(String firstname, String lastname, String Mobile) throws Throwable
	{
	String key="webdriver.chrome.driver";
	String value="./chromedriver.exe";
	System.setProperty(key, value);
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	FileInputStream fis=new FileInputStream("./notepad.properties.txt");
	Properties pobj=new Properties();
	pobj.load(fis);
	String URL = pobj.getProperty("url");
	String username = pobj.getProperty("un");
	String password = pobj.getProperty("pw");
	System.out.println(username);
	System.out.println(password);
	driver.get(URL);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	driver.findElement(By.id("submitButton")).submit();
	Random ran=new Random();
	FileInputStream fis1 = new FileInputStream("./readData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis1);
	Sheet sheet=workbook.getSheet("Sheet1");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
	String cellsheet = cell.getStringCellValue()+ran;
	String cellsheet1 = cell.getStringCellValue();
	driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"]//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//td[@style='padding-right:0px;padding-left:10px;']//img[@title='Create Contact...']")).click();
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(cellsheet);
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(cellsheet1);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(2000);
	String ContName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	System.out.println("ContName= "+ContName);
	if(ContName.contains(cellsheet))
	{
		System.out.println("Contact created successfully");
	}else {
		System.out.println("Contact not created successfully");
	}
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	Thread.sleep(3000);
	driver.quit();
	}
	@DataProvider
	public Object[][] dataProvider_Test()
	{
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="sagar";
		objArr[0][1]="7795586105"; 
		objArr[0][2]="sagardaya43@gmsail.com";
		objArr[1][0]="dsb";
		objArr[1][1]="7829477681"; 
		objArr[1][2]="beluredayasagar3@gmail.com";
		objArr[2][0]="dsagar";
		objArr[2][1]="9113544408"; 
		objArr[2][2]="dayasagarbelure@gmail.com";
		return objArr;
	}
}
