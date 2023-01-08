package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.WishListTest;

public class WishListPage {

    private WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".page-title.title-buttons")
    private WebElement myWishListTitle;
    @FindBy(css = ".cart-cell .button.btn-cart")
    private WebElement atoFromWishListPg;


    public String getMyWishListTitle() {
        return myWishListTitle.getText();
    }

    public void clickATOfromWishListPg() {
        atoFromWishListPg.click();
    }



}
