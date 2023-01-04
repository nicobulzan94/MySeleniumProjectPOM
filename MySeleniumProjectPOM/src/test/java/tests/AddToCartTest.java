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
import pages.HomePage;
import pages.LoginPage;
import pages.SaleMenPage;

public class AddToCartTest {

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
    public void productNotAddedtoCartError() throws InterruptedException {

        HeaderContainer header = new HeaderContainer(driver);
        SaleMenPage saleMenPage = new SaleMenPage(driver);

        header.clickSaleHeaderLink();
        saleMenPage.clickSlimFitDobbyOxfordShirtLink();
        saleMenPage.clickATObutton();

        Thread.sleep(2000);

        Assert.assertEquals("This is a required field.",saleMenPage.getSwatchErrorMsg());

    }


    @Test
    public void addToCartSuccessfully() throws InterruptedException {

        HeaderContainer header = new HeaderContainer(driver);
        SaleMenPage saleMenPage = new SaleMenPage(driver);

        header.clickSaleHeaderLink();
        saleMenPage.clickSlimFitDobbyOxfordShirtLink();
        saleMenPage.clickSwatchColorDobby();
        saleMenPage.clickSwatchSizeDobby();
        saleMenPage.clickATObutton();

        Thread.sleep(2000);

        Assert.assertEquals("Slim fit Dobby Oxford Shirt was added to your shopping cart.",saleMenPage.getDobbyAddedtoCartSuccessMsg());

    }

    @After
    public void quitTest() {
        driver.close();
    }



}
