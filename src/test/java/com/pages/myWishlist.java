package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myWishlist {
    WebDriver driver;

    @FindBy(xpath = "//button[@title='Share Wishlist']")
    WebElement ShareWishlist;

    @FindBy(xpath = "//span[normalize-space()='Your Wishlist has been shared.']")
    public
    WebElement ShareWishlistMsg;

    @FindBy(xpath = "//div[@class='cart-cell']//button[@title='Add to Cart']")
    WebElement AddToCart;

    public myWishlist(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickShareWishlist(){
        ShareWishlist.click();
    }

    public String wishlistIsShared(){
        ShareWishlistMsg.getText();
        return null;
    }

    public void clickAddToCart(){
        AddToCart.click();
    }
}
