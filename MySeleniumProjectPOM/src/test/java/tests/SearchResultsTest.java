package tests;

import global_Items.HeaderContainer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SearchResultsPage;

public class SearchResultsTest {

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
    public void searchWithNoResults() throws InterruptedException {

        HeaderContainer header = new HeaderContainer(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        header.setSearchBarField("alabalaportocala");
        header.clickSearchBarIcon();

        Thread.sleep(2000);

        Assert.assertEquals("Your search returns no results.",searchResultsPage.getSearchNoResultsMsg());


    }

    @Test
    public void searchWithResults() throws InterruptedException {

        HeaderContainer header = new HeaderContainer(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        header.setSearchBarField("neck");
        header.clickSearchBarIcon();

        Thread.sleep(2000);

        Assert.assertEquals("SEARCH RESULTS FOR 'NECK'",searchResultsPage.getSearchWithResultsTitle());
        Assert.assertTrue(searchResultsPage.prdctCategorySelectorIsDisplayed());

    }

    @After
    public void quit() {
        driver.close();
    }


}
