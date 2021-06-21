package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.HomePageAmazon;
import pageObject.HomePageFlipkart;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import baseUtil.Base;
import baseUtil.ConfigReader;
import driverFactory.DriverFactory;

public class HomePageSteps {

	WebDriver driver=DriverFactory.getDriver();
	HomePageFlipkart homepageflipkart = new HomePageFlipkart(driver); 
	HomePageAmazon homepageamazon = new HomePageAmazon(driver);
	ConfigReader configreader = new ConfigReader();
	
	public String website;
	private double priceonflipkart;
	private double priceonamazon;
	private double cheapestprice=0;
	public String flipkartitem="";
	public String itemnametoselect="";
	
    @Given("^user is on Home page \"([^\"]*)\"$")
    public void user_is_on_home_page(String site) throws Throwable {
        
    	website = site;
    	if(website.equals("Flipkart")) 
    	{
    		driver.get(configreader.init_prop().getProperty("Flipkart"));
    	}
    	else if(website.equals("Amazon")) 
    	{    		
    		driver.get(configreader.init_prop().getProperty("Amazon"));
    	}
    }

    @When("^user enters items in search box \"([^\"]*)\"$")
    public void user_enters_items_in_search_box(String itemname) throws Throwable {
    	
    	itemnametoselect=itemname;
    	if(website.equals("Flipkart")) 
    	{
    		Base.waitForXpath(driver,homepageflipkart.getCancelSign());
    		homepageflipkart.getCancelSign().click();
    		Base.waitForElementClickable(driver, homepageflipkart.getSearcBar());
        	homepageflipkart.getSearcBar().sendKeys(itemname);
        	homepageflipkart.getSearcBar().sendKeys(Keys.RETURN);
    	}
    	else if(website.equals("Amazon")) 
    	{    		
    		Base.waitForElementClickable(driver, homepageamazon.getSearcBar());
    		homepageamazon.getSearcBar().sendKeys(itemname);
    		homepageamazon.getSearcBar().sendKeys(Keys.RETURN);
    	}
    }

    @And("^user selects the first item from list$")
    public void user_selects_the_first_item_from_list() throws Throwable {
    		
    	if(website.equals("Flipkart")) 
    	{
    		flipkartitem=homepageflipkart.selectFirstItem(itemnametoselect);
    	}
    	else if(website.equals("Amazon")) 
    	{    		
    		homepageamazon.selectSameItemFlipkart(flipkartitem);
    	}
    }

    @And("^print the price of that item$")
    public void print_the_price_of_that_item() throws Throwable {
        	
    	if(website.equals("Flipkart")) 
    	{
    		Base.switchtab(driver);
    		Base.waitForXpath(driver, homepageflipkart.getPrice());
        	priceonflipkart=homepageflipkart.priceofItem();
        	System.out.println("Price of item: "+ priceonflipkart);    	
    	}
    	else if(website.equals("Amazon")) 
    	{   
    		Base.switchtab(driver);
    		Base.waitForXpath(driver, homepageamazon.getPrice());
    		priceonamazon=homepageamazon.priceofItem();
        	System.out.println("Price of item: "+ priceonamazon);
    	}   	
    }

    @And("^saves the item in cart in guest mode$")
    public void saves_the_item_in_cart_in_guest_mode() throws Throwable {
        
    	if(website.equals("Flipkart")) 
    	{
    		Base.waitForElementClickable(driver,homepageflipkart.getAddToCart());	
    	    homepageflipkart.getAddToCart().click();
    	    System.out.println("Item Added to Cart");
    	 }
    	else if(website.equals("Amazon")) 
    	{   	
    		Base.waitForElementClickable(driver,homepageamazon.getAddToCart());
    		homepageamazon.getAddToCart().click();
    	    System.out.println("Item Added to Cart");
    	}   
    }

    @And("^user go to the cart section$")
    public void user_go_to_the_cart_section() throws Throwable {
        	
    	if(website.equals("Flipkart")) 
    	{
    		Base.waitForElementClickable(driver,homepageflipkart.getCartIcon());
    		homepageflipkart.getCartIcon().click();
    	}
    	else if(website.equals("Amazon")) 
    	{  
    		Base.waitForElementClickable(driver,homepageamazon.getCartIcon());
    		homepageamazon.getCartIcon().click();
        } 
    }

    @And("^print the price of that item in cart$")
    public void print_the_price_of_that_item_in_cart() throws Throwable {
        	
    	if(website.equals("Flipkart")) 
    	{
        	priceonflipkart=homepageflipkart.priceInCart();
        	System.out.println("Price of item in cart: "+ priceonflipkart);    	
    	}
    	else if(website.equals("Amazon")) 
    	{   
    		priceonamazon=homepageamazon.priceofItemInCart();
        	System.out.println("Price of item in cart: "+ priceonamazon);
    	}   	
    }
    
    @And("^increase the quantity by 1$")
    public void increase_the_quantity_by_1() throws Throwable {
    	
    	 if(website.equals("Flipkart")) 
    	 {
    		 Base.waitForElementClickable(driver,homepageflipkart.getAddIcon());
    		 homepageflipkart.getAddIcon().click();	
    		 System.out.println("One more item added");
     	 }
     	else if(website.equals("Amazon")) {    		 
     		
     	} 
    }
    
    @Then("^prints the price of that item$")
    public void prints_the_price_of_that_item() throws Throwable {
        
    	Thread.sleep(3000);
    	System.out.println("Price of item after adding 1 more item: "+homepageflipkart.priceInCart());
    }
    
    @And("^compare both the prices$")
    public void compare_both_the_prices() throws Throwable {
    	
    	if(priceonamazon<=priceonflipkart) 
    	{
    		cheapestprice=priceonamazon;
    	}
    	else if(priceonamazon==priceonflipkart)
    	{
    		
    	}
    	else
    	{
    		cheapestprice=priceonflipkart;
    	}
    }
    
    @Then("print the cheapest rate")
    public void print_the_cheapest_rate() 
    {
    	// Write code here that turns the phrase above into concrete actions
        System.out.println("Cheapest price of item: " + cheapestprice);
    }
  }