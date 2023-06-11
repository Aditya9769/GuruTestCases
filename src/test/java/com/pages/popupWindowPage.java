package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class popupWindowPage {
    WebDriver driver;

    @FindBy(xpath = "//h1[normalize-space()='Compare Products']")
    WebElement popupHeader;

    @FindBy(xpath = "//a[normalize-space()='']")
    List<WebElement> selectedMobiles;

    @FindBy(xpath = "//button[@title='Close Window']")
    WebElement closeButton;

    public popupWindowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPopupWindowDisplayed() {

        String mainWindowHandle = driver.getWindowHandle();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        boolean isDisplayed = popupHeader.isDisplayed();
        return isDisplayed;
    }

    public boolean areSelectedMobilesDisplayed() {
        return selectedMobiles.size() >= 2;
    }

    public void closePopupWindow() {
        closeButton.click();
    }
}
