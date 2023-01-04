package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "advice-required-entry-email")
    private WebElement fillInRequiredField;

    @FindBy(css = ".error-msg span")
    private WebElement invalidLoginTextElement;

    @FindBy(css = ".welcome-msg .hello strong")
    private WebElement welcomeTextElement;


    public String getFillInRequiredField (){
        return fillInRequiredField.getText();
    }

    public String getInvalidLoginTextElement() {
        return invalidLoginTextElement.getText();
    }

    public String getWelcomeTextElement() {
        return welcomeTextElement.getText();
    }








}
