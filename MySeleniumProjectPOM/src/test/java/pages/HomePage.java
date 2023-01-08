package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".product-name a[title = 'Elizabeth Knit Top']")
    private WebElement elizabethKnitTop;
    @FindBy(css = ".swatch-label [alt = Red]")
    private WebElement elizColorSwatch;
    @FindBy(id = "option79")
    private WebElement elizSize;
    @FindBy(css = ".add-to-cart .button.btn-cart")
    private WebElement atoEliz;

    public void clickElizabethKnitTop() {
        elizabethKnitTop.click();
    }

    public void clickElizColorSwatch() {
        elizColorSwatch.click();
    }

    public void clickElizSize() {
        elizSize.click();
    }

    public void clickATOElizButton() {
        atoEliz.click();
    }



}
