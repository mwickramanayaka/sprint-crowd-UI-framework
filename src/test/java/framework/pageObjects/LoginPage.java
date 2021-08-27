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

	@FindBy(xpath="//*[@id=\"login-holder\"]/a")
	@CacheLookup
	WebElement btnLoginMenu;

	@FindBy(name="email")
	@CacheLookup
	WebElement txtEmailAddress;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(id="login-button")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//*[@id=\"logout-form\"]/button")
	@CacheLookup
	WebElement btnLogout;
	
	public void clickLoginMenu() {
		btnLoginMenu.click();
		
	}
	
	public void setemailAddress(String email) {
		txtEmailAddress.sendKeys(email);
		
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