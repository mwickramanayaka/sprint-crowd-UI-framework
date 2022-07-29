package framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createCrowdRun {
    WebDriver driver;
    String title;

    public createCrowdRun(WebDriver rDriver) {
        driver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    @FindBy(name = "sprintName")
    @CacheLookup
    WebElement txtEventName;//NOPMD

    @FindBy(name = "description")
    @CacheLookup
    WebElement txtEventDescription;//NOPMD

    @FindBy(xpath = "//*[text()=\"Next\"]")
    WebElement btnNext;//NOPMD

    @FindBy(xpath = "//input[@type=\"file\"]")
    @CacheLookup
    WebElement btnUpload;//NOPMD

    @FindBy(xpath = "//*[text()=\"Select online\"]")
    @CacheLookup
    WebElement btnSelectOnline;//NOPMD

    @FindBy(xpath = "//img[@alt=\"person running on top on hill during daytime\"]")
    @CacheLookup
    WebElement imgUpload;//NOPMD

    @FindBy(xpath = "//*[text()=\"Confirm\"]")
    @CacheLookup
    WebElement btnConfirm;//NOPMD

    @FindBy(xpath = "//*[text()=\"Summary\"]")
    @CacheLookup
    WebElement btnSummary;//NOPMD

    @FindBy(xpath = "//*[text()=\"Publish\"]")
    @CacheLookup
    WebElement btnPublish;//NOPMD

    @FindBy(xpath = "//*[text()=\"Your event has been created\"]")
    @CacheLookup
    WebElement CreatedEventTitle;//NOPMD

    @FindBy(xpath = "//*[text()=\"Done\"]")
    @CacheLookup
    WebElement btnDone;//NOPMD

    public void setEventName(String name) {
        txtEventName.sendKeys(name);
    }

    public void setEventDescription(String description) {
        txtEventDescription.sendKeys(description);
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
        return CreatedEventTitle.getText();
    }

    public void clickDone() {
        btnDone.click();
    }
}
