package comcast.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic_Utilities.webDriver_utility;

public class Contactspage
{
	public WebDriver driver;
	//intialization
	public Contactspage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(xpath ="//a[text()='Contacts']")
	private WebElement ClickOnCreateContacts;
	
	@FindBy(xpath ="//img[@title='Create Contact...']")
	private WebElement plussign;
	
	
	@FindBy(xpath ="//input[@name='firstname']")
	private WebElement FirstName;
	 
	@FindBy(xpath ="//input[@name='lastname']")
	private WebElement LastName;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement ClickOnSavebutton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactsTextName;//contact name saved inspect we get the saved contactname text
	
	@FindBy(xpath="//input[@name='Delete']")
	private WebElement DeleteContacts;
	
	//getter method
	public WebElement getClickOnCreateContacts() {
		return ClickOnCreateContacts;
	}
	
	public WebElement getplussign() {
		return plussign;
	}
	
	public WebElement getFirstName() {
		return FirstName;
	}
	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getClickOnSavebutton() {
		return ClickOnSavebutton;
	}
	
	public WebElement getContactsTextName() {
		return ContactsTextName;
	}
	
	public WebElement getDeletecontacts() {
		return DeleteContacts;
	}
	//Business logic method
	public void Contactspage(String name) {
		ClickOnCreateContacts.click();
		plussign.click();
		FirstName.sendKeys(name);
		LastName.sendKeys(name);
	}
	
	public void clicksavebutton()
	{
		ClickOnSavebutton.click();
	}
	
	public void ContactspageVerification(String data) {
		String actualData = ContactsTextName.getText();
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
	public void deleteContacts(WebDriver driver) {
		DeleteContacts.click();
		wlib.switchToAlertAndAccept(driver);
	    System.out.println("delete successfully");
	}
}


