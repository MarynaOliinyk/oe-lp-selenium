package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import com.openenglish.core.TestBase;
import lombok.Getter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class TestYourSystemPage {

    @Getter
    private SelenideElement headerText = $(By.xpath(".//*[@id='system-test']/div/h3"));
}
