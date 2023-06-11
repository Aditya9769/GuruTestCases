package com.stepdefs;

import com.baseDriver.BaseDriver;
import com.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static com.baseDriver.BaseDriver.driver;

public class purchaseProductStepDef {
    com.pages.customerLogin customerLogin =  new customerLogin(BaseDriver.getDriver());
    com.pages.checkout checkout =  new checkout(BaseDriver.getDriver());
    com.pages.magentoCommerce magentoCommerce =  new magentoCommerce(BaseDriver.getDriver());
    com.pages.myAccount myAccount =  new myAccount(BaseDriver.getDriver());
    com.pages.myWishlist myWishlist =  new myWishlist(BaseDriver.getDriver());
    com.pages.shoppingCart shoppingCart =  new shoppingCart(BaseDriver.getDriver());

    @When("User logs in to the application using previously created credentials")
    public void userLogsInToTheApplicationUsingPreviouslyCreatedCredentials() {
        customerLogin.enterLoginCredentials();
        customerLogin.login();
    }

    @When("User clicks on the MY WISHLIST link")
    public void userClicksOnTheMyWishlistLink() {
        myAccount.clickOnMyWishlist();
    }

    @When("User clicks on Add to Cart link on the wishlist page")
    public void userClicksOnAddToCartLinkOnTheWishlistPage() {
        myWishlist.clickAddToCart();
    }

    @When("User clicks Proceed to checkout")
    public void userClicksProceedToCheckout() {
        shoppingCart.clickProceedToCheckout();
    }

    @When("User enters the following shipping information:")
    public void userEntersTheFollowingShippingInformation(DataTable dataTable) {
        List<Map<String, String>> shippingData = dataTable.asMaps(String.class, String.class);
        Map<String, String> shippingInfo = shippingData.get(0);

        String address = shippingInfo.get("Address");
        String city = shippingInfo.get("City");
        String zip = shippingInfo.get("Zip");
        String telephone = shippingInfo.get("Telephone");
        String state = shippingInfo.get("State");
        String country = shippingInfo.get("Country");
        checkout.enterShippingInfo(address, city, zip, telephone);
        checkout.ShippingStateAndCountryDropdown(state, country);
    }

    @When("User clicks Estimate")
    public void userClicksEstimate() throws InterruptedException {
        checkout.clickOnBillingContinue();
            Thread.sleep(5000);
    }

    @Then("User verifies that the shipping cost is generated")
    public void userVerifiesThatTheShippingCostIsGenerated() {
        Assert.assertEquals("$5.00",checkout.shippingCost());
    }

    @Then("User clicks Continue in the shipping method section")
    public void userClicksContinueInTheShippingMethodSection() throws InterruptedException {
        checkout.clickOnShippingMethodContinue();
            Thread.sleep(5000);
    }

    @Then("User selects Check Money order radio button in the payment information section")
    public void userSelectsCheckMoneyOrderRadioButtonInThePaymentInformationSection() {
        checkout.selectMoneyOrder();
    }

    @Then("User clicks Continue")
    public void userClicksContinue() throws InterruptedException {
        checkout.clickOnPaymentInfoContinue();
            Thread.sleep(5000);
    }

    @Then("User verifies that the selected shipping cost is updated in the total")
    public void userVerifiesThatTheSelectedShippingCostIsUpdatedInTheTotal() {
        Assert.assertEquals(checkout.calculateGrandTotal(), checkout.actualGrandTotal(), 0.01);
    }

    @Then("User clicks PLACE ORDER button")
    public void userClicksPLACEORDERButton() throws InterruptedException {
        checkout.clickOnPlaceOrder();
            Thread.sleep(5000);
    }

    @Then("User verifies that the order is generated and notes the order number")
    public void userVerifiesThatTheOrderIsGeneratedAndNotesTheOrderNumber() {
        magentoCommerce.orderGeneratedMsgAndOrderNumber();
    }
}
