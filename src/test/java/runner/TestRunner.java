package runner;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.CommonFunctionsLib;
import utils.Driver;
import pages.Address;
import pages.BackToMyOrder;
import pages.CreateAccount;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.OrderSummary;
import pages.Payment;
import pages.ProductAdded;
import pages.Shipping;
import pages.ShoppingCartSumPage;
import pages.ShowTshirt;
import pages.Tshirts;

public class TestRunner extends Driver {

	public static CommonFunctionsLib comfunctions;
	private static Logger logger = Logger.getLogger(TestRunner.class);;
	static Driver dr = new Driver();
	public static String newname = null;
	public static String orderdet = null;
	
	
	@BeforeClass
	public void initializeDriver() throws IOException {
		PropertyConfigurator.configure(CommonFunctionsLib.readDefaultProperties("log4jpath"));
		
		dr.initialiseDriver();
		Driver.loadApplication(CommonFunctionsLib.readDefaultProperties("url"));
	}
	
	@Test(priority=0)
	public void registerUser() throws IOException {
		CreateAccount create_acct= new CreateAccount();
		HomePage hp = new HomePage();
		hp.clickSignIn();
		LoginPage login = new LoginPage();
		String email=CommonFunctionsLib.getAlphaNumericString(8);
		login.enterCreateAccountEmail(email+"@gmail.com");
		login.clickCreateAccount();
		create_acct.enterTitleDetails();
		create_acct.enterAddressDetails();
		create_acct.clickRegister();
		Assert.assertEquals("User is not navigated to My Account Page","My account - My Store",driver.getTitle());
		logger.info("User is navigated to My Account Page");
	}

	@Test(priority=1)

	public void placeOrder() throws InterruptedException {
		Tshirts tshirt = new Tshirts();
		ShowTshirt showts = new ShowTshirt(driver);
		ProductAdded proadd = new ProductAdded();
		ShoppingCartSumPage shopsumpage = new ShoppingCartSumPage();
		Address adr = new Address();
		Shipping ship = new Shipping();
		Payment pay = new Payment();
		OrderSummary ordSum = new OrderSummary();
		OrderConfirmationPage ordconf = new OrderConfirmationPage();
		BackToMyOrder myord = new BackToMyOrder();
		LoginPage login = new LoginPage();
		login.clickSignIn();		
		String custname = tshirt.getCustomerName();
		Assert.assertNotNull(custname);
		logger.info("--------------User logged in successfully--------------");

		tshirt.clickTshirts();

		showts.hoverMouse();	
		proadd.productAddedToShoppingKart();
		shopsumpage.proceedToShopCheckOut();
		adr.proceedToAddressCheckOut();
		ship.proceedToShippingCheckOut();
		String expectedprice =pay.totalAmountToPay();		
		String expectedmode =pay.modeOfPayment();			
		pay.selectpaymentType();
		ordSum.orderSummary();
		ordconf.myOrderInfo();
		ordconf.myOrderDetails();		
		Boolean flag = myord.verifyMyOrder(ordconf.myOrderInfo(),CommonFunctionsLib.generateDate(),expectedprice,expectedmode);
		Assert.assertTrue(flag);
		logger.info("Your order on My Store is successfully placed");
		CommonFunctionsLib.getScreenshot();

	}

	@AfterClass
	public void close() {
		dr.closeDriver();
	}

	

	

}