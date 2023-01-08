package global_Items;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderContainer {


    private WebDriver driver;
    public HeaderContainer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = ".skip-account .label")
    private WebElement accountButton;
    @FindBy(css = "[title='Log In']")
    private WebElement loginLink;
    @FindBy(css = "#header-account .links li:nth-child(5) a")
    private WebElement registerLink;
    @FindBy(css = ".nav-primary li.parent:nth-child(5) a")
    private WebElement saleHeaderLink;
    @FindBy(css = "a[href=http://testfasttrackit.info/selenium-test/wishlist/]")
    private WebElement wishListLink;
    @FindBy(id = "search")
    private WebElement searchBarField;
    @FindBy(css = ".button.search-button")
    private WebElement searchBarIcon;
    @FindBy(css = ".header-minicart .label")
    private WebElement cartButton;
    @FindBy(css = ".minicart-wrapper .empty")
    private WebElement noItemsInCartMsg;
    @FindBy(css = ".top-link-cart")
    private WebElement myCartLink;
    @FindBy(css = ".logo")
    private WebElement madisonIslandLogo;


    public void clickAccountButton() {
        accountButton.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void clickSaleHeaderLink() {
        saleHeaderLink.click();
    }

    public void clickWishListLink() {
        wishListLink.click();
    }

    public void setSearchBarField(String value) {
        searchBarField.sendKeys(value);
    }

    public void clickSearchBarIcon() {
        searchBarIcon.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public String setNoItemsInCartMsg() {
        return noItemsInCartMsg.getText();
    }

    public void clickMyCartLink() {
        myCartLink.click();
    }
    public void clickMadisonIslandLogo() {
        madisonIslandLogo.click();
    }




}
