package pages;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Driver;
import org.openqa.selenium.interactions.Actions;

public class ShowTshirt extends Driver {
	private Logger logger = Logger.getLogger(this.getClass());
	
	WebDriver driver;
	@FindBy(xpath = "//a[@title='Add to cart']")
	WebElement imgadd;

	@FindBy(xpath = "//a[@title= 'Faded Short Sleeve T-shirts']")
	WebElement imgtshirt;

	@FindBy(xpath = "//div[@class= 'product-image-container']//div[@class='content_price']/span")
	WebElement priceimg;

	// constructor of the class
	public ShowTshirt(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void hoverMouse() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", imgtshirt);
		Actions action = new Actions(driver);
		action.moveToElement(imgtshirt).moveToElement(imgadd).build().perform();
		String tshirtPrice = priceimg.getText();
		Assert.assertNotNull(tshirtPrice, "pricing value is not displayed");
		driver.getWindowHandle();		
		action.moveToElement(imgtshirt).moveToElement(imgadd).click().build().perform();
		logger.info("Add to cart button with cost value: "+ tshirtPrice + " is getting displayed");
		Set<String> childwindow = driver.getWindowHandles();
		int childwindowsize= childwindow.size();
		Assert.assertNotNull(childwindowsize, "popup window is not displayed");
		logger.info("popup window with Proceed to Checkout is getting displayed");
		

	}

}
