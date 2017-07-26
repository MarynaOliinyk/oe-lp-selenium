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
                            logOutLink = $(By.xpath(".//*[@id='account-menu']//a[@href='/j_spring_security_logout']")),
                            videoClickPlay = $(By.xpath(".//*[@id='video-popup']/div[2]/div[2]")),
                            videoClickClose = $(By.xpath(".//*[@class='ui-dialog-titlebar-close ui-corner-all']")),
                            cursoButton = $(By.id("nav-learn")),
                            clasesEnVivoButton = $(By.id("nav-liveclasses")),
                            unidadesYLeccionesButton = $(By.id("nav-lessons")),
                            oeLogo = $(By.xpath(".//*[@id='header']//a[@href='/index.html']")),
                            practicaLink = $(By.id("nav-immersion")),
                            progresoLink = $(By.id("nav-progress")),
                            introdussionLink =  $(By.id("nav-levelzero")),
                            miProgressoLink = $(By.id("nav-profile"));


}
