package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
					System.getProperty("user.dir") + "/target/" + screenshotName + ".png");
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
	//read value from excel
	public static String readDataExcel(String key) throws IOException{
		Map<String, String> m = readExcel().get("DataSheet");
		String value = m.get(key);
		return value;
		}
	
	//reading data from excel
	public  static Map<String,  Map<String, String>> readExcel() throws IOException {

		  String path = readDefaultProperties("excelpath");

		  FileInputStream fis = new FileInputStream(path);

		  Workbook workbook = new XSSFWorkbook(fis);

		  Sheet sheet = workbook.getSheetAt(0);

		  int lastRow = sheet.getLastRowNum();

		  Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String,String>>();

		  Map<String, String> dataMap = new HashMap<String, String>();

		  //Looping over entire row
		  for(int i=0; i<=lastRow; i++){

			  Row row = sheet.getRow(i);

			  //1st Cell as Value
			  Cell valueCell = row.getCell(1);

			  //0th Cell as Key
			  Cell keyCell = row.getCell(0);

			  String value = valueCell.getStringCellValue().trim();
			  String key = keyCell.getStringCellValue().trim();

			  //Putting key & value in dataMap
			  dataMap.put(key, value);

			  //Putting dataMap to excelFileMap
			  excelFileMap.put("DataSheet", dataMap);
		  }

		 //Returning excelFileMap
		return excelFileMap;

	}
	
	public static String getAlphaNumericString(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz"
                                    + "0123456789";                                     
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 


}
