package com.stepdefs;

import com.baseDriver.BaseDriver;
import com.pages.HomePage;
import com.pages.MobileListPage;
import com.pages.SonyXperiaDetailPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class listPageStepDef {

    MobileListPage mobileListPage = new MobileListPage(BaseDriver.getDriver());
    SonyXperiaDetailPage sonyXperiaDetailPage = new SonyXperiaDetailPage(BaseDriver.getDriver());

    @When("User note the price of Sony Xperia Mobile")
    public void userNoteThePriceOfSonyXperiaMobile() {
        mobileListPage.listPagePrice();
    }

    @When("User click on Sony Xperia Mobile")
    public void userClickOnSonyXperiaMobile() {
        mobileListPage.clickOnSonyXperia();
    }

    @When("User note the Sony Xperia Mobile price from the detail page")
    public void userNoteTheSonyXperiaMobilePriceFromTheDetailPage() {
        sonyXperiaDetailPage.detailPagePrice();
    }

    @Then("User compare the price of Sony Xperia Mobile on the list page and detail page")
    public void userCompareThePriceOfSonyXperiaMobileOnTheListpageAndDetailpage() {
        sonyXperiaDetailPage.compareSonyXperiaListPageAndDetailPagePrice();
    }
}
