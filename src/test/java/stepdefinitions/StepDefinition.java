package stepdefinitions;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import gherkin.formatter.model.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AdminPage;
import utilities.ReadConfig;

public class StepDefinition extends Base{
	
	@Before
	public void setUp() throws Exception
	{
		System.out.println("Set up method execution");
		
		readConfig=new ReadConfig();
		String browser=readConfig.getBrowser();
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Thread.sleep(2000);
	}else if(browser.equalsIgnoreCase("IE")) {
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		}}

	@Given("User Lanch Chrome Browser")
	public void user_lanch_chrome_browser() {
	   
		//driver=new ChromeDriver();
		ad=new AdminPage(driver);
	}

	@When("User open url {string}")
	public void user_open_url(String url) {
	  driver.get(url);  
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
	    ad.setUserName(email);
	    ad.setPassword(password);
	    
	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
	    ad.clickOnLogin();
	}

	@Then("User verify page title should be {string}")
	public void user_verify_page_title_should_be(String title) {
		
		Assert.assertEquals(driver.getTitle(), title);
	    
	}

	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}
    @After   
	public void tearDown(io.cucumber.java.Scenario sc) throws Exception {
    	System.out.println("Tear down method execute after every scenario");
		
    	if(sc.isFailed()==true) {
    	String filePath="C:\\SHITAL_AUTOMATION_COURSE\\BAT_20_Workspace\\07Oct2023CucumberMavenProject\\captureScreenshot\\failedScreenshot.png";
    	
    	TakesScreenshot scrShot=(TakesScreenshot)driver;
    	
    	File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
    	
    	File destFile=new File(filePath);
    	
    	FileUtils.copyFile(scrFile, destFile);
    	
    	Thread.sleep(2000);}

  driver.quit();
}
}