package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class customerLogin {
    WebDriver driver;

    @FindBy(xpath = "//a[@title='Create an Account']")
    WebElement CreateAnAccount;

    @FindBy(xpath = "//input[@id='email']")
    WebElement EmailAddress;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement Password;

    @FindBy(xpath = "//button[@id='send2']")
    WebElement Login;

    public customerLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnCreateAccount(){
        CreateAnAccount.click();
    }

    public void enterLoginCredentials(){
        EmailAddress.sendKeys("abcdefxyz@gmail.com");
        Password.sendKeys("qwerty");
    }

    public void login(){
        Login.click();
    }
}
