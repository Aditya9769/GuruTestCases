package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
    WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Mobile']")
    WebElement mobileMenu;

    @FindBy(xpath = "//a[@data-target-element='#header-account']")
    WebElement Account;

    @FindBy(xpath = "//div[@id='header-account']//div//a[@title='My Account'][normalize-space()='My Account']")
    WebElement MyAccount;

    public homePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String gethomePageTitle(){
        return driver.getTitle();
    }
    public void clickOnMobileMenu(){
        mobileMenu.click();
    }

    public void clickOnAccount(){
        Account.click();
        MyAccount.click();
    }
}
