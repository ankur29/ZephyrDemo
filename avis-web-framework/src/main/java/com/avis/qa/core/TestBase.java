package com.avis.qa.core;


import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static com.avis.qa.core.Configuration.BROWSER;
import static com.avis.qa.core.Configuration.URL;


/**
 * Class contains the Pre-requisite setup before running a Test Case
 *
 * @author ikumar
 */
@Log4j2
public class TestBase {

    private final ThreadLocal<BrowserInstance> appInstance = new ThreadLocal<>();

    @BeforeTest(alwaysRun = true)
    public void startTest(XmlTest xmlTest) {
        Configuration.setTestNGParameters(xmlTest);
        Configuration.setURL();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodTestBase() {
        log.info("beforeMethodTestBase() called");
        appInstance.set(new BrowserInstance(BROWSER));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodTestBase(ITestResult result) throws IOException {
        log.info("afterMethodTestBase() called");
        if (result.getStatus() == ITestResult.FAILURE) {
            Allure.addAttachment(result.getMethod().getMethodName(), new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
        //else
        getDriver().quit();
    }

    private BrowserInstance getBrowserInstance() {
        return appInstance.get();
    }

    public void launchUrl(String url) {
        getBrowserInstance().start(url);
    }

    public void launchUrl() {
        getBrowserInstance().start(URL);
    }

    public WebDriver getDriver() {
        return getBrowserInstance().getDriver();
    }
}
