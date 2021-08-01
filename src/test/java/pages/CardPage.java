package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Utilities;

import java.util.HashMap;

public class CardPage extends Base {

    public final Utilities utilities;

    public CardPage() {
        PageFactory.initElements(driver, this);
        this.utilities = new Utilities();
    }

    @FindBy(xpath = "//div[@class='product_name cart-item__product-name']")
    WebElement productName;

    @FindBy(xpath = "//div[@class='product_subname cart-item__product-subname']")
    WebElement productNameSubHeader;

    @FindBy(xpath = "//div[@class='price column cart-item__price']")
    WebElement productPrice;

    @FindBy(xpath = "//div[@id='top-viewcart-buttons']//a[@data-test-id='cart_primarycheckout']")
    WebElement checkoutWIthCreditCardBtn;

    @FindBy(xpath = "//div[@class='samples-buttons top']//input[@data-test-id='form_checkout_samples_continue']")
    WebElement continueCheckoutBtn;

    @FindBy(xpath = "//a[.='Continue as guest']")
    WebElement continueAsGuestLink;

    @FindBy(xpath = "//input[@data-test-id='form_checkout_signin_new_user_submit']")
    WebElement continueAsGuestBtn;

    @FindBy(xpath = "//input[@id='form--checkout_signin_new_user--field--NEW_USER_EMAIL_ADDRESS']")
    WebElement emailAddressInput;

    @FindBy(xpath = "//input[@id='form--address_shipping--field--FIRST_NAME']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='form--address_shipping--field--LAST_NAME']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='form--address_shipping--field--ADDRESS1']")
    WebElement addressInput;

    @FindBy(xpath = "//input[@id='form--address_shipping--field--POSTAL_CODE']")
    WebElement zipInput;

    @FindBy(xpath = "//select[@id='form--address_shipping--field--STATE']")
    WebElement stateDropdown;

    @FindBy(xpath = "//input[@id='form--address_shipping--field--CITY']")
    WebElement cityInput;

    @FindBy(xpath = "//input[@id='form--address_shipping--field--PHONE1']")
    WebElement phoneInput;

    public String getProductName() {
        utilities.waitForElementToBeVisible(productName);
        return productName.getText();
    }

    public String getProductNameSubHeader() {
        utilities.waitForElementToBeVisible(productNameSubHeader);
        return productNameSubHeader.getText();
    }

    public String getProductPrice() {
        utilities.waitForElementToBeVisible(productPrice);
        return productPrice.getText();
    }

    public void verifyProductDataInCard(HashMap<String, String> productData) {
        Assert.assertEquals(productData.get("name"), getProductName());
        Assert.assertEquals(productData.get("nameSubHeader"), getProductNameSubHeader());
        Assert.assertEquals(productData.get("price"), getProductPrice());
    }

    public void clickCheckoutWithCreditCard() {
        utilities.waitForElementToBeClickable(checkoutWIthCreditCardBtn);
        checkoutWIthCreditCardBtn.click();
    }

    public void clickContinueCheckout() {
        utilities.waitForElementToBeClickable(continueCheckoutBtn);
        continueCheckoutBtn.click();
    }

    public void clickContinueAsGuestLink() {
        utilities.waitForElementToBeClickable(continueAsGuestLink);
        continueAsGuestLink.click();
    }

    public void enterEmailCheckoutPage(String email) {
        utilities.waitForElementToBeClickable(emailAddressInput);
        emailAddressInput.sendKeys(email);
    }

    public void clickContinueAsGuestBtn() {
        utilities.waitForElementToBeClickable(continueAsGuestBtn);
        continueAsGuestBtn.click();
    }

    public void enterFirstName(String firstname) {
        utilities.waitForElementToBeClickable(firstNameInput);
        firstNameInput.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        utilities.waitForElementToBeClickable(lastNameInput);
        lastNameInput.sendKeys(lastname);
    }

    public void enterAddress(String address) {
        utilities.waitForElementToBeClickable(addressInput);
        addressInput.sendKeys(address);
    }

    public void enterZipCode(String zip) {
        utilities.waitForElementToBeClickable(zipInput);
        zipInput.sendKeys(zip);
    }

    public void selectState(String state) {
        utilities.waitForElementToBeClickable(stateDropdown);
        Select dropdown = new Select(stateDropdown);
        dropdown.selectByValue(state);
    }

    public void enterCity(String city) {
        utilities.waitForElementToBeClickable(cityInput);
        cityInput.sendKeys(city);
    }

    public void enterPhone(String phone) {
        utilities.waitForElementToBeClickable(phoneInput);
        phoneInput.sendKeys(phone);
    }
}
