package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsLib;
import utils.Driver;

public class Tshirts extends Driver {

	@FindBy(xpath = "//div[@id='block_top_menu']/ul/li[3]")
	WebElement tshirts;

	@FindBy(xpath = "//a[@title= 'View my customer account']")
	WebElement username;

	@FindBy(xpath = "//a[@title='Information']")
	WebElement pinfo;

	// constructor of the class
	public Tshirts() {
		PageFactory.initElements(driver, this);
	}

	public String getCustomerName() {
		String custname = username.getText();
		return custname;
	}

	public void clickTshirts() {
		CommonFunctionsLib.clickButton(tshirts);

	}

	public void clickPersonalInformation() {
		CommonFunctionsLib.clickButton(pinfo);
	}

}
