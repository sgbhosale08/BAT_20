package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	WebDriver ldriver;
	
	public AdminPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='Password']" )
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement btnLogin;
	
	public void setUserName(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	
	public void clickOnLogin()
	{
		btnLogin.click();
	}
	
	
}
