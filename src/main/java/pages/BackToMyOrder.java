package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bsh.org.objectweb.asm.Label;
import utils.CommonFunctionsLib;
import utils.Driver;

public class BackToMyOrder extends Driver {

	@FindBy(xpath = "//table[@id= 'order-list']/tbody/tr")
	List<WebElement> tblRows;

	// constructor of the class
	public BackToMyOrder() {
		PageFactory.initElements(driver, this);
	}

	// Verifying order history table
	public Boolean verifyMyOrder(String orderdet, String expecteddate, String expectedprice, String expectedmode) {

		System.out.println("----------------working------------");
		boolean flag = false;
		String order_ref = null;

		for (int i = 1; i <= tblRows.size(); i++) {
			order_ref = driver.findElement(By.xpath("//table[@id='order-list']/tbody/tr[" + i + "]/td[1]")).getText();
			System.out.println("phase11111111");

			if (orderdet.contains(order_ref))
				a2: {
					String orddate = driver.findElement(By.xpath("//table[@id='order-list']/tbody/tr[" + i + "]/td[2]"))
							.getText();

					String totalprice = driver
							.findElement(By.xpath("//table[@id='order-list']/tbody/tr[" + i + "]/td[3]")).getText();

					String modeofpay = driver
							.findElement(By.xpath("//table[@id='order-list']/tbody/tr[" + i + "]/td[4]")).getText();

					if (orddate.equalsIgnoreCase(expecteddate) && totalprice.equalsIgnoreCase(expectedprice)
							&& modeofpay.equalsIgnoreCase(expectedmode)) {

						flag = true;
						break a2;
					}

				}

		}

		return flag;

	}

}
