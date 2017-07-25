package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;

@Accessors(chain = true)
public class InicioPage {
    @Getter
    private SelenideElement userInfoElement = $(By.xpath(".//*[@id='student-info']//div[@class='student-level']")),
            userName = $(By.xpath(".//*[@id='student-info']//div[@class='display-name']")),
            userPhoto = $(By.xpath(".//*[@id='student-info']//div[@class='photo-frame']")),
            accountMenu = $(By.id("account-menu-nav")),
            mensajesCuentaSuboptionButton = $(By.id("messages")),
            preferenciasCuentaSuboptionButton = $(By.xpath(".//*[@id='account-menu']//li[@data-name='preferences']/a")),
            inicioLink = $(By.id("nav-home")),
            progresoLink = $(By.id("nav-progress")),
            cuentaSuboptions = $(By.xpath(".//*[@id='account-menu']/div[@class='drop-slide-wrapper']/ul")),
            headingElement = $(By.id("student-info")),
            planDeEstudioElement= $(By.xpath(".//*[@id='student-info']//div[@class='grid_6']//div")),
            planDeEstudioText= $(By.xpath(".//*[@id='student-info']//div[@class='grid_6']//span")),
            logOutLink = $(By.xpath(".//*[@id='account-menu']//a[@href='/j_spring_security_logout']")),
            oeLogo = $(By.xpath(".//*[@id='header']//a[@href='/index.html']")),
            videoBlock = $(By.id("main")),
            carouselVideoBlock = $(By.xpath(".//*[@id='main']//div[@class='carousel']")),
            lessonVideoBlock = $(By.xpath(".//*[@id='main']//div[@class='lesson']"));

    @Getter
    private By practiceVideosBlocks = By.xpath(".//*[@id='main']//div[@data-show-video='overlay']");

}
