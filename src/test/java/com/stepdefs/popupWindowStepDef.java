package com.stepdefs;

import com.baseDriver.BaseDriver;
import com.pages.mobileListPage;
import com.pages.popupWindowPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class popupWindowStepDef {

    com.pages.mobileListPage mobileListPage = new mobileListPage(BaseDriver.getDriver());
    com.pages.popupWindowPage popupWindowPage = new popupWindowPage(BaseDriver.getDriver());
    @When("User click on the Add to Compare button for any two mobile phones")
    public void userClickOnTheAddToCompareButtonForAnyTwoMobilePhones() {
        mobileListPage.clickAddToCompareForTwoMobiles();
    }

    @When("User click on the Compare button")
    public void userClickOnTheCompareButton() {
        mobileListPage.clickCompareButton();
    }

    @Then("A pop up window should appear with details of the two selected mobile phones")
    public void aPopUpWindowShouldAppearWithDetailsOfTheTwoSelectedMobilePhones() {
        Assert.assertTrue(popupWindowPage.isPopupWindowDisplayed());
        Assert.assertTrue(popupWindowPage.areSelectedMobilesDisplayed());
    }

    @Then("User close the pop up window")
    public void userCloseThePopUpWindow() {
        popupWindowPage.closePopupWindow();
    }
}
