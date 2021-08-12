package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(css="a[href*='sign_in']")
	WebElement signin;
	
	@FindBy(css=".text-center>h2")
	WebElement title;
	
	@FindBy(css="ul[class*='navbar-right']")
	WebElement nav_bar;
	
	@FindBy(css=".nav.navbar-nav.navbar-right>li:nth-child(2)>a")
	WebElement courses;
	
	By popup = By.xpath("//*[text()='NO THANKS']");
	
	public LoginPage getLogin() //Click on Login button & return loginPage obj
	{
		 signin.click();
		LoginPage login = new LoginPage(driver);
		return login;
	}
	
	public WebElement LoginCucu() //for cucumber
	{
		 return signin;
	}
	
	public WebElement getNavBar()
	{
		return nav_bar;
	}	
	
	public WebElement getTitle()
	{
		return title;
	}
	
	public CoursePage getCourses() //Click on courses & return CoursesPage obj
	{
		courses.click();
		return new CoursePage(driver);
	}
	
	public List<WebElement> popupSize()
	{
		return driver.findElements(popup);
	}
	
	public WebElement popup()
	{
		return driver.findElement(popup);
	}

}
