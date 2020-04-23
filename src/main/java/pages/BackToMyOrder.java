package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BackToMyOrder extends Driver {
	private Logger logger = Logger.getLogger(this.getClass());
	@FindBy(xpath = "//table[@id= 'order-list']/tbody/tr")
	List<WebElement> tblRows;

	// constructor of the class
	public BackToMyOrder() {
		PageFactory.initElements(driver, this);
	}

	// Verifying order history table
	public Boolean verifyMyOrder(String orderdet, String expecteddate, String expectedprice, String expectedmode) {

		boolean flag = false;
		String order_ref = null;
		l1: for (int i = 1; i <= tblRows.size(); i++) {
			order_ref = driver.findElement(By.xpath("//table[@id='order-list']/tbody/tr[" + i + "]/td[1]")).getText();

			if (orderdet.contains(order_ref)) {
				logger.info("Order is placed with order number: "+order_ref);
				String orddate = driver.findElement(By.xpath("//table[@id='order-list']/tbody/tr[" + i + "]/td[2]"))
						.getText();
				String totalprice = driver.findElement(By.xpath("//table[@id='order-list']/tbody/tr[" + i + "]/td[3]"))
						.getText();

				String modeofpay = driver.findElement(By.xpath("//table[@id='order-list']/tbody/tr[" + i + "]/td[4]"))
						.getText();

				if (orddate.trim().equalsIgnoreCase(expecteddate.trim())
						&& totalprice.trim().equalsIgnoreCase(expectedprice.trim())
						&& modeofpay.trim().equalsIgnoreCase(expectedmode.trim())) {
					logger.info("Order Date is same as expected date: "+orddate);
					logger.info("Order Price is same as expected Price: "+totalprice);
					logger.info("Mode of payment is same as expected mode of payment: "+modeofpay);
					
					flag = true;
					break l1;
				}

			}

		}

		return flag;

	}

}
