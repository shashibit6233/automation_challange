package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsLib;
import utils.Driver;

public class OrderConfirmationPage extends Driver {

	@FindBy(xpath = "//*[@id='center_column']/div")
	WebElement txtorderinfo;

	@FindBy(xpath = "//a[@title= 'My orders']")
	WebElement lnkmyorder;

	// constructor of the class
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	public String myOrderInfo() {
		String orderdet = txtorderinfo.getAttribute("textContent");
		return orderdet;

	}

	public void myOrderDetails() {
		CommonFunctionsLib.clickButton(lnkmyorder);

	}

}
