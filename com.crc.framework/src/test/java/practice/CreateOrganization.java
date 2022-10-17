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
public class CreateOrganization
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
	String cellvalue = cell.getStringCellValue()+ran;
	System.out.println("cellvalue="+cellvalue);
	driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"]//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//td[@style='padding-right:0px;padding-left:10px;']//img[@title='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(cellvalue);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(2000);
	String OrgName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	System.out.println("OrgName= "+OrgName);
	if(OrgName.contains(cellvalue))
	{
		System.out.println("pass");
		System.out.println("pass1");
	}
	else
	{
		System.out.println("fail");
	}
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	Thread.sleep(3000);
	driver.quit();
	}
}

