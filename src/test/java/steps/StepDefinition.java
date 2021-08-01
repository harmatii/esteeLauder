package steps;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CardPage;
import pages.HomePage;
import pages.ProductsPage;

import java.util.HashMap;

public class StepDefinition extends Base {

    private final HomePage homePage;
    private final ProductsPage productsPage;
    private final CardPage cardPage;

    HashMap<String, String> productData;

    public  StepDefinition () {
        this.homePage = new HomePage();
        this.productsPage = new ProductsPage();
        this.cardPage = new CardPage();
    }

    @When("Navigate to Estee Lauder home page")
    public void navigateToEsteeLauderHomePage() {
        homePage.navigateToHomePage();
    }

    @And("Navigate to skincare section")
    public void navigateToSkincareSection() {
        productsPage.navigateToSkincareSection();
    }

    @And("Open any random product on the page")
    public void openAnyRandomProductOnThePage() {
        productsPage.openRandomProduct();
    }

    @And("Save product name and price")
    public void saveProductNameAndPrice() {
        this.productData = productsPage.saveProductData();
    }

    @And("Add product to the card")
    public void addProductToTheCard() {
        productsPage.clickAddToBagButton();
    }

    @Then("Verify button title changed to Added To Bag")
    public void verifyButtonTitleChangedToAddedToBag() {
        productsPage.verifyBtnTitleAddedToBag();
    }

    @And("Navigate to the Card")
    public void navigateToTheCard() throws InterruptedException {
        Thread.sleep(3000);
        productsPage.clickCardButton();
    }

    @Then("Verify correct product has been added to the card")
    public void verifyCorrectProductHasBeenAddedToTheCard() {
        cardPage.verifyProductDataInCard(productData);
    }

    @And("Click Checkout With Credit Card")
    public void clickCheckoutWithCreditCard() {
        cardPage.clickCheckoutWithCreditCard();
    }

    @And("Click Continue Checkout")
    public void clickContinueCheckout() {
        cardPage.clickContinueCheckout();
    }

    @And("Click Continue As Guest link on Checkout page")
    public void clickContinueAsGuestLinkOnCheckoutPage() {
        cardPage.clickContinueAsGuestLink();
    }

    @And("Enter email address (.+) on Checkout page")
    public void enterEmailAddressOnCheckoutPage(String email) {
        cardPage.enterEmailCheckoutPage(email);
    }

    @And("Click Continue As Guest button on Checkout page")
    public void clickContinueAsGuestButtonOnCheckoutPage() {
        cardPage.clickContinueAsGuestBtn();
    }

    @And("Enter First Name (.+) Last Name (.+) Address (.+) Zip (.+) State (.+) City (.+) Phone (.+)")
    public void enterFirstNameLastNameAddressZipStateCityPhone(String firstname, String lastname, String address, String zip, String state, String city, String phone) {
        cardPage.enterFirstName(firstname);
        cardPage.enterLastName(lastname);
        cardPage.enterAddress(address);
        cardPage.enterZipCode(zip);
        cardPage.enterCity(phone);
        cardPage.enterPhone(phone);
        cardPage.selectState(state);

    }
}
