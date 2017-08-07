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
            tomarPruabaDeNivelButton = $(By.xpath(".//*[@class='orange-btn take_test disabled']"));
}
