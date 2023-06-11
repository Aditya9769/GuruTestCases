package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class checkout {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='fieldset']//div[@class='fieldset']//ul//input[@title='Street Address']")
    WebElement ShippingAddress;

    @FindBy(xpath = "//input[@id='billing:city']")
    WebElement ShippingCity;

    @FindBy(xpath = "//select[@id='billing:region_id']")
    WebElement ShippingState;

    @FindBy(xpath = "//input[@id='billing:postcode']")
    WebElement ShippingZip;

    @FindBy(xpath = "//select[@id='billing:country_id']")
    WebElement ShippingCountry;

    @FindBy(xpath = "//input[@id='billing:telephone']")
    WebElement ShippingTelephone;

    @FindBy(xpath = "//button[@onclick='billing.save()']")
    WebElement Continue1;

    @FindBy(xpath = "//button[@onclick='shipping.save()']")
    WebElement Continue2;

    @FindBy(xpath = "//label[@for='s_method_flatrate_flatrate']//span[@class='price'][normalize-space()='$5.00']")
    WebElement ShippingCost;

    @FindBy(xpath = "//button[@onclick='shippingMethod.save()']")
    WebElement Continue3;

    @FindBy(xpath = "//label[normalize-space()='Check / Money order']")
    WebElement CheckMoneyOrder;

    @FindBy(xpath = "//button[@onclick='payment.save()']")
    WebElement Continue4;

    @FindBy(xpath = "//tr[@class='first']//span[@class='price'][normalize-space()='$615.00']")
    WebElement Subtotal;

    @FindBy(xpath = "//td[@class='a-right last']//span[@class='price'][normalize-space()='$5.00']")
    WebElement ShippingFee;

    @FindBy(xpath = "//span[normalize-space()='$620.00']")
    WebElement GrandTotal;

    @FindBy(xpath = "//button[contains(@title,'Place Order')]")
    WebElement PlaceOrder;

    public checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterShippingInfo(String Address, String City, String Zip, String Telephone){
        ShippingAddress.sendKeys(Address);
        ShippingCity.sendKeys(City);
        ShippingZip.sendKeys(Zip);
        ShippingTelephone.sendKeys(Telephone);
    }

    public void clickOnBillingContinue(){
        Continue1.click();
    }

    public void clickOnShippingInfoContinue(){
        Continue2.click();
    }

    public String shippingCost(){
        return ShippingCost.getText();
    }

    public void clickOnShippingMethodContinue(){
        Continue3.click();
    }

    public void selectMoneyOrder(){
        CheckMoneyOrder.click();
    }

    public void ShippingStateAndCountryDropdown(String State, String Country){
        Select select = new Select(ShippingState);
        select.selectByVisibleText(State);
        Select select1 = new Select(ShippingCountry);
        select1.selectByVisibleText(Country);
    }

    public void clickOnPaymentInfoContinue(){
        Continue4.click();
    }

    public double calculateGrandTotal(){
        double SubtotalDb = Double.parseDouble(Subtotal.getText().replaceAll("[^0-9.]", ""));
        double ShippingFeeDb = Double.parseDouble(ShippingFee.getText().replaceAll("[^0-9.]", ""));
        double GrandTotalDb = Double.parseDouble(GrandTotal.getText().replaceAll("[^0-9.]", ""));

        double expectedGrandTotal = SubtotalDb + ShippingFeeDb;
        return expectedGrandTotal;
    }

    public double actualGrandTotal(){
        double GrandTotalDb = Double.parseDouble(GrandTotal.getText().replaceAll("[^0-9.]", ""));
        return GrandTotalDb;
    }

    public void clickOnPlaceOrder(){
        PlaceOrder.click();
    }
}
