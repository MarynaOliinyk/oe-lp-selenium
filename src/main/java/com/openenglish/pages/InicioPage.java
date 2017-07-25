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
            oeLogo = $(By.xpath(".//*[@id='header']//a[@href='/index.html']")),
            logOutLink = $(By.xpath(".//*[@id='account-menu']//a[@href='/j_spring_security_logout']")),
            ayudaDropDown = $(By.xpath(".//*[@id='nav-help']/strong")),
            contactenos = $(By.id("nav-talknow")),
            videosTutoriales = $(By.id("nav-howto")),
            verificaTuSistema = $(By.id("testYourSystem")),
            adobeConnectGuiaRapida = $(By.id("adobeQuickGuide")),
            verifiqueSuConfiguracion = $(By.id("testSetupLink")),
            preguntasFrecuentes = $(By.xpath(".//*[@id='header']//a[@href='/support/faq.html']"));
}