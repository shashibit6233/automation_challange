package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsLib;
import utils.Driver;

public class Shipping extends Driver {

	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement btnchkout;

	@FindBy(id = "uniform-cgv")
	WebElement chkterms;

	// constructor of the class
	public Shipping() {
		PageFactory.initElements(driver, this);
	}

	public void proceedToShippingCheckOut() {
		CommonFunctionsLib.selectCheckBox(chkterms);
		CommonFunctionsLib.clickButton(btnchkout);

	}

}
