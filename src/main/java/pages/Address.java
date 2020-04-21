package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctionsLib;
import utils.Driver;

public class Address extends Driver {

	@FindBy(xpath = "//ul[@id= 'address_delivery']/li")
	List<WebElement> deliveryadr;

	@FindBy(xpath = "//ul[@id= 'address_invoice']/li")
	List<WebElement> billingadr;

	@FindBy(name = "processAddress")
	WebElement btnchkout;

	// constructor of the class
	public Address() {
		PageFactory.initElements(driver, this);
	}

	public void proceedToAddressCheckOut() {
		
		String deliveryAddress = null;
		String billingAddress = null;

		for (int i = 2; i <= deliveryadr.size(); i++) {
			deliveryAddress = driver.findElement(By.xpath("//ul[@id= 'address_delivery']/li[" + i + "]")).getText();

		}

		for (int i = 2; i <= billingadr.size(); i++) {
			billingAddress = driver.findElement(By.xpath("//ul[@id= 'address_invoice']/li[" + i + "]")).getText();

		}

		Assert.assertEquals(deliveryAddress, billingAddress);

		CommonFunctionsLib.clickButton(btnchkout);

	}

}
