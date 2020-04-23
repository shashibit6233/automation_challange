package pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctionsLib;
import utils.Driver;

public class Payment extends Driver {
	private Logger logger = Logger.getLogger(this.getClass());

	@FindBy(xpath = "//a[@title= 'Pay by bank wire']")
	WebElement btnpay;
	
	@FindBy(xpath = "//td[@id= 'total_price_container']/span")
	WebElement amt;

	// constructor of the class
	public Payment() {		
		PageFactory.initElements(driver, this);
	}
	
	public String totalAmountToPay() {
		boolean flag = amt.isDisplayed();
		Assert.assertTrue(flag);
		String amount = amt.getText().trim();
		return amount;
		
	}

	
	public String modeOfPayment() {
		boolean flag = btnpay.isDisplayed();
		Assert.assertTrue(flag);		
		logger.info("Bank-Wire payment is getting displayed on Payment page");
		String modeofpay = "Bank wire";
		return modeofpay;
		
	}

	public void selectpaymentType() {
		CommonFunctionsLib.clickButton(btnpay);
		
	}

}
