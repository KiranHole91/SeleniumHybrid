package HybridFramework.E2Eproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class validateTest extends Base{
	
	public static Logger log=LogManager.getLogger(validateTest.class.getName());
	public WebDriver driver;
	

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));	
		log.info("Navigated to Home page");
	}
	
	@Test
	public void validateTitle()
	{
		HomePage home=new HomePage(driver);
		if(home.popupSize().size()>0)
			home.popup().click();
		String title = home.getTitle().getText();
		log.info("Successfully validated title : "+title);
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
