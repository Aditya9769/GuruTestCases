package com.pages;

import com.baseDriver.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
    WebDriver driver;

    @FindBy(xpath = "//input[@title='Qty']")
    WebElement qty;

    @FindBy(xpath = "//button[@title='Update']")
    WebElement update;

    @FindBy(xpath = "//span[contains(text(),'Some of the products')]")
    WebElement errorMsg;

    @FindBy(xpath = "//span[contains(text(),'Empty Cart')]")
    WebElement emptyCart;

    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart is Empty')]")
    WebElement cartIsEmpty;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void changeQtyValueAndClickUpdate(String qtyInput){
        qty.clear();
        qty.sendKeys(qtyInput);
        update.click();
    }

    public String verifyErrorMsg(){
        return errorMsg.getText();
//        Assert.assertEquals("The request quantity for  Sony Xperia is not available.",actualErrorMsg);
    }

    public void clickOnEmptyCart(){
        emptyCart.click();
    }

    public void verifyCartIsEmpty(){
        String actualEmptyCartMsg = cartIsEmpty.getText();
        Assert.assertEquals("SHOPPING CART IS EMPTY", actualEmptyCartMsg);
    }
}
