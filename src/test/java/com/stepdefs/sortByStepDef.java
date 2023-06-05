package com.stepdefs;

import com.baseDriver.BaseDriver;
import com.pages.HomePage;
import com.pages.MobileListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sortByStepDef {
    HomePage homePage =  new HomePage(BaseDriver.getDriver());
    MobileListPage mobileListPage = new MobileListPage(BaseDriver.getDriver());

    @Given("User is on the Homepage")
    public void userIsOnTheHomepage() {
        BaseDriver.getDriver().get("https://live.guru99.com");
    }

    @When("User verify the title of the page")
    public void userVerifyTheTitleOfThePage() {
        homePage.gethomePageTitle();
    }

    @When("User click on the Mobile menu")
    public void userClickOnTheMobileMenu() {
        homePage.clickOnMobileMenu();
    }

    @Then("User verify the title of the Mobilelist page")
    public void userVerifyTheTitleOfTheMobilelistPage() {
        mobileListPage.getmobileListPageTitle();
    }

    @Then("User select Name from the SORT BY dropdown")
    public void userSelectNameFromTheSortByDropdown() {
        mobileListPage.selectDropdown();
    }

    @Then("User verify that all the products are sorted by name")
    public void userVerifyThatAllTheProductsAreSortedByName() {
        mobileListPage.sortMobilelist();
        
    }
}
