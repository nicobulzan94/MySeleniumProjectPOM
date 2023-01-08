package tests;

import global_Items.HeaderContainer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class CartTest {
    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void miniCartIsEmpty() {
        HeaderContainer header = new HeaderContainer(driver);

        header.clickCartButton();

        Assert.assertEquals("You have no items in your shopping cart.",header.setNoItemsInCartMsg());

    }

    @Test
    public void shoppingCartPgIsEmpty() {
        HeaderContainer header = new HeaderContainer(driver);
        CartPage cartPage = new CartPage(driver);

        header.clickAccountButton();
        header.clickMyCartLink();
        Assert.assertEquals("SHOPPING CART IS EMPTY",cartPage.setCartEmptyTitle());

    }

    @Test
    public void removeItemFromCart() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickElizabethKnitTop();
        homePage.clickElizColorSwatch();
        homePage.clickElizSize();
        homePage.clickATOElizButton();
        Assert.assertEquals("Elizabeth Knit Top was added to your shopping cart.", cartPage.getProductAddedtoCartMsg());
        cartPage.clickRemoveButton();

    }

    @Test
    public void changeQuantity() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickElizabethKnitTop();
        homePage.clickElizColorSwatch();
        homePage.clickElizSize();
        homePage.clickATOElizButton();
        Assert.assertEquals("Elizabeth Knit Top was added to your shopping cart.", cartPage.getProductAddedtoCartMsg());
        cartPage.clearChangeQty();
        cartPage.setChangeQty("2");
        cartPage.clickQtyUpdateButton();


    }

    @Test
    public void emptyDiscountField() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickElizabethKnitTop();
        homePage.clickElizColorSwatch();
        homePage.clickElizSize();
        homePage.clickATOElizButton();
        cartPage.clickDiscountApplyLink();
        Assert.assertEquals("This is a required field.", cartPage.getDiscountRequiredFieldErrMsg());

    }

    @Test
    public void incorrectDiscountField() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickElizabethKnitTop();
        homePage.clickElizColorSwatch();
        homePage.clickElizSize();
        homePage.clickATOElizButton();
        cartPage.setCouponCodeField("madison");
        cartPage.clickDiscountApplyLink();
        Assert.assertEquals("Coupon code \"madison\" is not valid.", cartPage.getInvalidCouponErrMsg());

    }

    @Test
    public void proceedToCheckout() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        homePage.clickElizabethKnitTop();
        homePage.clickElizColorSwatch();
        homePage.clickElizSize();
        homePage.clickATOElizButton();
        cartPage.clickProceedToCheckoutButton();
        Assert.assertEquals("CHECKOUT", checkoutPage.setCheckoutTitle());

    }

    @After
    public void quitTest() {
        driver.close();
    }


}
