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
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.MenNewArrivalsPage;

public class AddProductReview {

    private WebDriver driver;
    private Actions actions;

    @Before
    public void initDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);

        HeaderContainer header = new HeaderContainer(driver);
        LoginPage loginPage = new LoginPage(driver);
        MenNewArrivalsPage menNewArrivalsPage = new MenNewArrivalsPage(driver);

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        header.clickAccountButton();
        header.clickLoginLink();

        loginPage.setEmailField("test@yopmail.com");
        loginPage.setPasswordField("test123");
        loginPage.clickLoginButton();

        WebElement navOptionMen = driver.findElement(By.cssSelector(".level0.nav-2.parent"));
        actions.moveToElement(navOptionMen).perform();

        WebElement newArrivals = driver.findElement(By.linkText("New Arrivals"));
        actions.moveToElement(newArrivals).perform();
        newArrivals.click();

        menNewArrivalsPage.getLinenBlazer();
        menNewArrivalsPage.getAddYourReview();


    }

    @Test
    public void submitReviewWithEmptyFields() {

        MenNewArrivalsPage menNewArrivalsPage = new MenNewArrivalsPage(driver);

        menNewArrivalsPage.getSubmitReviewButton();

        Assert.assertEquals("Please select one of each of the ratings above",menNewArrivalsPage.getRatingsErrMsg());
        Assert.assertEquals("THIS IS A REQUIRED FIELD.",menNewArrivalsPage.getEntryReviewErrMsg());

    }

    @Test
    public void submitReviewSuccessfully() {

        MenNewArrivalsPage menNewArrivalsPage = new MenNewArrivalsPage(driver);

        menNewArrivalsPage.getRadioButtonPrice();
        menNewArrivalsPage.getRadioButtonValue();
        menNewArrivalsPage.getRadioButtonQuality();
        menNewArrivalsPage.setReviewField("I believe that clothes should not be this expensive because there are things in life that are more important.");
        menNewArrivalsPage.setSummaryField("Product is great quality but too expensive.");
        menNewArrivalsPage.getSubmitReviewButton();

        Assert.assertEquals("Your review has been accepted for moderation.",menNewArrivalsPage.getReviewAcceptedForModerationMsg());

    }

    @After
    public void quitTest() {
        driver.close();
    }





}
