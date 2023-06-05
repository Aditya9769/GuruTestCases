package com.stepdefs;

import com.baseDriver.BaseDriver;
import com.pages.HomePage;
import com.pages.MobileListPage;
import com.pages.ShoppingCart;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addToCartStepDef {

    MobileListPage mobileListPage = new MobileListPage(BaseDriver.getDriver());
    ShoppingCart shoppingCart = new ShoppingCart(BaseDriver.getDriver());

    @When("User click on ADD TO CART for the Sony Xperia mobile")
    public void userClickOnAddToCartForTheSonyXperiaMobile() {
        mobileListPage.clickOnSonyXperiaAddToCart();
    }

    @When("User change the QTY value to {int} and click the UPDATE button")
    public void userChangeTheQtyValueToAndClickTheUpdateButton(Integer int1) {
        shoppingCart.changeQtyValueAndClickUpdate();
    }

    @Then("User should see the error message")
    public void userShouldSeeTheErrorMessage() {
        shoppingCart.verifyErrorMsg();
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
