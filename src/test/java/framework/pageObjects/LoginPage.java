package framework.pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver rDriver){
		driver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(id="formGroupEmail")
	@CacheLookup
	WebElement txtEmailAddress;//NOPMD
	
	@FindBy(id="formGroupPassword")
	@CacheLookup
	WebElement txtPassword;//NOPMD
	
	@FindBy(xpath="//*[text()=\"Login\"]")
	@CacheLookup
	WebElement btnLogin;//NOPMD
	
	public void setEmailAddress(String email) {
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}

}