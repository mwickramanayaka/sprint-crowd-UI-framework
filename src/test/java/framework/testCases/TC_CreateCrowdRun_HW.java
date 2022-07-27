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

@SuppressWarnings("PMD")
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
        logger.info("Event Step-1 completed");
        Thread.sleep(2000);

        ccr.clickNext();
        logger.info("Event Step-2 completed");
        Thread.sleep(2000);

        ccr.clickNext();
        logger.info("Event Step-3 completed");
        Thread.sleep(2000);

        ccr.clickSelectOnline();
        Thread.sleep(2000);
        ccr.uploadImg();
        logger.info("Image is Uploaded");
        Thread.sleep(2000);
        ccr.clickConfirm();
        logger.info("Event Step-4 completed");
        Thread.sleep(2000);

        ccr.clickSummary();
        Thread.sleep(2000);
        ccr.clickPublish();
        logger.info("Published");
        Thread.sleep(5000);

        //Object need to change according to card name
        if (ccr.checkCreatedEventTitle().equals("Your event has been created")) {
            Assert.assertTrue(true);
            logger.info("title is matched, Your event has been created");
            logger.info("Event passed");
            Thread.sleep(1000);

        } else {
            logger.warn("expected title not matched with the actual title, Your event has not been created");
            logger.error("Event failed");
            Assert.assertTrue(false);

        }

        ccr.clickDone();
        logger.info("Redirected to Dashboard");
        Thread.sleep(2000);

        db.searchName(cardName);
        Thread.sleep(5000);

        if (db.CheckCardName().equals("Selenium Test Event")) {
            Assert.assertTrue(true);
            logger.info("title is matched, Your card apeared in Dashboard");
            logger.info("Event passed");
            Thread.sleep(1000);

        } else {
            logger.warn("expected title not matched with the actual title, Your card has not apeared in Dashboard");
            logger.error("Event failed");
            Assert.assertTrue(false);

        }


    }
}