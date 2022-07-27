package framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("PMD.ignoreInterfaceDeclarations")
public class createCrowdRun {
    WebDriver driver;

    public createCrowdRun(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    @FindBy(name = "sprintName")
    @CacheLookup
    WebElement txtEventName;

    @FindBy(name = "description")
    @CacheLookup
    WebElement txtEventdescription;

    @FindBy(xpath = "//*[text()=\"Next\"]")
    WebElement btnNext;

    @FindBy(xpath = "//input[@type=\"file\"]")
    @CacheLookup
    WebElement btnUpload;

    @FindBy(xpath = "//*[text()=\"Select online\"]")
    @CacheLookup
    WebElement btnSelectOnline;

    @FindBy(xpath = "//img[@alt=\"person running on top on hill during daytime\"]")
    @CacheLookup
    WebElement imgUpload;

    @FindBy(xpath = "//*[text()=\"Confirm\"]")
    @CacheLookup
    WebElement btnConfirm;

    @FindBy(xpath = "//*[text()=\"Summary\"]")
    @CacheLookup
    WebElement btnSummary;

    @FindBy(xpath = "//*[text()=\"Publish\"]")
    @CacheLookup
    WebElement btnPublish;

    @FindBy(xpath = "//*[text()=\"Your event has been created\"]")
    @CacheLookup
    WebElement CreatedEventTitle;

    @FindBy(xpath = "//*[text()=\"Done\"]")
    @CacheLookup
    WebElement btnDone;
    ////

    public void setEventName(String name) {
        txtEventName.sendKeys(name);

    }

    public void setEventDescription(String description) {
        txtEventdescription.sendKeys(description);

    }

    public void clickNext() {
        btnNext.click();

    }

    public void clickUpload() {
        btnUpload.click();

    }

    public void clickSelectOnline() {
        btnSelectOnline.click();

    }

    public void uploadImg() {
        imgUpload.click();

    }

    public void clickConfirm() {
        btnConfirm.click();
        
    }

    public void clickSummary() {
        btnSummary.click();
        
    }

    public void clickPublish() {
        btnPublish.click();
        
    }

    public String checkCreatedEventTitle() {
        String title = CreatedEventTitle.getText();
        return title;
    }

    public void clickDone() {
        btnDone.click();
        
    }
}
