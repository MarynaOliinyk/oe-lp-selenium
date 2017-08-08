package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    @Getter
    private SelenideElement headerText = $(By.xpath(".//*[@class='grid_3']/h1")),
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
            itemList = $(By.xpath(".//*[@class='item-list']")),
            nivelActualColumn = $(By.xpath(".//*[@class='item-list']/li[1]//strong")),
            ultimoNivelCompletadoColumn = $(By.xpath(".//*[@class='item-list']/li[2]//strong")),
            pruebaDeNivelColumn = $(By.xpath(".//*[@class='item-list']/li[3]//strong")),
            ultimoIngresoColumn = $(By.xpath(".//*[@class='item-list']/li[4]//strong")),
            statisticsGraph = $(By.id("graph-wrapper")),
            pruebaDeNivelButton = $(By.id("opt-out"));
}
