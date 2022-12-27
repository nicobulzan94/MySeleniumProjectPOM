import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {

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
    public void searchWithNoResults() throws InterruptedException {
        driver.findElement(By.id("search")).sendKeys("alabalaportocala");
        driver.findElement(By.cssSelector(".button.search-button")).click();
        Thread.sleep(2000);

        WebElement searchWithoutResultsMsg = driver.findElement(By.cssSelector(".note-msg"));
        String expectedResult = "Your search returns no results.";
        String actualResult = searchWithoutResultsMsg.getText();
        Assert.assertEquals(expectedResult,actualResult);


    }

    @Test
    public void searchWithResults() throws InterruptedException {
        driver.findElement(By.id("search")).sendKeys("neck");
        driver.findElement(By.cssSelector(".button.search-button")).click();
        Thread.sleep(2000);

        WebElement searchWithoutResultsMsg = driver.findElement(By.cssSelector(".page-title"));
        String expectedResult = "SEARCH RESULTS FOR 'NECK'";
        String actualResult = searchWithoutResultsMsg.getText();
        Assert.assertEquals(expectedResult,actualResult);

        WebElement productsCategoryIsPresent = driver.findElement(By.cssSelector(".category-products"));
        Assert.assertTrue(productsCategoryIsPresent.isDisplayed());


    }

    @After
    public void quit() {
        driver.close();
    }


}
