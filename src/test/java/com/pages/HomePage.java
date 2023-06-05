package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Mobile']")
    WebElement mobileMenu;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String gethomePageTitle(){
        return driver.getTitle();
    }
    public void clickOnMobileMenu(){
        mobileMenu.click();
    }
}
