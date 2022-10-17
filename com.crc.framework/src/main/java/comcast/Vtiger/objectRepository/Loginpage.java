package comcast.Vtiger.objectRepository;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class Loginpage {
		
			//initializaton
			
		public Loginpage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);	
		}
		public WebElement getUserNameTextField() {
			return userNameTextField;
		}
		public WebElement getPasswordTextField() {
			return passwordTextField;
		}
		public WebElement getSubmitbutton() {
			return submitbutton;
		}
		/**
		 * this method is used to login the application
		 * @author sagar
		 */
		//Declaration
		@FindBy(name="user_name")
		private WebElement userNameTextField;
		@FindBy(name="user_password")
		private WebElement passwordTextField;
		@FindBy(id="submitButton")
		private WebElement submitbutton;
		public void login(String  userName,String password)
		{
			userNameTextField.sendKeys(userName);
			passwordTextField.sendKeys(password);
			submitbutton.click();
	}
	}
