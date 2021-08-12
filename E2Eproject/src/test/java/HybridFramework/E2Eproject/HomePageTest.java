package HybridFramework.E2Eproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base{

	public static Logger log=LogManager.getLogger(HomePageTest.class.getName());
	public WebDriver driver;
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");		
		//driver.get(prop.getProperty("url"));		
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String access) throws IOException, InterruptedException
	{
					
		HomePage home=new HomePage(driver);
		WebDriverWait wait=new WebDriverWait(driver, 5);
		
		driver.get(prop.getProperty("url")); //only for this test to execute twice
		log.info("Navigated to Home page");
		//wait.until(ExpectedConditions.visibilityOf(home.popup_close));
		//home.popup_close.click();
		if(home.popupSize().size()>0)
			home.popup().click();
		LoginPage login= home.getLogin();
		log.info("Tapped on Login button");
		login.getEmail().sendKeys(username);
		log.info("Entered username");
		login.getPassword().sendKeys(password);
		log.info("Entered password");
		log.info(access);
		login.getLogin().click();
		log.info("Navigated to Login page");
		ForgotPasswordPage forgot=login.getForgotPassword();
		log.info("Navigated to Forgot Password page");
		forgot.getEmail().sendKeys("kiran@gmail.com");
		log.info("Entered Email");
		forgot.sendmeNotification().click();
		Thread.sleep(4000);
		log.info("Tapped on send me notification button");
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//ROWs > how many times data should run
		//columns > how many data per test to pass
		Object[][] loginData= new Object[2][3];
		loginData[0][0]="nonretricteduser@qw.com";
		loginData[0][1]="123456";
		loginData[0][2]="Nonrestricted";
		
		loginData[1][0]="retricteduser@qw.com";
		loginData[1][1]="123456";
		loginData[1][2]="restricted";
		
		return loginData;
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
