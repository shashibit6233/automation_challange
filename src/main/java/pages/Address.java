package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsLib;
import utils.Driver;

public class Address extends Driver {

	@FindBy(name = "processAddress")
	WebElement btnchkout;

	// constructor of the class
	public Address() {
		PageFactory.initElements(driver, this);
	}

	public void proceedToAddressCheckOut() {
		CommonFunctionsLib.clickButton(btnchkout);

	}

}
