package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class CreateCampaignInMoreLinks
{
public static void main(String[] args) throws Throwable
{
String key="webdriver.chrome.driver";
String value="./chromedriver.exe";
System.setProperty(key, value);
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
FileInputStream fis=new FileInputStream("./notepad.properties.txt");
Properties pobj=new Properties();
pobj.load(fis);
String URL=pobj.getProperty("url");
String username=pobj.getProperty("un");
String password=pobj.getProperty("pw");
System.out.println("username");
System.out.println("password");
driver.get(URL);
driver.findElement(By.name("user_name")).sendKeys(username);
driver.findElement(By.name("user_password")).sendKeys(password);
driver.findElement(By.id("submitButton")).click();
Random ran= new Random();
FileInputStream fis1=new FileInputStream("./readData.xlsx");
Workbook book=WorkbookFactory.create(fis1);
Sheet sheet=book.getSheet("Sheet1");
Row row=sheet.getRow(0);
Cell cel=row.getCell(0);
String cellsheet=cel.getStringCellValue()+ran;
System.out.println("cellsheet="+cellsheet);
driver.findElement(By.xpath("//a[.='More']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//a[.='Campaigns']")).click();
driver.findElement(By.xpath("//td[@style='padding-right:0px;padding-left:10px;']//a//img[@title='Create Campaign...']")).click();
driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(cellsheet);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(2000);
String campaignName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
System.out.println("campaignName= "+campaignName);
if(campaignName.contains(cellsheet))
{
System.out.println("campaign created successfully");
}
else
{
	System.out.println("campaign not created successfully");
}

/*driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
Alert al = driver.switchTo().alert();
al.accept();
System.out.println(" Created delete sucussfully");*/
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.xpath("//a[.='Sign Out']")).click();
Thread.sleep(4000);
driver.quit();
}
}

