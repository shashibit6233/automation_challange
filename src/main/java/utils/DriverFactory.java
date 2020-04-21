package utils;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.CommonFunctionsLib;

public class DriverFactory {

	public static WebDriver driver = null;
	private static Logger logger = Logger.getLogger(DriverFactory.class);

	public static WebDriver getDriver() throws IOException {

		String browsername = CommonFunctionsLib.readDefaultProperties("browser");
		String chromepath = "drivers\\chromedriver.exe";
		String ffpath = "drivers\\geckodriver.exe";

		logger.info(Class.class.getClass() + "--------------Initialise Driver----------------");

		switch (browsername) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", chromepath);
			return new ChromeDriver();
		case "FF":
			System.setProperty("webdriver.gecko.driver", ffpath);
			return new FirefoxDriver();

		default:
			return new InternetExplorerDriver();
		}
	}

	public static void closeDriver(WebDriver driver) {

		try {
			driver.quit();
			logger.info("---------------Driver Closed--------------");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

}
