package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class tvMenu {
    WebDriver driver;

    @FindBy(xpath = "//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")
    WebElement LgAddToWishlist;

    public tvMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void addToWishlist(){
        LgAddToWishlist.click();
    }
}
