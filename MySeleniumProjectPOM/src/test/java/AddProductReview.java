import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddProductReview {

    private WebDriver driver;
    private Actions actions;

    @Before
    public void initDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector(".skip-link.skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(6) a")).click();
        driver.findElement(By.id("email")).sendKeys("test@yopmail.com");
        driver.findElement(By.id("pass")).sendKeys("test123");
        driver.findElement(By.id("send2")).click();

        WebElement navOptionMen = driver.findElement(By.cssSelector(".level0.nav-2.parent"));
        actions.moveToElement(navOptionMen).perform();

        WebElement newArrivals = driver.findElement(By.linkText("New Arrivals"));
        actions.moveToElement(newArrivals).perform();
        newArrivals.click();

        driver.findElement(By.id("product-collection-image-406")).click();
        driver.findElement(By.linkText("Add Your Review")).click();


    }

    @Test
    public void submitReviewWithEmptyFields() {
        driver.findElement(By.cssSelector(".buttons-set .button")).click();

        WebElement ratingsErrMsg = driver.findElement(By.id("advice-validate-rating-validate_rating"));
        String expectedRatingsErrMsg = "Please select one of each of the ratings above";
        String actualRatingsErrMsg = ratingsErrMsg.getText();
        Assert.assertEquals(expectedRatingsErrMsg,actualRatingsErrMsg);

        WebElement entryReviewErrMsg = driver.findElement(By.id("advice-required-entry-review_field"));
        String expectedEntryReviewErrMsg = "THIS IS A REQUIRED FIELD.";
        String actualEntryReviewErrMsg = entryReviewErrMsg.getText();
        Assert.assertEquals(expectedEntryReviewErrMsg,actualEntryReviewErrMsg);

    }

    @Test
    public void submitReviewSuccessfully() {
        driver.findElement(By.id("Price_3")).click();
        driver.findElement(By.id("Value_4")).click();
        driver.findElement(By.id("Quality_5")).click();
        driver.findElement(By.id("review_field")).sendKeys("I believe that clothes should not be this expensive because there are things in life that are more important.");
        driver.findElement(By.id("summary_field")).sendKeys("Product is great quality but too expensive.");
        driver.findElement(By.cssSelector(".buttons-set .button")).click();

        WebElement reviewAcceptedForModerationMsg = driver.findElement(By.cssSelector(".success-msg"));
        String expectedText = "Your review has been accepted for moderation.";
        String actualText = reviewAcceptedForModerationMsg.getText();
        Assert.assertEquals(expectedText,actualText);

    }

    @After
    public void quitTest() {
        driver.close();
    }





}
