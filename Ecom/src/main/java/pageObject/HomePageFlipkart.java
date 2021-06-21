package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseUtil.Base;

public class HomePageFlipkart {
	
	public WebDriver driver;
	public List<WebElement> list;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement searchbar;
	
	@FindBy(xpath="//div[contains(@class,'CEmiEU')]//div[contains(text(),'₹')]")
	WebElement price;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	WebElement addtocart;
	
	@FindBy(xpath="//span[text()='Cart']")
	WebElement carticon;
	
	@FindBy(xpath="//button[text()='+']")
	WebElement additem;
	
	@FindBy(xpath="//button[text()='✕']")
	WebElement cancelsign;
	
	@FindBy(xpath="//div[contains(text(),'Total Amount')]/parent::*/following-sibling::span/div/div/span[contains(text(),'₹')]")
	WebElement priceincart;
	
	@FindBy(xpath="//div[contains(@class,'_13oc-S')]")
	WebElement listofelement;
	
	public HomePageFlipkart(WebDriver driver) {
	
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
	
	public WebElement getAddToCart() {
		return addtocart;
	}
	
	public WebElement getCartIcon() {
		return carticon;
	}
	
	public WebElement getAddIcon() {
		return additem;
	}
	
	public WebElement getCancelSign() {
		return cancelsign;
	}
	
	public WebElement getPriceInCart() {
		return priceincart;
	}
	
	public String selectFirstItem(String itemnametoselect) throws InterruptedException {
		
		Thread.sleep(5000);
		list = driver.findElements(By.xpath("//div[contains(@class,'_13oc-S')]"));	
		WebElement elelist= list.get(0).findElement(By.xpath("//a[@target='_blank']//div[contains(text(),'SAMSUNG')]"));
		String itemname=elelist.getText();
		list.get(0).click();
		System.out.println("Item Selected: "+itemname);
		return itemname;
	}
	
	public double priceofItem() {	
		Base.waitForXpath(driver, price);
		String pr = price.getText().replace("₹","").replace(",","").toString();
		double p=Integer.parseInt(pr);
    	return p;
	}
	
	public double priceInCart() {
		Base.waitForXpath(driver, priceincart);
		String pricecart= priceincart.getText().replace("₹","").replace(",", "").trim().toString();
		double pricec= Integer.parseInt(pricecart);
		return pricec;
	}	
}