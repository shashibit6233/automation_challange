package utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Driver {

	public static CommonFunctionsLib comfunctions;
	public static WebDriver driver;
	private Logger logger = Logger.getLogger(this.getClass());

	public void initialiseDriver() throws IOException {
		if (driver == null) {
			logger.info(Driver.class.getName() + "--------------Initialise Driver--------------");
			driver = DriverFactory.getDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} else {
			logger.info("----------------Driver already initialised------------------");
		}

	}

	public static void loadApplication(String url) throws IOException {
		driver.get(url);
	}

	public WebDriver closeDriver() {
		logger.info(Driver.class.getName() + "------------Close Driver--------------");
		DriverFactory.closeDriver(driver);
		return driver = null;
	}

}
