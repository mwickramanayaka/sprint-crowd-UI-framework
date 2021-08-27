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

	@FindBy(name="email")
	@CacheLookup
	WebElement txtEmailAddress;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(id="login-button")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(name="btnReset")
	@CacheLookup
	WebElement btnReset;
	
	@FindBy(xpath="//*[text()=\"Log out\"]")
	@CacheLookup
	WebElement btnLogout;	
	
	public void setemailAddress(String uname) {
		txtEmailAddress.sendKeys(uname);
		
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
		
	}
	
	public void clickLogin() {
		btnLogin.click();
		
	}
	
	public void clickLogout() {
		btnLogout.click();
		
	}

}