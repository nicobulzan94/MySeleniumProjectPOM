package tests;

import global_Items.HeaderContainer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SaleMenPage;
import pages.WishListPage;

public class WishListTest {

    private WebDriver driver;

    @Before
    public void initDriver() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

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
    public void addToWishListTest() throws InterruptedException {


        HeaderContainer header = new HeaderContainer(driver);
        SaleMenPage saleMenPage = new SaleMenPage(driver);

        header.clickSaleHeaderLink();
        saleMenPage.clickSlimFitDobbyOxfordShirtLink();
        saleMenPage.clickAddToWishlistButton();

        Thread.sleep(2000);

        Assert.assertEquals("Slim fit Dobby Oxford Shirt has been added to your wishlist. Click here to continue shopping.",saleMenPage.getWishlistSuccessMsg());

    }

    @Test
    public void addToCartFromWishlist() throws InterruptedException {

        HeaderContainer header = new HeaderContainer(driver);
        SaleMenPage saleMenPage = new SaleMenPage(driver);
        WishListPage wishListPage = new WishListPage(driver);

        header.clickSaleHeaderLink();
        saleMenPage.clickSlimFitDobbyOxfordShirtLink();
        saleMenPage.clickAddToWishlistButton();

        Assert.assertEquals("MY WISHLIST",wishListPage.getMyWishListTitle());

        wishListPage.clickATOfromWishListPg();

        Thread.sleep(2000);


    }

    @After
    public void quitTest() {
        driver.close();
    }


}
