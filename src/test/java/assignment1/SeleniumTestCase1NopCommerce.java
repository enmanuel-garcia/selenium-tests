package assignment1;
import org.junit.jupiter.api.Test;
import base.SeleniumTestCaseBase;
import java.util.logging.Logger;

public class SeleniumTestCase1NopCommerce extends SeleniumTestCaseBase {

    private static final Logger LOG = Logger.getLogger(SeleniumTestCase1NopCommerce.class.getName());

    private final static int LOAD_PAGE_WAIT_TIME	= 3000;
    private final static int CLOSE_PAGE_WAIT_TIME	= 5000;
    private final static String PAGE_TITLE 		 	= "nopCommerce demo store";

    @Test
    public void TestCase() {
        driver.get(NOP_COMMERCE_URL);

        wait(LOAD_PAGE_WAIT_TIME);     
        checkTitle();
        wait(CLOSE_PAGE_WAIT_TIME);
        
        LOG.info("Test case 1 completed successfully");
    }

    private void wait(final int milliseconds) {
       try {
    	   Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    private void checkTitle() {    	
    	if (driver.getTitle().equals(PAGE_TITLE))
    		LOG.info("El título si es '" + PAGE_TITLE + "'");
    	else
    		LOG.warning("El título no es '" + PAGE_TITLE + "'");
    }
}