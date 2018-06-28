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


public class SeleniumTestCase2NopCommerce {

    private static final Logger LOG = Logger.getLogger(SeleniumTestCase2NopCommerce.class.getName());

    private final static int CATEGORY_NAV_WAIT_TIME    = 3;
    private final static String NOP_COMMERCE_URL       = "http://demo.nopcommerce.com/";
    private final static String TOGGLE_BUTTON_CLASS    = "menu-toggle";
    private final static String LOGO_SELECTOR          = ".header-logo a";
    private final static String[] CATEGORIES_LINK_TEXT = {
            "Computers",
            "Electronics",
            "Apparel",
            "Digital downloads",
            "Books",
            "Jewelry",
            "Gift Cards"
    };

    private WebDriver driver;

    @BeforeEach
    public void startBrowser() {
        this.driver = new ChromeDriver();
    }

    @Test
    public void TestCase() {
        driver.get(NOP_COMMERCE_URL);
        Arrays.stream(CATEGORIES_LINK_TEXT)
                .forEach(this::navegateToCategory);


        WebElement logo = wait(CATEGORY_NAV_WAIT_TIME)
                .until(ExpectedConditions
                        .elementToBeClickable(By.cssSelector(LOGO_SELECTOR)));
        logo.click();

        LOG.info("Test case 2 completed successfully");
    }

    private void navegateToCategory(final String category) {

        WebElement toggle = wait(CATEGORY_NAV_WAIT_TIME)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.className(TOGGLE_BUTTON_CLASS)));
        boolean isMovile = toggle.isDisplayed();
        if(isMovile) {
            toggle.click();
        }
        WebElement link = wait(isMovile ? 1 : 0)
                .until(ExpectedConditions
                        .elementToBeClickable(By.linkText(category)));
        link.click();
    }

    private WebDriverWait wait(final int seconds) {
       return new WebDriverWait(driver, seconds);
    }

    @AfterEach
    public void shutDownDriver() {
        this.driver.quit();
    }

}