package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


    public class SaleMenPage {
        private WebDriver driver;

        public SaleMenPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver,this);
        }


        @FindBy(css = "h2.product-name a")
        private WebElement slimFitDobbyOxfordShirtLink;
        @FindBy(css = "#swatch27 .swatch-label")
        private WebElement swatchColorDobby;
        @FindBy(css = "#swatch81 .swatch-label")
        private WebElement swatchSizeDobby;
        @FindBy(css = ".product-shop .btn-cart")
        private WebElement atoDobby;
        @FindBy(css = ".success-msg span")
        private WebElement dobbyAddedtoCartSuccessMsg;
        @FindBy(id = "advice-required-entry-attribute92")
        private WebElement errorMsgSwatchRequired;

        @FindBy(css = ".add-to-links .link-wishlist")
        private WebElement dobbyAddtoWishlist;

        @FindBy(css = ".success-msg span")
        private WebElement wishlistSuccessMsg;

        public void clickSlimFitDobbyOxfordShirtLink() {
            slimFitDobbyOxfordShirtLink.click();
        }

        public void clickSwatchColorDobby() {
            swatchColorDobby.click();
        }


        public void clickSwatchSizeDobby() {
            swatchSizeDobby.click();
        }

        public void clickATObutton() {
            atoDobby.click();
        }

        public String getDobbyAddedtoCartSuccessMsg (){

            return dobbyAddedtoCartSuccessMsg.getText();
        }

        public String getSwatchErrorMsg() {
            return errorMsgSwatchRequired.getText();
        }

        public void clickAddToWishlistButton() {
            dobbyAddtoWishlist.click();
        }

        public String getWishlistSuccessMsg() {
            return wishlistSuccessMsg.getText();
        }








    }


