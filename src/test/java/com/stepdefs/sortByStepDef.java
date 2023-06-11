package com.stepdefs;

import com.baseDriver.BaseDriver;
import com.pages.homePage;
import com.pages.mobileListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sortByStepDef {
    com.pages.homePage homePage =  new homePage(BaseDriver.getDriver());
    com.pages.mobileListPage mobileListPage = new mobileListPage(BaseDriver.getDriver());

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
