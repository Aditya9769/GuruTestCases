package com.baseDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseDriver {

    public static WebDriver driver;
    private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    public static WebDriver initializeBrowser(String browser){

        if(browser.equalsIgnoreCase("chrome")) {
            tdriver.set(new ChromeDriver());
        }else if(browser.equalsIgnoreCase("edge")){
            tdriver.set(new EdgeDriver());
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        return getDriver();
    }
    public static WebDriver getDriver(){

        return tdriver.get();
    }
}
