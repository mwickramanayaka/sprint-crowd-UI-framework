package framework.pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver rdriver){
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

	@FindBy(id="formGroupEmail")
	@CacheLookup
	WebElement txtEmailAddress;
	
	@FindBy(id="formGroupPassword")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//*[text()=\"Login\"]")
	@CacheLookup
	WebElement btnLogin;
	
	public void setemailAddress(String email) {
		txtEmailAddress.sendKeys(email);
		
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
		
	}
	
	public void clickLogin() {
		btnLogin.click();
		
	}

}