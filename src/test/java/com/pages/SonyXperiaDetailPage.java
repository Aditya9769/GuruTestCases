package com.pages;

import com.baseDriver.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SonyXperiaDetailPage{
    WebDriver driver;
    MobileListPage mobileListPage = new MobileListPage(BaseDriver.getDriver());

    @FindBy(className = "price")
    WebElement DetailPagePrice;

    public SonyXperiaDetailPage(WebDriver driver) {
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
