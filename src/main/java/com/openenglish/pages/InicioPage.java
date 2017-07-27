package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class InicioPage {
    @Getter
    private SelenideElement userName = $(By.xpath(".//*[@id='student-info']//div[@class='display-name']")),
            accountMenu = $(By.id("account-menu-nav")),
            mensajesCuentaSuboptionButton = $(By.id("messages")),
            preferenciasCuentaSuboptionButton = $(By.xpath(".//*[@id='account-menu']//li[@data-name='preferences']/a")),
            inicioLink = $(By.id("nav-home")),
            cuentaSuboptions = $(By.xpath(".//*[@id='account-menu']/div[@class='drop-slide-wrapper']/ul")),
            logOutLinkElement = $(By.xpath(".//*[@id='account-menu']//a[@href='/j_spring_security_logout']")),
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
            progresoLink = $(By.id("nav-progress")),
            introdussionLink = $(By.id("nav-levelzero")),
            miProgressoLink = $(By.id("nav-profile")),
            sugerenciasDelProfesorLink = $(By.id("nav-feedback")),
            registroLink = $(By.id("nav-history")),
            cuadernoDeNotasLink = $(By.id("nav-notebook"));;
    public String logOutLink = "a[href='/j_spring_security_logout']";


}
