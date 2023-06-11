package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewCustomerAccount {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement FirstName;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement LastName;

    @FindBy(xpath = "//input[@id='email_address']")
    WebElement Email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement Password;

    @FindBy(xpath = "//input[@id='confirmation']")
    WebElement ConfirmPassword;

    @FindBy(xpath = "//button[@title='Register']")
    WebElement Register;

    public createNewCustomerAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void fillNewUserInfo(){
        FirstName.sendKeys("Adityaa");
        LastName.sendKeys("Shinde");
        Email.sendKeys("adityaa.shinde@gmail.com");
        Password.sendKeys("qwerty");
        ConfirmPassword.sendKeys("qwerty");
    }

    public void clickOnRegister(){
        Register.click();
    }
}
