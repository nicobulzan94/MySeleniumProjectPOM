package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".page-title")
    private WebElement cartEmptyTitle;
    @FindBy(css = ".success-msg span")
    private WebElement productAddedtoCartMsg;
    @FindBy(css = ".product-cart-remove .btn-remove2")
    private WebElement removeItemButton;
    @FindBy(css = ".product-cart-actions .input-text.qty")
    private WebElement changeQty;
    @FindBy(css = ".button.btn-update")
    private WebElement updateQtyButton;
    @FindBy(css = ".button-wrapper [title = 'Apply']")
    private WebElement discountApplyLink;
    @FindBy(id = "advice-required-entry-coupon_code")
    private WebElement discountRequiredFieldErrMsg;
    @FindBy(id = "coupon_code")
    private WebElement couponCodeField;
    @FindBy(css = "li.error-msg")
    private WebElement invalidCouponErrMsg;
    @FindBy(css = ".title-buttons [title = 'Proceed to Checkout']")
    private WebElement proceedToCheckoutButton;

    public String setCartEmptyTitle() {
        return cartEmptyTitle.getText();
    }

    public String getProductAddedtoCartMsg() {
        return productAddedtoCartMsg.getText();
    }

    public void clickRemoveButton() {
        removeItemButton.click();
    }

    public void clearChangeQty() {
        changeQty.clear();
    }

    public void setChangeQty(String value) {
        changeQty.sendKeys(value);
    }

    public void clickQtyUpdateButton() {
        updateQtyButton.click();
    }

    public void clickDiscountApplyLink() {
        discountApplyLink.click();
    }

    public String getDiscountRequiredFieldErrMsg() {
        return discountRequiredFieldErrMsg.getText();
    }
    public void setCouponCodeField(String value){
        couponCodeField.sendKeys(value);
    }

    public String getInvalidCouponErrMsg() {
        return invalidCouponErrMsg.getText();
    }
    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }













}
