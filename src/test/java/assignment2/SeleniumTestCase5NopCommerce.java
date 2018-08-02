package assignment2;

import base.SeleniumTestCaseBase;
import dal.Repositories;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test_data_models.Product;
import java.util.List;


class SeleniumTestCase5NopCommerce extends SeleniumTestCaseBase {
    private static final String WISH_LIST_CLASS     = "ico-wishlist";
    private static final String WISH_LIST_EMPTY_MSG = "The wishlist is empty!";
    private static final String NO_DATA_SELECTOR    = ".no-data";
    private static final String SEARCH_INPUT_ID     = "small-searchterms";
    @ParameterizedTest
    @MethodSource("testCaseProvider")
    void testCase(final Product product) {

        connectToSite();
        waitToClickElement(By.className(WISH_LIST_CLASS)).click();
        hasText(By.cssSelector(NO_DATA_SELECTOR), WISH_LIST_EMPTY_MSG);


        WebElement searchInput = waitToClickElement(By.id(SEARCH_INPUT_ID));
        searchInput.sendKeys(product.getName());
        searchInput.submit();


    }

    static List<Product> testCaseProvider() {
        return Repositories.getProductRepo().getAll();
    }
}
