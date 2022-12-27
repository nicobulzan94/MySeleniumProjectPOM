import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void registerWithSuccess() throws InterruptedException {

        driver.findElement(By.cssSelector(".skip-link.skip-account .label")).click();
        driver.findElement(By.cssSelector("#header-account .links li:nth-child(5) a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Test");
        driver.findElement(By.id("lastname")).sendKeys("Selenium");
        driver.findElement(By.className("validate-email")).sendKeys("test_selenium_1@yopmail.com");
        driver.findElement(By.id("password")).sendKeys("test123");
        driver.findElement(By.id("confirmation")).sendKeys("test123");
        driver.findElement(By.name("is_subscribed")).click();

        Thread.sleep(2000);

    }

    @After
    public void quitTest() {
        driver.close();
    }


}
