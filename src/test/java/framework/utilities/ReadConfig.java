/**
 * 
 */
package framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);//NOPMD
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		
		}
	}

	public String getApplicationURL() {

		return pro.getProperty("baseURL");
//		return url;
	}

	public String getEmailAddress() {

		return pro.getProperty("emailAddress");
//		return emailAddress;
	}

	public String getPassword() {

		return pro.getProperty("password");
//		return password;
	}

	public String getChromePath() {

		return pro.getProperty("chromePath");
//		return chromePath;
	}

	public String getEdgePath() {

		return pro.getProperty("edgePath");
//		return edgePath;
	}

	public String getFirefoxPath() {

		return pro.getProperty("firefoxPath");
//		return firefoxPath;
	}
	
	public String getOperaPath() {

		return pro.getProperty("operaPath");
//		return operaPath;
	}

}
