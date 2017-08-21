package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TalkNowPage {

    @Getter
    private SelenideElement headerText = $(By.xpath(".//*[@class='push_1 page-title']/h2")),
            asesorText = $(By.xpath(".//*[@id='main']//div[@class='grid_3 user push_2']//strong")),
            profesorText = $(By.xpath(".//*[@id='main']//div[@class='grid_3 user push_4']//strong")),
            asesorImg = $(By.xpath(".//*[@id='main']//div[@class='grid_3 user push_2']//img[1]")),
            asesorImgHoverText = $(By.xpath(".//*[@id='main']//div[@class='grid_3 user push_2']//span")),
            profesorImg = $(By.xpath(".//*[@id='main']//div[@class='grid_3 user push_4']//img[1]")),
            profesorImgHoverText = $(By.xpath(".//*[@id='main']//div[@class='grid_3 user push_4']//span")),
            enviarUnaPreguntaLink = $(By.xpath(".//li[@class='submit-question']/a")),
            popupPreguntaTitle = $(By.xpath(".//*[@id='ask-a-teacher']//h3")),
            popupPreguntaInstructionsText = $(By.xpath(".//div[@class='instructions']")),
            popupPreguntaMessageBlock = $(By.id("storyText")),
            popupPreguntaEnviarButton = $(By.id("askTeacherPopupSubmit")),
            popupGraciasTitle = $(By.xpath(".//*[@id='alert']//h3")),
            popupGraciasMessageBlock = $(By.xpath(".//*[@id='alert']//div[@class='alert-txt']")),
            popupGraciasCerrarButton = $(By.xpath(".//*[@id='alert']//div[@class='alert-btn-holder']/a"));

}
