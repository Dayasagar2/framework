package comcast.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic_Utilities.webDriver_utility;

public class Organizationpage 
{
	public WebDriver driver;
	//intialization
	public Organizationpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(xpath ="//td[@style='padding-right:0px;padding-left:10px;']//img[@title='Create Organization...']")
	private WebElement ClickOnCreateOrganization;
	
	@FindBy(xpath ="//input[@name='accountname']")
	private WebElement OrganizationName;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement ClickOnSavebutton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OraganizationTextName;//company name saved inspect
	
	@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
	private WebElement DeleteOraganization;
	
	//getter method
	public WebElement getClickOnCreateOrganization() {
		return ClickOnCreateOrganization;
	}
	
	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getClickOnSavebutton() {
		return ClickOnSavebutton;
	}
	
	public WebElement getOraganizationTextName() {
		return OraganizationTextName;
	}
	
	public WebElement getDeleteOraganization() {
		return DeleteOraganization;
	}
	
	//Business logic method
	public void organizationpage(String name) {
		ClickOnCreateOrganization.click();
		OrganizationName.sendKeys(name);
	}
	public void clicksavebutton()
	{
		ClickOnSavebutton.click();
	}
	
	public void organizationpageVerification(String data) {
		String actualData = OraganizationTextName.getText();
		System.out.println("actualData= "+actualData);
		if(actualData.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
	
 webDriver_utility wlib=new webDriver_utility();
	public void deleteOrganization(WebDriver driver) {
		DeleteOraganization.click();
		wlib.switchToAlertAndAccept(driver);
	    System.out.println("delete successfully");
	}
}


