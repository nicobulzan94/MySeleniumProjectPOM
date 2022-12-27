import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {

    private WebDriver driver;

    @Before
    public void initDriver() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector(".skip-link.skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(6) a")).click();
        driver.findElement(By.id("email")).sendKeys("test@yopmail.com");
        driver.findElement(By.id("pass")).sendKeys("test123");
        driver.findElement(By.id("send2")).click();
    }


    @Test
    public void addToWishListTest() throws InterruptedException {


        driver.findElement(By.cssSelector(".nav-primary li.parent:nth-child(5) a")).click();
        driver.findElement(By.cssSelector("h2.product-name a")).click();
        driver.findElement(By.cssSelector(".add-to-links .link-wishlist")).click();

        Thread.sleep(2000);

        WebElement successMessage = driver.findElement(By.cssSelector(".success-msg span"));

        String expectedText = "Slim fit Dobby Oxford Shirt has been added to your wishlist. Click here to continue shopping.";
        String actualText = successMessage.getText();

        Assert.assertEquals(expectedText,actualText);



    }

    @Test
    public void addToCartFromWishlist() throws InterruptedException {

        driver.findElement(By.cssSelector(".skip-link.skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(2) a")).click();

        WebElement successMessage = driver.findElement(By.cssSelector(".page-title.title-buttons"));
        String expectedText = "MY WISHLIST";
        String actualText = successMessage.getText();
        Assert.assertEquals(expectedText,actualText);

        driver.findElement(By.cssSelector(".cart-cell .button.btn-cart")).click();

        Thread.sleep(2000);


    }

    @After
    public void quitTest() {
        driver.close();
    }


}
