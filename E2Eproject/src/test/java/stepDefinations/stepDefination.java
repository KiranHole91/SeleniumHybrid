package stepDefinations;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

public class stepDefination extends Base{

	HomePage home=new HomePage(driver);
	
	@Given("User initializes the browser")
	public void user_initializes_the_browser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");	
	}
	@Given("User navigates to {string} site")
	public void user_navigates_to_site(String string) {
	   driver.get(string);
	}
	@Given("User clicks on Login to securely redirected to login page")
	public void user_clicks_on_login_to_securely_redirected_to_login_page() throws InterruptedException {
		 HomePage home=new HomePage(driver);
		if(home.popupSize().size()>0)
			home.popup().click();
		 home.LoginCucu().click();
		log.info("Tapped on Login button");
	}
	
	@Then("User validates forgot password is available")
	public void user_validates_forgot_password_is_available() {
		LoginPage login=new LoginPage(driver);
		Assert.assertTrue(login.ForgotPasswordCucu().isDisplayed());
	}
	


	@When("^User enters (.+) and (.+) and clicks login button$")
    public void user_enters_and_and_clicks_login_button(String username, String password) throws Throwable {
		LoginPage login=new LoginPage(driver);
		login.getEmail().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getLogin().click();
    }



}
