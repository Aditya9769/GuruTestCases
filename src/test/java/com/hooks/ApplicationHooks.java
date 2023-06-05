package com.hooks;

import com.baseDriver.BaseDriver;
import com.utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class ApplicationHooks {
    private BaseDriver baseDriver;
    private WebDriver driver;
    private ConfigReader configreader;
    Properties prop;

    @Before(order = 0)
    public void getReader() throws IOException {
        configreader = new ConfigReader();
        prop = configreader.configReader();

    }

    @Before(order = 1)
    public void launchBrowser() {
        String browser = prop.getProperty("browser");
        baseDriver = new BaseDriver();
        driver = baseDriver.initializeBrowser(browser);

    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            //take screenshot
            String scenarioName = scenario.getName().replaceAll(" ", "_");
            byte[] impagePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(impagePath, "image/png", scenarioName);

        }
    }
}
