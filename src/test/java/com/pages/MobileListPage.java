package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MobileListPage {

    WebDriver driver;
    @FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div/select[1]")
    WebElement dropdown;

    @FindBy(xpath = "//h2[@class='product-name']/a")
    List<WebElement> MobileList;

    @FindBy(xpath = "//span[contains(text(),'$100.00')]")
    WebElement ListPagePrice;

    @FindBy(xpath = "//a[@title='Sony Xperia']")
    WebElement SonyXperia;

    @FindBy(xpath = "//button[contains(@onclick,'product/1/')]")
    WebElement SonyXperiaAddToCart;

    public MobileListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getmobileListPageTitle(){
        return driver.getTitle();
    }

    public void selectDropdown(){
        Select select = new Select(dropdown);
        select.selectByVisibleText("Name");
    }

    public void sortMobilelist(){
        List<String> mobileNames = new ArrayList<>();;
        MobileList.forEach(x -> mobileNames.add(x.getText()));
        List<String> sortedList = new ArrayList<>(mobileNames);
        sortedList.sort(String.CASE_INSENSITIVE_ORDER);
        mobileNames.equals(sortedList);
    }

    public String listPagePrice(){
        ListPagePrice.getText();
        return null;
    }

    public void clickOnSonyXperia(){
        SonyXperia.click();
    }

    public void clickOnSonyXperiaAddToCart(){
        SonyXperiaAddToCart.click();
    }
}
