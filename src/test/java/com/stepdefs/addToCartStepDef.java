package com.stepdefs;

import com.baseDriver.BaseDriver;
import com.pages.HomePage;
import com.pages.MobileListPage;
import com.pages.ShoppingCart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class addToCartStepDef {

    MobileListPage mobileListPage = new MobileListPage(BaseDriver.getDriver());
    ShoppingCart shoppingCart = new ShoppingCart(BaseDriver.getDriver());

    @When("User click on ADD TO CART for the Sony Xperia mobile")
    public void userClickOnAddToCartForTheSonyXperiaMobile() {
        mobileListPage.clickOnSonyXperiaAddToCart();
    }

    @When("User change the QTY value to {string} and click the UPDATE button")
    public void userChangeTheQtyValueToAndClickTheUpdateButton(String qtyInput) {
        shoppingCart.changeQtyValueAndClickUpdate(qtyInput);
    }

    @Then("User should see the error message")
    public void userShouldSeeTheErrorMessage() {
        String expectedErrorMessage = "The request quantity for  Sony Xperia is not available.";
        String actualErrorMessage = shoppingCart.verifyErrorMsg();
        Assert.assertNotEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("User click on the EMPTY CART link in the footer")
    public void userClickOnTheEmptyCartLinkInTheFooter() {
        shoppingCart.clickOnEmptyCart();
    }

    @Then("User should see that the cart is empty")
    public void userShouldSeeThatTheCartIsEmpty() {
        shoppingCart.verifyCartIsEmpty();
    }
}
