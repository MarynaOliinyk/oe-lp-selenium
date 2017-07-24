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
            accountMenu = $(By.id("account-menu-nav")),
            inicioLink = $(By.id("nav-home")),
            progresoLink = $(By.id("nav-progress")),
            logOutLink = $(By.xpath(".//*[@id='account-menu']//a[@href='/j_spring_security_logout']")),
            oeLogo = $(By.xpath(".//*[@id='header']//a[@href='/index.html']"));
}
