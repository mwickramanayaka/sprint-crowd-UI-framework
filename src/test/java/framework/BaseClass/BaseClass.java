/**
 * 
 */
package framework.BaseClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import framework.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public String emailAddress = readConfig.getEmailAddress();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
    public static WebElement element;
	public static WebElement linkElement;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = LogManager.getLogger(BaseClass.class);

		if(br.equalsIgnoreCase("chrome")) {//NOPMD
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath() );
			driver = new ChromeDriver();
		}else if(br.equalsIgnoreCase("firefox")) {//NOPMD
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath() );
			driver = new FirefoxDriver();
		}else if(br.equalsIgnoreCase("edge")) {//NOPMD
			System.setProperty("webdriver.edge.driver", readConfig.getEdgePath() );
			driver = new EdgeDriver();
		}else if(br.equalsIgnoreCase("opera")) {//NOPMD
			System.setProperty("webdriver.opera.driver", readConfig.getOperaPath() );
			driver = new OperaDriver();
		}

		logger.info("This test is on: "+br+" browser");
		//set position of current window to the secondary screen
		//driver.manage().window().setPosition(new Point(-1500, 0));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseURL);
		logger.info("URL is Opened");

	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	public static String captureScreen(WebDriver driver, String tname) throws IOException {
		String dateName = new SimpleDateFormat("yyyy-MM-dd/hh.mm.ss").format(new Date());//NOPMD
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		//after execution you will see a folder "FaiiedTestsScreenshots" under src folder
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/" + tname + "-" + dateName + ".png";
		File finalDestination = new File(screenshotPath);
		logger.info("Screenshot taken");
		FileUtils.copyFile(source, finalDestination);
		return screenshotPath;
	}

	//generate random string
	public String randomString() {
		String generateString = RandomStringUtils.randomAlphabetic(8);
		return (generateString);
	}

	//generate random number
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(6);
		return (generatedString2);
	}
}
