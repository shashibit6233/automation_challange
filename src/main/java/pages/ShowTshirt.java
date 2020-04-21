package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctionsLib;
import utils.Driver;
import org.openqa.selenium.interactions.Actions;

public class ShowTshirt extends Driver {
	WebDriver driver;
	@FindBy(xpath = "//a[@title='Add to cart']")
	static WebElement imgadd;

	@FindBy(xpath = "//a[@title= 'Faded Short Sleeve T-shirts']")
	static WebElement imgtshirt;

	@FindBy(xpath = "//div[@class= 'product-image-container']//div[@class='content_price']/span")
	static WebElement priceimg;

	// constructor of the class
	public  ShowTshirt(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
		
	}

	public void hoverMouse() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", imgtshirt);
		Actions action = new Actions(driver);
		System.out.println("---------------------printing mouse hover--------------------");
		//action.moveToElement(imgtshirt).click().build().perform();
		//action.moveToElement(imgtshirt).moveToElement(imgadd).build().perform();
		/*String val = priceimg.getText();
		Assert.assertNotNull(val, "price is displayed");*/
	}

	/*public void clickFadedTshirt() {
		CommonFunctionsLib.scrollDownAndClick(imgtshirt);

	}*/

}
