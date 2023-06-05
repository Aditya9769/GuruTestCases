package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
    WebDriver driver;

    @FindBy(name = "cart[206686][qty]")
    WebElement qty;

    @FindBy(xpath = "//button[@class='button btn-update']")
    WebElement update;

    @FindBy(className = "item-msg error")
    WebElement errorMsg;

    @FindBy(xpath = "//span[contains(text(),'Empty Cart')]")
    WebElement emptyCart;

    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart is Empty')]")
    WebElement cartIsEmpty;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void changeQtyValueAndClickUpdate(){
        qty.clear();
        qty.sendKeys(String.valueOf(1000));
        update.click();
    }

    public void verifyErrorMsg(){
        String actualErrorMsg = errorMsg.getText();
        Assert.assertEquals("The request quantity for  Sony Xperia is not available.",actualErrorMsg);
    }

    public void clickOnEmptyCart(){
        emptyCart.click();
    }

    public void verifyCartIsEmpty(){
        String actualEmptyCartMsg = cartIsEmpty.getText();
        Assert.assertEquals("You have no items in your shopping cart.", actualEmptyCartMsg);
    }
}
