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
            mensajesCuentaSuboptionButton = $(By.id("messages")),
            preferenciasCuentaSuboptionButton = $(By.xpath(".//*[@id='account-menu']//li[@data-name='preferences']/a")),
            inicioLink = $(By.id("nav-home")),
            cuentaSuboptions = $(By.xpath(".//*[@id='account-menu']/div[@class='drop-slide-wrapper']/ul")),
            oeLogo = $(By.xpath(".//*[@id='header']//a[@href='/index.html']")),
            progresoLink = $(By.id("nav-progress")),
            logOutLink = $(By.xpath(".//*[@id='account-menu']//a[@href='/j_spring_security_logout']")),
            ayudaDropDown = $(By.xpath(".//*[@id='nav-help']/strong")),
            contactenos = $(By.id("nav-talknow")),
            videosTutoriales = $(By.id("nav-howto")),
            verificaTuSistema = $(By.id("testYourSystem")),
            adobeConnectGuiaRapida = $(By.id("adobeQuickGuide")),
            verifiqueSuConfiguracion = $(By.id("testSetupLink")),
            preguntasFrecuentes = $(By.xpath(".//*[@id='header']//a[@href='/support/faq.html']")),
            videoClickPlay = $(By.xpath(".//*[@id='video-popup']/div[2]/div[2]")),
            videoClickClose = $(By.xpath(".//*[@class='ui-dialog-titlebar-close ui-corner-all']")),
            cursoButton = $(By.id("nav-learn")),
            clasesEnVivoButton = $(By.id("nav-liveclasses")),
            unidadesYLeccionesButton = $(By.id("nav-lessons")),
            practicaLink = $(By.id("nav-immersion")),
            introdussionLink =  $(By.id("nav-levelzero"));

}
