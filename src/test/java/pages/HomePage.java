package pages;

import base.Base;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get("https://www.esteelauder.com/");
    }
}
