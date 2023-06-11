package com.pages;

import com.baseDriver.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sonyXperiaDetailPage {
    WebDriver driver;
    com.pages.mobileListPage mobileListPage = new mobileListPage(BaseDriver.getDriver());

    @FindBy(className = "price")
    WebElement DetailPagePrice;

    public sonyXperiaDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String detailPagePrice(){
        DetailPagePrice.getText();
        return null;
    }

    public void compareSonyXperiaListPageAndDetailPagePrice(){
        Assert.assertEquals(mobileListPage.listPagePrice(),detailPagePrice());
    }
}
