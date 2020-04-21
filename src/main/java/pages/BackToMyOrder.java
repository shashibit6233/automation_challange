package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BackToMyOrder extends Driver {

	@FindBy(xpath = "//table[@id= 'order-list']/tbody/tr")
	List<WebElement> tblRows;

	// constructor of the class
	public BackToMyOrder() {
		PageFactory.initElements(driver, this);
	}

	// Verifying order history table
	public Boolean verifyMyOrder(String orderdet) {
		boolean flag = false;
		String order_ref = null;
		for (int i = 1; i <= tblRows.size(); i++) {
			order_ref = driver.findElement(By.xpath("//table[@id='order-list']/tbody/tr[" + i + "]/td[1]")).getText();
			if (orderdet.contains(order_ref)) {
				flag = true;
				break;
			}
		}

		return flag;

	}

}
