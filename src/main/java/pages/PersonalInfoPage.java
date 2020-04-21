package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsLib;
import utils.Driver;

public class PersonalInfoPage extends Driver {

	@FindBy(id = "firstname")
	WebElement txtfirstname;

	@FindBy(id = "old_passwd")
	WebElement curpass;

	@FindBy(name = "submitIdentity")
	WebElement btnsave;

	@FindBy(xpath = "//a[@title= 'View my customer account']")
	static WebElement username;

	// constructor of the class
	public PersonalInfoPage() {
		PageFactory.initElements(driver, this);
	}

	// Update personal information in my account
	public String editFirstName(String fname) {
		CommonFunctionsLib.enterTextInTextBox(txtfirstname, fname);
		return txtfirstname.getAttribute("value");

	}

	public void enterCurrentPassword(String password) {
		CommonFunctionsLib.enterTextInTextBox(curpass, password);

	}

	public void clickSaveButton() {
		CommonFunctionsLib.clickButton(btnsave);
	}

	// get user first name
	public String verifyName() {
		String[] arrname = username.getText().split(" ");
		return arrname[0];
	}

}
