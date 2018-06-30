import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.logging.Logger;


public class SeleniumTestCase1NopCommerce extends SeleniumTestCaseBase {

    private static final Logger LOG = Logger.getLogger(SeleniumTestCase1NopCommerce.class.getName());

    private final static int LOAD_PAGE_WAIT_TIME	= 3000;
    private final static int CLOSE_PAGE_WAIT_TIME	= 5000;
    private final static String PAGE_TITLE 		 	= "nopCommerce demo store";

    @Override
    @Test
    public void TestCase() {
        getDriver().get(NOP_COMMERCE_URL);

        waitExact(LOAD_PAGE_WAIT_TIME);
        checkTitle();
        waitExact(CLOSE_PAGE_WAIT_TIME);
        
        LOG.info("Test case 1 completed successfully");
    }


    
    private void checkTitle() {    	
    	if (getDriver().getTitle().equals(PAGE_TITLE))
    		LOG.info("El t�tulo si es '" + PAGE_TITLE + "'");
    	else
    		LOG.warning("El t�tulo no es '" + PAGE_TITLE + "'");
    }
}