package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderNumberPage {
    WebDriver driver;

    @FindBy(xpath = "//h1[normalize-space()='Order #100019475 - Pending']")
    WebElement OrderStatus;

    @FindBy(xpath = "//a[normalize-space()='Print Order']")
    WebElement PrintOrder;

    public orderNumberPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String orderStatusMsg(){
        return OrderStatus.getText();
    }

    public void clickOnPrintOrder(){
        PrintOrder.click();
    }
}
