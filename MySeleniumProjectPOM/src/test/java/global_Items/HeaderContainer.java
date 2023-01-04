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




}
