package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	
	public WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[type='email']")
	WebElement email;

	
	@FindBy(css="[type='submit']")
	WebElement sendmeNotification;
	
	public WebElement getEmail()
	{
		return email;
	}
		
	public WebElement sendmeNotification()
	{
		return sendmeNotification;
	}

}
