package steps;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.PageFactory;

public class Hooks extends Base {

    public Hooks() {
        PageFactory.initElements(driver, this);
    }

    @Before
    public void setUp() {
        openBrowser();
    }

    @After
    public void tearDown() {
//        driver.quit();
    }
}
