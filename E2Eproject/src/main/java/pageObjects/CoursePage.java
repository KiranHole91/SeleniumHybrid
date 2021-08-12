package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursePage {
	
	
	public WebDriver driver;
	
	public CoursePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='courses-block col-lg-3 col-md-4 col-sm-6 col-xs-12']")
	List<WebElement> noOfCourses;
	
	
	
	
	
	public void getNoOfCourses()
	{	
		System.out.println("Total courses are : "+noOfCourses.size());
	}

}
