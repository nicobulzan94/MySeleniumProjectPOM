package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".note-msg")
    private WebElement searchNoResultsMsg;
    @FindBy(css = ".page-title")
    private WebElement searchWithResultsTitle;
    @FindBy(css = ".category-products")
    private WebElement productsCategoryIsPresent;



    public String getSearchNoResultsMsg() {
        return searchNoResultsMsg.getText();
    }

    public String getSearchWithResultsTitle() {
        return searchWithResultsTitle.getText();
    }

    public boolean prdctCategorySelectorIsDisplayed() {
        productsCategoryIsPresent.isDisplayed();
        return true;
    }












}
