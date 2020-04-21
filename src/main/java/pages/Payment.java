package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsLib;
import utils.Driver;

public class Payment extends Driver {
	

	@FindBy(xpath = "//a[@title= 'Pay by bank wire']")
	WebElement btnpay;

	// constructor of the class
	public Payment() {		
		PageFactory.initElements(driver, this);
	}

	public void selectpaymentType() {
		CommonFunctionsLib.clickButton(btnpay);
	}

}
