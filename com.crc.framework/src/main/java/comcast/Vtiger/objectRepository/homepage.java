package comcast.Vtiger.objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
	public homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
 //declaration
	@FindBy(linkText="Products")
	private WebElement productLinkText;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLinktext;
	    //<img src="themes/softed/images/user.PNG" 
	@FindBy(linkText="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLinktext;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLinktext;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutlink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutbutton;
	
	//getter method
	public WebElement getProductLinkText() 
	{
		return productLinkText;
	}
	
	public WebElement getOrganizationLinktext() {
		return organizationLinktext;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getcontactsLinktext() {
		return contactsLinktext;
	}
	
	public WebElement getCampaignsLinktext() {
		return campaignsLinktext;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
   public WebElement getSignoutbutton() {
		return signoutbutton;
	}
   
   //business logic methods 
	public void signout()
	{
		logoutlink.click();
		signoutbutton.click();
    }
	
	public void clickonorganization()
	 {
		organizationLinktext.click();	
	}
	
	public void clickoncontacts()
	 {
		contactsLinktext.click();	
	}
	
	public void clickonproduct()
	{
		productLinkText.click();
	}

	public void clickoncampaign(WebDriver driver)
	{
		Actions action =new Actions(driver);
		action.moveToElement(moreLink);
		
	}
	
}

