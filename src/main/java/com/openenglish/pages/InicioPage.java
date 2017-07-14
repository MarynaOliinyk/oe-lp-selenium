package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Accessors(chain = true)
public class InicioPage {
    @Getter
    private SelenideElement userName = $(By.xpath(".//*[@id='student-info']//div[@class='display-name']")),
                          inicioLink = $(By.id("nav-home")),
                       accountButton = $(By.id("account-menu-nav")),
                            exitLink = $(By.xpath(".//*[@id='account-menu']/div/ul/li[3]/a"));

}
