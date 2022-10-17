package com.crm.Generic_Utilities;
	import java.time.Duration;
	import java.util.Iterator;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;
	public class webDriver_utility {
		
		public void waitForPageToLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		public void scriptTimeOut(WebDriver driver)
		{
			driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		}
		
		public void waitForElementToBeClickable(WebDriver driver, WebElement Element)
		{
			driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		}
		
	/*	public void webForElementToBeClickable(WebDriver driver,WebElement element )
		{
		FluentWait wait = new FluentWait(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		*/
		
		public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement Element,int pollingTime)
		{
			FluentWait wait = new FluentWait(driver);
			wait.pollingEvery(Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(Element));
		}
		public void select(WebElement element,int index)
		{
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		
		public void select(WebElement element,String text)
		{
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		public void switchToFrame(WebDriver driver,String id_name_Atrribute)
		{
		driver.switchTo().frame(id_name_Atrribute);
		}
		public void switchToFrame(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
		}
		public void switchToAlertAndAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		public void switchToAlertAndDismiss(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		public void rightClickOnElement(WebDriver driver,WebElement element)
		{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		}
		public String takeScreenshot(WebDriver driver,String methodName)
		{
		return null;
		}
		/*public void moveByOffset(WebDriver driver, int x, int y)
		{
			Action act = new Actions(driver);
			act.moveByOffset(x,y).click().perform();
		}
		implicit wait-
	explicit wait
	Action-
	Select-
	frames
	Alert
		*/
		public void switchToWindow(WebDriver driver,String PartialWindowTitle)
		{
			String parent = driver.getWindowHandle();
			Set<String> allId = driver.getWindowHandles();
			Iterator<String> it = allId.iterator();
			while(it.hasNext())
			{
				String wid = it.next();
				driver.switchTo().window(wid);
				if(driver.getTitle().contains(PartialWindowTitle))
				{
					break;
				}
			}
			driver.switchTo().window(parent);
}
	}