package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsLib;
import utils.Driver;

public class ShoppingCartSumPage extends Driver {

	@FindBy(xpath = "//p[@class='cart_navigation clearfix']/a[1]")
	WebElement btnchkout;

	// constructor of the class
	public ShoppingCartSumPage() {
		PageFactory.initElements(driver, this);
	}

	public void proceedToShopCheckOut() {
		CommonFunctionsLib.clickButton(btnchkout);

	}

}
