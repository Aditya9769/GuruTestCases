package com.stepdefs;

import com.baseDriver.BaseDriver;
import com.pages.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class accountCreationStepDef {
    com.pages.homePage homePage =  new homePage(BaseDriver.getDriver());
    com.pages.createNewCustomerAccount createNewCustomerAccount =  new createNewCustomerAccount(BaseDriver.getDriver());
    com.pages.customerLogin customerLogin =  new customerLogin(BaseDriver.getDriver());
    com.pages.myAccount myAccount =  new myAccount(BaseDriver.getDriver());
    myAccount accountPage;
    com.pages.myWishlist myWishlist =  new myWishlist(BaseDriver.getDriver());
    myWishlist wishlistPage;
    com.pages.tvMenu tvMenu =  new tvMenu(BaseDriver.getDriver());
    com.pages.wishlistSharing wishlistSharing =  new wishlistSharing(BaseDriver.getDriver());

    @When("User click on the My Account link")
    public void userClickOnTheMyAccountLink() {
        homePage.clickOnAccount();
    }

    @When("User fill in the new user information except for the email id")
    public void userFillInTheNewUserInformationExceptForTheEmailId() {
        customerLogin.clickOnCreateAccount();
        createNewCustomerAccount.fillNewUserInfo();
    }

    @When("User click on Register button")
    public void userClickOnRegisterButton() {
        createNewCustomerAccount.clickOnRegister();
    }

    @Then("User verify that the registration is successful")
    public void userVerifyThatTheRegistrationIsSuccessful() {
        accountPage = new myAccount(BaseDriver.getDriver());
        String message = accountPage.registrationMsg();
        accountPage.AccountRegisteredMsg.isDisplayed();
    }

    @When("User go to the TV Menu")
    public void userGoToTheTvMenu() {
        myAccount.clickOnTvMenu();
    }

    @When("User add a product to wishlist")
    public void userAddAProductToWishlist() {
        tvMenu.addToWishlist();
    }

    @When("User click on the Share Wishlist button")
    public void userClickOnTheShareWishlistButton() {
        myWishlist.clickShareWishlist();
    }

    @When("User enter an email and a message and click on Share Wishlist")
    public void userEnterAnEmailAndAMessageAndClickOnShareWishlist() {
        wishlistSharing.enterEmailAndMessage();
        wishlistSharing.clickOnShareWishlist();
    }

    @Then("User check if the wishlist is shared successfully")
    public void userCheckIfTheWishlistIsSharedSuccessfully() {
        wishlistPage = new myWishlist(BaseDriver.getDriver());
        String message = wishlistPage.wishlistIsShared();
        wishlistPage.ShareWishlistMsg.isDisplayed();
    }
}
