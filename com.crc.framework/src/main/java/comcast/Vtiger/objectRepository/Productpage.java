package comcast.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic_Utilities.webDriver_utility;

public class Productpage
{
	public WebDriver driver;
	//intialization
	public Productpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(xpath ="//a[.='Products']")
	private WebElement ClickOnCreateProducts;
	
	@FindBy(xpath ="//img[@alt='Create Product...']")
	private WebElement Plussign;
	

	@FindBy(xpath="//input[@name='productname']")
	private WebElement Producttextname;
	
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement ClickOnSavebutton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ProductsTextName;//product name saved inspect we get the saved productname text
	
	@FindBy(xpath="//input[@name='Delete']")
	private WebElement DeleteProducts;
	
	//getter method
	public WebElement getClickOnCreatProducts() {
		return ClickOnCreateProducts;
	}
	
	public WebElement getProductName() {
		return Plussign;
	}
	
	
	public WebElement getProducttextName() {
		return Producttextname;
	}
	
	public WebElement getClickOnSavebutton() {
		return ClickOnSavebutton;
	}
	
	public WebElement getDeleteproduct() {
		return DeleteProducts;
	}
	//Business logic method
	public void Productpage(String name) {
		ClickOnCreateProducts.click();
		Plussign.click();
		Producttextname.sendKeys(name);
		ClickOnSavebutton.click();
	}
	webDriver_utility wlib=new webDriver_utility();
	public void Deleteproductpage(WebDriver driver) {
		DeleteProducts.click();
			wlib.switchToAlertAndAccept(driver);
		  
		}
}

