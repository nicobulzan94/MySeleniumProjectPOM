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
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void initDriver() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        HeaderContainer header = new HeaderContainer(driver);

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        header.clickAccountButton();
        header.clickLoginLink();
    }



    @Test
    public void loginWithNoEmailOrPass() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        loginPage.clickLoginButton();

        Thread.sleep(2000);

        Assert.assertEquals("This is a required field.",accountPage.getFillInRequiredField());

    }


    @Test
    public void loginWithInvalidEmail() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        loginPage.setEmailField("te@yopmail.com");
        loginPage.setPasswordField("test123");
        loginPage.clickLoginButton();

        Thread.sleep(2000);

        Assert.assertEquals("Invalid login or password.",accountPage.getInvalidLoginTextElement());


    }

    @Test
    public void loginWithValidData() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        loginPage.setEmailField("test@yopmail.com");
        loginPage.setPasswordField("test123");
        loginPage.clickLoginButton();

        Thread.sleep(2000);

        Assert.assertEquals("Hello, test test tester!",accountPage.getWelcomeTextElement());

    }

    @After
    public void quitTest() {
        driver.close();
    }


}
