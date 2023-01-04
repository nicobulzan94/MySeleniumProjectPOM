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
import pages.RegistrationPage;

public class RegisterTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        HeaderContainer header = new HeaderContainer(driver);

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        header.clickAccountButton();
        header.clickRegisterLink();

    }

    @Test
    public void registerWithSuccess() throws InterruptedException {

        RegistrationPage regPage = new RegistrationPage(driver);

        regPage.setFirstNameField("Test");
        regPage.setLastNameField("Selenium");
        regPage.setEmailField("test_selenium_1@yopmail.com");
        regPage.setPasswordField("test123");
        regPage.setPasswordConfirmationField("test123");
        regPage.clickNewsletterCheckbox();
        //regPage.clickRegisterButton();

        Thread.sleep(2000);

    }

    @Test
    public void registerWithError() {

        RegistrationPage regPage = new RegistrationPage(driver);

        regPage.clickRegisterButton();

        Assert.assertEquals("* Required Fields",regPage.getRequiredFields());



    }

    @After
    public void quitTest() {
        driver.close();
    }


}
