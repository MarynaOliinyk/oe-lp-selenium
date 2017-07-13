package com.openenglish.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeClass;

import static com.openenglish.util.PropertiesCache.getInstance;

public class TestBase {

    @BeforeClass
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.baseUrl = getInstance().getProperty("base.url");
    }

}
