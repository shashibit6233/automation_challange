package utils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

public class CommonFunctionsLib extends Driver {
	public static String propvalue = null;
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

	public CommonFunctionsLib() {

	}

	// retrieve value from default properties file
	public static String readDefaultProperties(String key) {

		String defaultproPath = "config\\default.properties";

		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(defaultproPath);
			prop.load(fis);
			propvalue = prop.getProperty(key);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return propvalue;
	}

	// retrieve value from data properties file
	public static String readTestDataProperties(String key) {

		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(readDefaultProperties("testDataPath"));
			prop.load(fis);
			propvalue = prop.getProperty(key);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return propvalue;
	}

	// enter text in text box
	public static void enterTextInTextBox(WebElement element, String txt) {
		new WebDriverWait(driver, TestUtil.PAGE_LOAD_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
		if (element.isEnabled()) {
			element.clear();
			element.sendKeys(txt);
		}
	}

	// select checkbox
	public static void selectCheckBox(WebElement element) {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		if (!element.isSelected()) {
			element.click();
		}
	}

	// click button
	public static void clickButton(WebElement element) {
		new WebDriverWait(driver, TestUtil.PAGE_LOAD_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	// select radio button
	public static void selectRadio(WebElement element) {
		new WebDriverWait(driver, TestUtil.PAGE_LOAD_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
		if (!element.isSelected()) {
			element.click();
		}
	}

	// select dropdown by value
	public static void selectDDByValue(WebElement element, String val) {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Select select = new Select(element);
		select.selectByValue(val);
	}

	// select drop down by text
	public static void selectDDByText(WebElement element, String txt) {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Select select = new Select(element);
		select.selectByVisibleText(txt);
	}

	// java script executer to scroll down and click
	public static void scrollDownAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	// To generate timestamp
	public static String generateTimestamp() {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String gentimestamp = sdf.format(timestamp);
		return gentimestamp;
	}

	public static void getScreenshot() {

		String screenshotName = "Order_Screenshot" + CommonFunctionsLib.generateTimestamp();
		try {
			File sourcePath = ((TakesScreenshot) Driver.driver).getScreenshotAs(OutputType.FILE);
			File destinationPath = new File(
					System.getProperty("user.dir") + "/target/testng-screenshots/" + screenshotName + ".png");
			Files.copy(sourcePath, destinationPath);
			//Reporter.addScreenCaptureFromPath(destinationPath.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//generate todays date
	public static String generateDate() { 		 
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");		
		 Date date = new Date();		
		 String date1= dateFormat.format(date);		 
		 return date1;
		 
		 }

}
