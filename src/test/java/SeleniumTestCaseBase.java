import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class SeleniumTestCaseBase {
    private final static String NAME_SYSTEM_PROPERTY	= "webdriver.chrome.driver";
    private final static String VALUE_SYSTEM_PROPERTY	= "../selenium-tests/src/test/java/chromedriver.exe";
    public final static String NOP_COMMERCE_URL       	= "http://demo.nopcommerce.com/";
    
    public WebDriver driver;

    @BeforeEach
    public void startBrowser() {
    	System.setProperty(NAME_SYSTEM_PROPERTY, VALUE_SYSTEM_PROPERTY);
        this.driver = new ChromeDriver();
    }
    
    @Test
    public abstract void TestCase();
    
    @AfterEach
    public void shutDownDriver() {
        this.driver.quit();
    }
}
