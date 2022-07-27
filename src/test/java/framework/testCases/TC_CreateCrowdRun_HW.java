/**
 *
 */
package framework.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pageObjects.LoginPage;
import framework.pageObjects.createCrowdRun;
import framework.pageObjects.dashboard;

public class TC_CreateCrowdRun_HW extends framework.BaseClass.BaseClass {

    String cardName = "Selenium Test Event";

    @Test
    public void CrowdRunTest() throws IOException, InterruptedException {

        LoginPage lp = new LoginPage(driver);
        dashboard db = new dashboard(driver);
        createCrowdRun ccr = new createCrowdRun(driver);

        lp.setemailAddress(emailAddress);
        logger.info("Email Address entered");
        lp.setPassword(password);
        logger.info("password entered");
        lp.clickLogin();
        Thread.sleep(3000);

        db.clickCreateCrowdRun();
        ccr.setEventName(cardName);
        ccr.setEventDescription("Test Description");
        Thread.sleep(2000);
        ccr.clickNext();
        Thread.sleep(2000);
        ccr.clickNext();
        Thread.sleep(2000);
        ccr.clickNext();
        Thread.sleep(2000);
        ccr.clickSelectOnline();
        Thread.sleep(2000);
        ccr.uploadImg();
        logger.info("Image is Uploaded");
        Thread.sleep(2000);
        ccr.clickConfirm();
        Thread.sleep(2000);

        ccr.clickSummary();
        Thread.sleep(2000);
        ccr.clickPublish();
        logger.info("Published");
        Thread.sleep(5000);

        ccr.clickDone();
        Thread.sleep(5000);
    }
}