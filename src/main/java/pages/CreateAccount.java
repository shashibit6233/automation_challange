package pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctionsLib;
import utils.Driver;

public class CreateAccount extends Driver {
	private Logger logger;
	
	@FindBy(id="id_gender1")
	WebElement radiomr;
	
	@FindBy(id="customer_firstname")
	WebElement txtfName;
	
	@FindBy(id="customer_lastname")
	WebElement txtlName;
	
	@FindBy(id="passwd")
	WebElement txtpass;
	
	@FindBy(id="days")
	WebElement dddays;
	
	@FindBy(id="months")
	WebElement ddmm;
	
	@FindBy(id="years")
	WebElement ddyy;
	
	@FindBy(id="firstname")
	WebElement txtaddfName;
	
	@FindBy(id="lastname")
	WebElement txtaddLName;
	
	@FindBy(id="company")
	WebElement txtcompany;
	
	@FindBy(id="address1")
	WebElement txtaddress;
	
	@FindBy(id="city")
	WebElement txtcity;
	
	@FindBy(id="id_state")
	WebElement ddstate;
	
	@FindBy(id="postcode")
	WebElement txtpincode;
	
	@FindBy(id="id_country")
	WebElement ddctry;
	
	@FindBy(id="phone_mobile")
	WebElement txtmobile;
	
	@FindBy(id="alias")
	WebElement txtalias;
	
	@FindBy(id="submitAccount")
	WebElement btnRegister;
	
	
	// constructor of the class
	public CreateAccount() {
		logger= Logger.getLogger(this.getClass());
		PageFactory.initElements(driver, this);
	}
	
	//enter Details to create account
		public void enterTitleDetails() throws IOException {
			CommonFunctionsLib.selectRadio(radiomr);
			CommonFunctionsLib.enterTextInTextBox(txtfName, CommonFunctionsLib.readDataExcel("First Name"));
			CommonFunctionsLib.enterTextInTextBox(txtlName, CommonFunctionsLib.readDataExcel("Last Name"));
			CommonFunctionsLib.enterTextInTextBox(txtpass, CommonFunctionsLib.readDataExcel("Password"));
			CommonFunctionsLib.selectDDByValue(dddays, CommonFunctionsLib.readDataExcel("Date"));
			CommonFunctionsLib.selectDDByValue(ddmm, CommonFunctionsLib.readDataExcel("Month"));
			CommonFunctionsLib.selectDDByValue(ddyy, CommonFunctionsLib.readDataExcel("Year"));


		}

		//enter address details
		public void enterAddressDetails() throws IOException {
			CommonFunctionsLib.enterTextInTextBox(txtaddfName, CommonFunctionsLib.readDataExcel("Address First Name"));
			CommonFunctionsLib.enterTextInTextBox(txtaddLName, CommonFunctionsLib.readDataExcel("Address Last Name"));
			CommonFunctionsLib.enterTextInTextBox(txtcompany, CommonFunctionsLib.readDataExcel("Company"));
			CommonFunctionsLib.enterTextInTextBox(txtaddress, CommonFunctionsLib.readDataExcel("Address"));
			CommonFunctionsLib.enterTextInTextBox(txtcity, CommonFunctionsLib.readDataExcel("City"));
			CommonFunctionsLib.selectDDByText(ddstate, CommonFunctionsLib.readDataExcel("State"));
			CommonFunctionsLib.enterTextInTextBox(txtpincode, CommonFunctionsLib.readDataExcel("Zip"));
			CommonFunctionsLib.selectDDByText(ddctry, CommonFunctionsLib.readDataExcel("Country"));
			CommonFunctionsLib.enterTextInTextBox(txtmobile, CommonFunctionsLib.readDataExcel("Phone"));
			CommonFunctionsLib.enterTextInTextBox(txtalias, CommonFunctionsLib.readDataExcel("Alias"));
		}

		// click register button
		public void clickRegister() {
			CommonFunctionsLib.clickButton(btnRegister);
	
	
		}
	
	
}