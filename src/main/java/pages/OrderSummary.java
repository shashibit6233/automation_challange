package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsLib;
import utils.Driver;

public class OrderSummary extends Driver {

	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement btnconford;

	// constructor of the class
	public OrderSummary() {
		PageFactory.initElements(driver, this);
	}

	public void orderSummary() {
		CommonFunctionsLib.clickButton(btnconford);

	}

}
