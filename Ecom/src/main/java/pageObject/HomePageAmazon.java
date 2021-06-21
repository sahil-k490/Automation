package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseUtil.Base;

public class HomePageAmazon {
	
	public WebDriver driver;
	public List<WebElement> list;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement searchbar;
	
	@FindBy(xpath="//td[contains(text(),'Price')]/following-sibling::td/span[contains(@id,'priceblock')]")
	WebElement price;
	
	@FindBy(xpath="//span[contains(text(),'Subtotal')][@id='sc-subtotal-label-activecart']/following-sibling::span/span")
	WebElement priceincart;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement addtocart;
	
	@FindBy(xpath="//span[contains(text(),'Cart')][@id='attach-sidesheet-view-cart-button-announce']/parent::*")
	WebElement carticon;
	
	@FindBy(xpath="//a[text()='Next']")
	WebElement nextbutton;
	
	public HomePageAmazon(WebDriver driver) {
	
		this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
	}
	
	public WebElement getSearcBar() {
		return searchbar;
	}
	
	public WebElement getPrice() {
		return price;
	}
	
	public WebElement getPriceCart() {
		return priceincart;
	}
	
	public WebElement getAddToCart() {
		return addtocart;
	}
	
	public WebElement getCartIcon() {
		return carticon;
	}
	
	public void selectSameItemFlipkart(String flipkartitem) {
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='sg-col-inner']/div/h2/a/span"));
		
		for(int i=0;i<list.size();i++) 
		{
			if(list.get(i).getText().startsWith("Samsung Galaxy A12")) {
				list.get(i).click();
				break;
			}
		}
	}
	
	public double priceofItem() {	
		Base.waitForXpath(driver, price);
		String pr = price.getText().replace("₹","").replace(",","").replace("00", "").replace(".", "").trim().toString();
    	double p=Integer.parseInt(pr);
    	return p;
	}
	
	public double priceofItemInCart() {	
		Base.waitForXpath(driver, priceincart);
		String pr = priceincart.getText().replace(",","").replace("00", "").replace(".", "").trim().toString();
    	double p=Integer.parseInt(pr);
    	return p;
	}
}