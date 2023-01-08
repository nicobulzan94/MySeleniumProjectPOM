package tests;

import global_Items.HeaderContainer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckoutTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        HeaderContainer header = new HeaderContainer(driver);
        LoginPage loginPage = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        header.clickAccountButton();
        header.clickLoginLink();

        loginPage.setEmailField("test@yopmail.com");
        loginPage.setPasswordField("test123");
        loginPage.clickLoginButton();

    }

    @Test
    public void placeOrderSuccessfully() throws InterruptedException {
        HeaderContainer header = new HeaderContainer(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        header.clickMadisonIslandLogo();
        homePage.clickElizabethKnitTop();
        homePage.clickElizColorSwatch();
        homePage.clickElizSize();
        homePage.clickATOElizButton();
        cartPage.clickProceedToCheckoutButton();
        Assert.assertEquals("CHECKOUT", checkoutPage.setCheckoutTitle());
        checkoutPage.clickShipToDifAddressRadioB();
        checkoutPage.clickBillingButtonContinue();
        Thread.sleep(2000);
        checkoutPage.clickShippingInfoContinueButton();
        Thread.sleep(4000);
        checkoutPage.clickShippingMethodFree();
        checkoutPage.clickShippingMethodContinueButton();
        Thread.sleep(4000);
        checkoutPage.clickPaymentButtonContinue();
        Thread.sleep(4000);
        checkoutPage.clickPlaceOrderButton();
        Thread.sleep(6000);

        Assert.assertEquals("YOUR ORDER HAS BEEN RECEIVED.",checkoutPage.setCheckoutTitle());
        Assert.assertEquals("THANK YOU FOR YOUR PURCHASE!", checkoutPage.setOrderConfSubTitle());

    }

    @After
    public void quit() {
        driver.close();
    }





}
