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
        lp.setPassword(password);
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
        Thread.sleep(2000);
        ccr.clickConfirm();
        Thread.sleep(2000);
        ccr.clickSummary();
        Thread.sleep(2000);
        ccr.clickPublish();
        Thread.sleep(5000);
        if (ccr.checkCreatedEventTitle().equals("Your event has been created")) {
            Assert.assertTrue(true);
            Thread.sleep(1000);
        } else {
            Assert.assertTrue(false);

        }
        ccr.clickDone();
        Thread.sleep(2000);
        db.searchName(cardName);
        Thread.sleep(5000);
        if (db.CheckCardName().equals("Selenium Test Event")) {
            Assert.assertTrue(true);
            Thread.sleep(1000);
        } else {
            Assert.assertTrue(false);
        }
    }
}