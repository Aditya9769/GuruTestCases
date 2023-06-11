package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Thank you for registering with Main Website Store.']")
    public
    WebElement AccountRegisteredMsg;

    @FindBy(xpath = "//a[normalize-space()='TV']")
    WebElement TvMenu;

    @FindBy(xpath = "//a[@data-target-element='#header-account']")
    WebElement MyAccount;

    @FindBy(xpath = "//a[normalize-space()='My Wishlist']")
    WebElement MyWishlist;

    @FindBy(xpath = "//a[normalize-space()='My Orders']")
    WebElement MyOrders;

    public myAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String registrationMsg(){
        AccountRegisteredMsg.getText();
        return null;
    }

    public void clickOnTvMenu(){
        TvMenu.click();
    }

    public void clickOnMyWishlist(){
        MyAccount.click();
        MyWishlist.click();
    }

    public void clickOnMyOrders(){
        MyOrders.click();
    }
}
