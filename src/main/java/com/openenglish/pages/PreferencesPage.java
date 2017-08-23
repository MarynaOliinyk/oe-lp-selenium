package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Getter
@Accessors(chain = true)
public class PreferencesPage {
    private SelenideElement miPerfilTab = $(By.xpath(".//*[@id='submenu']//li[@class='active']/a"));
}
