package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctionsLib;
import utils.Driver;

public class HomePage extends Driver {

	@FindBy(xpath = "//a[@title= 'Log in to your customer account']")
	WebElement btnsignin;

	// constructor of the class
	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public void clickSignIn() {
		CommonFunctionsLib.clickButton(btnsignin);

	}

}
