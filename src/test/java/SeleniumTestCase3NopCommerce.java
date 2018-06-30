
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumTestCase3NopCommerce extends SeleniumTestCaseBase {

    //  private static String byId = "\"//div[@data-productid='37']/descendant::input[contains(@title, 'wishlist')]\"";
    private static final String WISH_LIST_CLASS = "ico-wishlist";
    private static final String SEARCH_INPUT_ID = "small-searchterms";
    private static final String BOOK_SEARCH     = "Fahrenheit 451";
    private static final String WISH_LIST_BUTTON = String.format(
                    "//a[contains(text(), '%s')]" +
                    "/parent::h2" +
                    "/parent::div" +
                    "/descendant::input[contains(@title, 'wishlist')]",
            BOOK_SEARCH);

    private static final String WISH_LIST_BOOK_NAME = String.format(
                    "//td" +
                    "/a[contains(text(), '%s')]",
                    BOOK_SEARCH);


    @Override
    @Test
    public void TestCase() {
        getDriver().get(NOP_COMMERCE_URL);
        goToWishList();
        WebElement searchInput = waitToFoundElement(By.id(SEARCH_INPUT_ID));
        searchInput.sendKeys(BOOK_SEARCH);
        searchInput.submit();
        waitToClickElement(By.xpath(WISH_LIST_BUTTON)).click();
        goToWishList();
        waitToFoundElement(By.xpath(WISH_LIST_BOOK_NAME));
    }

    private void goToWishList() {
        waitToClickElement(By.className(WISH_LIST_CLASS)).click();
    }
}