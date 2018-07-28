package assignment2;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import base.SeleniumTestCaseBase;

public class SeleniumTestCase2NopCommerce extends SeleniumTestCaseBase  {
	private static final Logger LOG 				= Logger.getLogger(SeleniumTestCase2NopCommerce.class.getName());
    private final static String WISHLIST_URL		= "/wishlist";
    private final static String SHOPPING_CART_URL	= "/cart";
    private final static String ITEM_TO_WISHLIST	= "Fahrenheit 451";

    @Test
    public void TestCase() {
    	//Check if wish list is empty
        driver.get(NOP_COMMERCE_URL + WISHLIST_URL);        
    	if (driver.findElements( By.id("div.no-data") ).size() != 0)
        	LOG.info("Wish list is empty");
        else 
        	LOG.info("Wish list is not empty");	
        
        //Add item to wish list
        driver.findElement(By.id("small-searchterms")).sendKeys(ITEM_TO_WISHLIST);       
        driver.findElement(By.className("search-box-button")).click();
        driver.findElement(By.className("add-to-wishlist-button")).click();
             
        //Check if item was added
    	if (driver.findElements(By.className("product-name")).get(0).getText().contains(ITEM_TO_WISHLIST))
    		LOG.info("Item was added successful");
    	else
    		LOG.info("Item was not added");
    	
    	//Check if shopping cart is empty
    	driver.get(NOP_COMMERCE_URL + SHOPPING_CART_URL);
    	if (driver.findElements( By.id("div.no-data") ).size() != 0)
        	LOG.info("Wish list is empty");
        else 
        	LOG.info("Wish list is not empty");	
    	
    	//Add item to shopping cart
    	driver.get(NOP_COMMERCE_URL + WISHLIST_URL);
    	driver.findElement(By.xpath(".//td[@class='add-to-cart']/input[@type='checkbox']")).click();
    	driver.findElement(By.className("wishlist-add-to-cart-button")).click();
    }
}
