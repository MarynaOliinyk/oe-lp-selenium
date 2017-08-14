package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    @Getter
    private SelenideElement headerText = $(By.xpath(".//*[@class='title-bar']//h1")),
            levels = $(By.id("levels")),
            verElIndiceDelCursoLink = $(By.xpath(".//*[@class='more']")),
            profilePicture = $(By.xpath(".//*[@class='photo-block']")),
            infoBlock = $(By.xpath(".//*[@class='info']")),
            practiceProgress = $(By.id("practice-progress")),
            liveClassesProgress = $(By.id("live-class-progress")),
            unitsProgress = $(By.id("units-progress")),
            tomarPruabaDeNivelButton = $(By.xpath(".//*[@class='orange-btn take_test disabled']")),
            estadisticasHeaderText = $(By.xpath(".//*[@class='grid_2 prefix_1 alpha']/h2")),
            verPorMesButton = $(By.xpath(".//*[@class='byMonth active']")),
            verPorSemanaButton = $(By.xpath(".//*[@class='byWeek']")),
            mesTimeBlock = $(By.xpath(".//*[@class='time-block']")),
            prevArrowButton = $(By.xpath(".//*[@class='btn-link-prev']")),
            nextArrowButton = $(By.xpath(".//*[@class='btn-link-next ']")),
            itemList = $(By.xpath(".//*[@class='item-list']")),
            nivelActualColumn = $(By.xpath(".//*[@class='item-list']/li[1]//strong")),
            ultimoNivelCompletadoColumn = $(By.xpath(".//*[@class='item-list']/li[2]//strong")),
            pruebaDeNivelColumn = $(By.xpath(".//*[@class='item-list']/li[3]//strong")),
            ultimoIngresoColumn = $(By.xpath(".//*[@class='item-list']/li[4]//strong")),
            statisticsGraph = $(By.id("graph-wrapper")),
            pruebaDeNivelButton = $(By.id("opt-out")),
            certificatesCarousel = $(By.id("certificates-carousel")),
            messageOverActualCertificate = $(By.xpath(".//*[@class='slide-text-overlay always-on']/span")),
            prevButton = $(By.xpath(".//*[@class='carousel-prev-button']")),
            nextButton = $(By.xpath(".//*[@class='carousel-next-button']")),
            monthInEstradisticas = $(By.xpath(".//*[@class='month']")),
            popUpHeaderText = $(By.xpath(".//*[@id='optOutPopup']/div[1]/h3")),
            popUpInstuction = $(By.xpath(".//*[@id='optOutPopup']/div[2]/p")),
            closePopupButton = $(By.xpath(".//*[@class='black-btn closePopupButton']")),
            continuePopupButton = $(By.xpath(".//*[@class='orange-btn continuePopupButton']")),
            closeIcon = $(By.xpath(".//*[@class='ui-icon ui-icon-closethick']")),
            canvasGraph = $(By.tagName("canvas")),
            overSemanaText = $(By.xpath(".//*[@class='week']"));
}
