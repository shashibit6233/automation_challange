package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Driver;
import org.openqa.selenium.interactions.Actions;


public class ShowTshirt extends Driver {
	WebDriver driver;
	@FindBy(xpath = "//a[@title='Add to cart']")
	 WebElement imgadd;

	@FindBy(xpath = "//a[@title= 'Faded Short Sleeve T-shirts']")
	 WebElement imgtshirt;

	@FindBy(xpath = "//div[@class= 'product-image-container']//div[@class='content_price']/span")
	 WebElement priceimg;

	// constructor of the class
	public  ShowTshirt(WebDriver driver ) {
		this.driver=driver;		
		PageFactory.initElements(driver, this);
		
		
	}
	
	

	public void hoverMouse() {
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].scrollIntoView();", imgtshirt);		
		System.out.println("---------------------printing mouse hover333333333--------------------");
		Actions action = new Actions(driver);
		System.out.println("---------------------printing mouse hover--------------------");
		action.moveToElement(imgtshirt).moveToElement(imgadd).click().build().perform();
		
	}


}
