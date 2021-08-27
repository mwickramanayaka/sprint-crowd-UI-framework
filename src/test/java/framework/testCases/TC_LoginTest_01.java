/**
 * 
 */
package framework.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pageObjects.LoginPage;

public class TC_LoginTest_01 extends framework.BaseClass.BaseClass {

	@Test
	public void loginTest() throws IOException, InterruptedException {
		
		LoginPage lp = new LoginPage(driver);

		lp.setemailAddress(emailAddress);
		logger.info("Email Address entered");
		lp.setPassword(password);
		logger.info("password entered");
		lp.clickLogin();
		
		if (driver.getTitle().equals("マイページ | HOTEL PLANISPHERE - テスト自動化練習サイト")) {
			Assert.assertTrue(true);
			logger.info("title is matched");
			logger.info("login test passed");
			Thread.sleep(1000);
			
		}else {
			logger.warn("expected title not matched with the actual title");
			logger.error("login test failed");
			Assert.assertTrue(false);
			
		}

	}
}