package runner;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.CommonFunctionsLib;
import utils.Driver;
import pages.Address;
import pages.BackToMyOrder;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.OrderSummary;
import pages.Payment;
import pages.ProductAdded;
import pages.SelectTshirt;
import pages.Shipping;
import pages.ShoppingCartSumPage;
import pages.ShowTshirt;
import pages.Tshirts;

public class TestRunner extends Driver {

	public static CommonFunctionsLib comfunctions;
	private static Logger logger = Logger.getLogger(TestRunner.class);;
	static Driver dr = new Driver();
	 //WebDriver driver ;
	public static String newname = null;
	public static String orderdet = null;

	@BeforeClass
	public void initializeDriver() throws IOException {
		PropertyConfigurator.configure(CommonFunctionsLib.readDefaultProperties("log4jpath"));
		
		dr.initialiseDriver();
		Driver.loadApplication(CommonFunctionsLib.readDefaultProperties("url"));
	}

	@Test

	public void createAccount() throws InterruptedException {
		HomePage hp = new HomePage();
		hp.clickSignIn();

		LoginPage login = new LoginPage();
		login.enterSignInDetails(CommonFunctionsLib.readTestDataProperties("userid"),
				CommonFunctionsLib.readTestDataProperties("password"));
		login.clickSignIn();

		Tshirts tshirt = new Tshirts();
		String custname = tshirt.getCustomerName();
		Assert.assertNotNull(custname);

		logger.info("--------------User logged in successfully--------------");

		tshirt.clickTshirts();
		
		ShowTshirt showts = new ShowTshirt(driver);
		showts.hoverMouse();	

		ProductAdded proadd = new ProductAdded();
		proadd.productAddedToShoppingKart();

		ShoppingCartSumPage shopsumpage = new ShoppingCartSumPage();
		shopsumpage.proceedToShopCheckOut();

		Address adr = new Address();
		adr.proceedToAddressCheckOut();

		Shipping ship = new Shipping();
		ship.proceedToShippingCheckOut();

		Payment pay = new Payment();
		pay.totalAmountToPay();
		pay.modeOfPayment();
		pay.selectpaymentType();
		

		OrderSummary ordSum = new OrderSummary();
		ordSum.orderSummary();

		OrderConfirmationPage ordconf = new OrderConfirmationPage();
		ordconf.myOrderInfo();
		ordconf.myOrderDetails();
		

		BackToMyOrder myord = new BackToMyOrder();
		
		Boolean flag = myord.verifyMyOrder(ordconf.myOrderInfo(),CommonFunctionsLib.generateDate(),pay.totalAmountToPay(),pay.modeOfPayment());
		Assert.assertTrue(flag);
		logger.info("Your order on My Store is successfully placed");

		CommonFunctionsLib.getScreenshot();

	}

	@AfterClass
	public void close() {
		dr.closeDriver();
	}

	

	

}
