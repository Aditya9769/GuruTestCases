package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class magentoCommerce {
    WebDriver driver;
    @FindBy(xpath = "//body/div/div/div/div/div/p[1]")
    WebElement OrderGenerationMsg;

    public magentoCommerce(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void orderGeneratedMsgAndOrderNumber(){
        String OrderNumberText = OrderGenerationMsg.getText();
        String orderNumber = OrderNumberText.replace("Your order # is: ", "");
        System.out.println("Order Number: " + orderNumber);
    }
}
