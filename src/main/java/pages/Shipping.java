package pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctionsLib;
import utils.Driver;

public class Shipping extends Driver {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement btnchkout;
	@FindBy(xpath = "//a[@title= 'Close']")
	WebElement closealert;
	@FindBy(xpath = "//p[@class= 'fancybox-error']")
	WebElement alert;
	@FindBy(id = "uniform-cgv")
	WebElement chkterms;

	// constructor of the class
	public Shipping() {
		PageFactory.initElements(driver, this);
	}

	public void proceedToShippingCheckOut() throws InterruptedException {
		CommonFunctionsLib.clickButton(btnchkout);
		String actualalert = alert.getText();
		String expectedalert = "You must agree to the terms of service before continuing.";
		Assert.assertEquals(actualalert, expectedalert,"You must agree to the terms of service before continuing. is not getting displayed");
		logger.info("You must agree to the terms of service before continuing. is getting displayed");
		CommonFunctionsLib.clickButton(closealert);
		Thread.sleep(1000);
		CommonFunctionsLib.selectCheckBox(chkterms);
		CommonFunctionsLib.clickButton(btnchkout);
	}

}
