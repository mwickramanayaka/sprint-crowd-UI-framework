package framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboard {
    WebDriver driver;
	String name;

	public dashboard(WebDriver rDriver){
		driver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath="//*[text()=\"Create Crowd Run\"]")
	@CacheLookup
	WebElement btnCreateCrowdRun; //NOPMD
 
	@FindBy(xpath = "//*[text()=\"Selenium Test Event\"]")
    @CacheLookup
    WebElement cardName;//NOPMD

	@FindBy(xpath = "//input[@class=\"search_search__2QreV\"]")
    @CacheLookup
    WebElement txtName;//NOPMD
	
    public void clickCreateCrowdRun() {
		btnCreateCrowdRun.click();
	}

	public String CheckCardName() {
		return cardName.getText();
	}

	public void searchName(String name) {
        txtName.sendKeys(name);
    }
 
}
