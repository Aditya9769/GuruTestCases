package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myOrders {
    WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='View Order']")
    WebElement ViewOrder;

    public myOrders(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnViewOrder(){
        ViewOrder.click();
    }
}
