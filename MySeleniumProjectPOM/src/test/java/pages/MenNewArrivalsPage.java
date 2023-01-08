package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenNewArrivalsPage {

    private WebDriver driver;
    public MenNewArrivalsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Linen Blazer Product
    @FindBy(id = "product-collection-image-406")
    private WebElement linenBlazer;
    @FindBy(linkText = "Add Your Review")
    private WebElement addYourReview;
    @FindBy(css = ".buttons-set .button")
    private WebElement submitReviewButton;
    @FindBy(id = "advice-validate-rating-validate_rating")
    private WebElement ratingsErrMsg;
    @FindBy(id = "advice-required-entry-review_field")
    private WebElement entryReviewErrMsg;
    @FindBy(id = "Price_3")
    private WebElement radioButtonPrice;
    @FindBy(id = "Value_4")
    private WebElement radioButtonValue;
    @FindBy(id = "Quality_5")
    private WebElement radioButtonQuality;
    @FindBy(id = "review_field")
    private WebElement reviewField;
    @FindBy(id = "summary_field")
    private WebElement summaryField;
    @FindBy(css = ".success-msg")
    private WebElement reviewAcceptedForModerationMsg;


    public void getLinenBlazer() {
        linenBlazer.click();
    }

    public void getAddYourReview() {
        addYourReview.click();
    }

    public void getSubmitReviewButton() {
        submitReviewButton.click();
    }

    public String getRatingsErrMsg() {
        return ratingsErrMsg.getText();
    }

    public String getEntryReviewErrMsg() {
        return entryReviewErrMsg.getText();
    }

    public void getRadioButtonPrice() {
        radioButtonPrice.click();
    }

    public void getRadioButtonValue() {
        radioButtonValue.click();
    }

    public void getRadioButtonQuality() {
        radioButtonQuality.click();
    }

    public void setReviewField(String value) {
        reviewField.sendKeys(value);
    }

    public void setSummaryField(String value) {
        summaryField.sendKeys(value);
    }

    public String getReviewAcceptedForModerationMsg() {
        return reviewAcceptedForModerationMsg.getText();
    }





}
