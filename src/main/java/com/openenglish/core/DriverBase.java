package com.openenglish.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.openenglish.core.TestData.Selenide.TIMEOUT;

public class DriverBase {

    @BeforeMethod
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.timeout = TIMEOUT;
    }

//    @AfterMethod
//    public void tearDown() {
//        WebDriverRunner.getWebDriver().quit();
//    }
}
