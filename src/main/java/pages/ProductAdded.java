package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsLib;
import utils.Driver;

public class ProductAdded extends Driver {

	@FindBy(xpath = "//a[@title= 'Proceed to checkout']")
	WebElement btnchkout;

	// constructor of the class
	public ProductAdded() {
		PageFactory.initElements(driver, this);
	}

	public void productAddedToShoppingKart() {			
		CommonFunctionsLib.clickButton(btnchkout);

	}

}
