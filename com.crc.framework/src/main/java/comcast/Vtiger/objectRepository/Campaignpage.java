package comcast.Vtiger.objectRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic_Utilities.webDriver_utility;

public class Campaignpage
{
	public WebDriver driver;
	//intialization
	public Campaignpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(xpath="//a[text()='More']")
	private WebElement morelink;
	
	
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campainlink;
	
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plussign;
	 
	@FindBy(xpath ="//input[@name='campaignname']")  //campaignpage campaigntextfield
	private WebElement textfield;
	
	@FindBy(xpath ="//img[@language='javascript']")
	private WebElement producttextfieldplussign;  //campaignspage producttextfield plussign
	
	
	@FindBy(xpath ="//a[@id='1']")
	private WebElement cellsheetforproductadd;  //productname adding click on cellsheet present in the productplussign
	
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	
	//getter method
	
	public WebElement getClickOnmorelink() {
		return morelink;
	}
	public WebElement getClickOnCreateCampaign() {
		return campainlink;
	}
	
	public WebElement getcampaignplussign() {
		return plussign;
	}

	public WebElement getClickOncampaintextfield() {
		return textfield;
	}
	
	public WebElement getClickOnproducttextfieldplussign() {
		return producttextfieldplussign;
	
	}
	public WebElement getClickOncellsheetforproductadd() {
		return cellsheetforproductadd;
		
	}
	
	public WebElement getsavebutton() {
		return savebutton;
	}
	
	
	//Business logic method
	public void createcampain(String name) {
		morelink.click();
		campainlink.click();
		 plussign.click();
		 textfield.sendKeys(name);
		 producttextfieldplussign.click();
	}
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
		cellsheetforproductadd.click();
		driver.switchTo().window(parent);
}

	public void savebutton() {
		 savebutton.click();
	}
	
	
}