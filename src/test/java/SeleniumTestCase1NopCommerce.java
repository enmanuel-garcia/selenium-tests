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

    private final static int LOAD_PAGE_WAIT_TIME = 3000;

    @Test
    public void TestCase() {
        getDriver().get(NOP_COMMERCE_URL);
        waitExact(LOAD_PAGE_WAIT_TIME);
        LOG.info("Test case 1 completed successfully");
    }
}