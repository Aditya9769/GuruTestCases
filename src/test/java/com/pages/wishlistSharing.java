package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class wishlistSharing {
    WebDriver driver;

    @FindBy(xpath = "//textarea[@id='email_address']")
    WebElement EmailAddress;

    @FindBy(xpath = "//textarea[@id='message']")
    WebElement Message;

    @FindBy(xpath = "//button[@title='Share Wishlist']")
    WebElement ShareWishlist;

    public wishlistSharing(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterEmailAndMessage(){
        EmailAddress.sendKeys("aditya.shinde@gmail.com");
        Message.sendKeys("This is my desired TV");
    }

    public void clickOnShareWishlist(){
        ShareWishlist.click();
    }
}
