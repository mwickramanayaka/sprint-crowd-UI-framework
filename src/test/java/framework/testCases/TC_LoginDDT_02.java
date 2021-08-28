package framework.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.pageObjects.LoginPage;
import framework.utilities.XLUtils;

public class TC_LoginDDT_02 extends framework.BaseClass.BaseClass{

	@Test(dataProvider="LoginData")
	public void loginDDT(String email,String pwd) throws InterruptedException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setemailAddress(email);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickLogin();
		Thread.sleep(1000);
		
		if (driver.getTitle().equals("マイページ | HOTEL PLANISPHERE - テスト自動化練習サイト")) {
			Assert.assertTrue(true);
			logger.info("title is matched");
			logger.info("login test passed");
			Thread.sleep(1000);
			lp.clickLogout();
			logger.info("user has logout");
			Thread.sleep(1000);
			lp.clickLoginMenu();
			
		}else {
			logger.warn("expected title not matched with the actual title");
			logger.error("login test failed");
			Assert.assertTrue(false);
			
		}
		
	}

	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path= ".\\TestDataFiles\\LoginData.xlsx";
		XLUtils XLUtils = new XLUtils(path);

		int rownum=XLUtils.getRowCount("Sheet1");
		int colcount=XLUtils.getCellCount("Sheet1",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData("Sheet1", i,j);//1 0
			}

		}
		return logindata;
	}

}
