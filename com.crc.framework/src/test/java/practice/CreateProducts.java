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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProducts 
{
public static void main(String[] args) throws Throwable
{
String Key="webdriver.chrome.driver";
String value="./chromedriver.exe";
System.setProperty(Key, value);
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
FileInputStream fis=new FileInputStream("./notepad.properties.txt");
Properties pobj=new Properties();
pobj.load(fis);
String URL=pobj.getProperty("url");
String username=pobj.getProperty("un");
String password=pobj.getProperty("pw");
System.out.println(username);
System.out.println(password);
driver.get(URL);
driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
driver.findElement(By.xpath("//input[@id='submitButton']")).click();
Random ran=new Random();
FileInputStream fis1=new FileInputStream("readData.xlsx");
Workbook workbook=WorkbookFactory.create(fis1);
Sheet sheet=workbook.getSheet("Sheet1");
Row row=sheet.getRow(0);
Cell cell=row.getCell(0);
String cellsheet=cell.getStringCellValue()+ran;
System.out.println("cellsheet="+cellsheet);
driver.findElement(By.xpath("//a[.='Products']")).click();
driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
driver.findElement(By.name("productname")).sendKeys("cellsheet");
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(2000);
String ProdName=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
System.out.println("ProdName=+ProdName");
if(ProdName.contains(cellsheet))
{
System.out.println("product created");
}
else
{
System.out.println("product not created");
driver.findElement(By.xpath("//input[@name='Delete']")).click();
Alert al=driver.switchTo().alert();
al.accept();
System.out.println("product is deleted successfully");
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.xpath("//a[.='Sign Out']")).click();
Thread.sleep(4000);
driver.quit();
}
}
}







