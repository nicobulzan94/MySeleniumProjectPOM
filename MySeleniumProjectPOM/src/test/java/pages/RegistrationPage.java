package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "email_address")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmation")
    private WebElement passwordConfirmationField;

    @FindBy(id = "is_subscribed")
    private WebElement newsletterCheckbox;

    @FindBy(css = ".buttons-set .button")
    private WebElement registerButton;

    @FindBy(css = "p.required")
    private WebElement requiredFields;



    public void setFirstNameField(String value) {
        firstNameField.sendKeys(value);
    }

    public void setLastNameField(String value) {
        lastNameField.sendKeys(value);
    }

    public void setEmailField(String value) {
        emailField.sendKeys(value);
    }

    public void setPasswordField(String value) {
        passwordField.sendKeys(value);
    }

    public void setPasswordConfirmationField(String value) {
        passwordConfirmationField.sendKeys(value);
    }

    public void clickNewsletterCheckbox() {
        newsletterCheckbox.click();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public String getRequiredFields (){
        return requiredFields.getText();
    }








}
