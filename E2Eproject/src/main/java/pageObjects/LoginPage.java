package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_email")
	WebElement email;
	
	@FindBy(css="#user_password")
	WebElement password;
	
	@FindBy(css="input[name='commit']")
	WebElement login;
	
	@FindBy(css=".link-below-button")
	WebElement forgotPassword;
	
	public WebElement getEmail()
	{
		return email;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	public WebElement getLogin()
	{
		return login;
	}
	
	public ForgotPasswordPage getForgotPassword()
	{
		forgotPassword.click();
		return new ForgotPasswordPage(driver);
	}
	
	public WebElement ForgotPasswordCucu()  // for Cucumber
	{
		return forgotPassword;
	}

}
