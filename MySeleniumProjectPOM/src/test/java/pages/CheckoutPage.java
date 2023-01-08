package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = ".page-title")
    private WebElement checkoutTitle;
    @FindBy(css = "#billing-buttons-container .button")
    private WebElement billingButtonContinue;
    @FindBy(css = "#shipping-buttons-container .button")
    private WebElement shippingInfoContinue;
    @FindBy(id = "s_method_freeshipping_freeshipping")
    private WebElement shippingMethodFree;
    @FindBy(css = "#shipping-method-buttons-container button")
    private WebElement shippingMethodContinue;
    @FindBy(css = "#payment-buttons-container button")
    private WebElement paymentButtonContinue;
    @FindBy(css = ".buttons-set .button.btn-checkout")
    private WebElement placeOrderButton;
    @FindBy(css = "[title = 'Ship to different address']")
    private WebElement shipToDifAddressRadioB;
    @FindBy(css = ".sub-title")
    private WebElement orderConfSubTitle;


    public String setCheckoutTitle() {
        return checkoutTitle.getText();
    }

    public void clickBillingButtonContinue() {
        billingButtonContinue.click();
    }

    public void clickShippingInfoContinueButton() {
        shippingInfoContinue.click();
    }

    public void clickShippingMethodFree() {
        shippingMethodFree.click();
    }

    public void clickShippingMethodContinueButton() {
        shippingMethodContinue.click();
    }

    public void clickPaymentButtonContinue() {
        paymentButtonContinue.click();
    }

    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    public void clickShipToDifAddressRadioB() {
        shipToDifAddressRadioB.click();
    }
    public String setOrderConfSubTitle() {
        return orderConfSubTitle.getText();
    }


}
