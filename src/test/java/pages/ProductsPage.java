package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Utilities;

import java.util.HashMap;
import java.util.List;

public class ProductsPage extends Base {

    public final Utilities utilities;

    public ProductsPage() {
        PageFactory.initElements(driver, this);
        this.utilities = new Utilities();
    }

    @FindBy(xpath = "//span[@class='menu-ref__title-wrap']/a[.='Skincare']")
    WebElement skinCareSectionEl;

    @FindBy(xpath = "//h4[@data-test-id='product_subheader']")
    List<WebElement> listOfProductsOnPage;

    @FindBy(xpath = "//div[@class='elc-right-column-section js-right-column-section']//h1[@data-test-id='product_name']")
    WebElement productPageProductName;

    @FindBy(xpath = "//div[@class='elc-right-column-section js-right-column-section']//h4[@data-test-id='product_subheader']")
    WebElement productPageProductNameSubHeader;

    @FindBy(xpath = "//div[@class='elc-right-column-section js-right-column-section']//div[@data-test-id='price_formatted']/h4")
    WebElement productPageProductPrice;

    @FindBy(xpath = "//div[@class='elc-right-column-section js-right-column-section']//button[@data-test-id='add_to_bag_btn']")
    WebElement addToBagButton;

    @FindBy(xpath = "//button[@class='utility-nav__cart-button page-utilities__cart-button button-reset']")
    WebElement cardButton;

    public void navigateToSkincareSection() {
        utilities.waitForElementToBeClickable(skinCareSectionEl);
        skinCareSectionEl.click();
    }

    public void openRandomProduct() {
        utilities.waitForAllElementsToBeVisible(listOfProductsOnPage);
        WebElement randomProduct = utilities.getRandomListItemWebEl(listOfProductsOnPage);
        utilities.waitForElementToBeClickable(randomProduct);
        utilities.scrollToElement(randomProduct);
        randomProduct.click();
    }

    public String getProductName() {
        utilities.waitForElementToBeVisible(productPageProductName);
        return productPageProductName.getText();
    }

    public String getProductNameSubHeader() {
        utilities.waitForElementToBeVisible(productPageProductNameSubHeader);
        return productPageProductNameSubHeader.getText();
    }

    public String getProductPrice() {
        utilities.waitForElementToBeVisible(productPageProductPrice);
        return productPageProductPrice.getText();
    }

    public HashMap<String, String> saveProductData() {
        HashMap<String, String> productData = new HashMap<>();
        productData.put("name", getProductName());
        productData.put("nameSubHeader", getProductNameSubHeader());
        productData.put("price", getProductPrice());
        return productData;
    }

    public void clickAddToBagButton() {
        utilities.waitForElementToBeClickable(addToBagButton);
        addToBagButton.click();
    }

    public void verifyBtnTitleAddedToBag() {
        Assert.assertEquals(addToBagButton.getText(), "ADDED TO BAG");
    }

    public void clickCardButton() {
        utilities.waitForElementToBeClickable(cardButton);
        cardButton.click();
    }
}
