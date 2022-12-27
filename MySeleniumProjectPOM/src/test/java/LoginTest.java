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

public class LoginTest {
    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }



    @Test
    public void loginWithNoEmailOrPass() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.clickLoginButton();

        Thread.sleep(2000);

        WebElement fillInRequiredField = driver.findElement(By.id("advice-required-entry-email"));
        String expectedText = "This is a required field.";
        String actualText = fillInRequiredField.getText();
        Assert.assertEquals(expectedText,actualText);


    }


    @Test
    public void loginWithInvalidEmail() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("te@yopmail.com");
        loginPage.setPasswordField("test123");
        loginPage.clickLoginButton();

        Thread.sleep(2000);

        WebElement invalidLoginTextElement = driver.findElement(By.cssSelector(".error-msg span"));
        String expectedText = "Invalid login or password.";
        String actualText = invalidLoginTextElement.getText();
        Assert.assertEquals(expectedText,actualText);


    }

    @Test
    public void loginWithValidData() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("test@yopmail.com");
        loginPage.setPasswordField("test123");
        loginPage.clickLoginButton();

        Thread.sleep(2000);

        WebElement welcomeTextElement = driver.findElement(By.cssSelector(".welcome-msg .hello strong"));
        String expectedText = "Hello, test test tester!";
        String actualText = welcomeTextElement.getText();
        Assert.assertEquals(expectedText,actualText);

        /*
        if (actualText.equals(expectedText)){
            System.out.println("S-a logat cu success!");
        }else {
            System.err.println("Nu s-a logat. ");
        }
        */

    }





    @After
    public void quitTest() {
        driver.close();
    }



}
