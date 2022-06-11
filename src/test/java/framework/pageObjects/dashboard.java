package framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboard {

    WebDriver driver;
	
	public dashboard(WebDriver rdriver){
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

	@FindBy(xpath="//*[text()=\"Create Crowd Run\"]")
	@CacheLookup
	WebElement btnCreateCrowdRun; 
 
	@FindBy(xpath = "//*[text()=\"Selenium Test Event\"]")
    @CacheLookup
    WebElement cardName;

	@FindBy(xpath = "//input[@class=\"search_search__2QreV\"]")
    @CacheLookup
    WebElement txtName;
 
	//
	
    public void clickCreateCrowdRun() {
		btnCreateCrowdRun.click();
		
	}

	public String CheckCardName() {
		String name = cardName.getText();
		return name;
	}

	public void searchName(String name) {
        txtName.sendKeys(name);

    }
 
}
