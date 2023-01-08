package global_Items;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Footer {
    private WebDriver driver;
    public Footer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }




}
