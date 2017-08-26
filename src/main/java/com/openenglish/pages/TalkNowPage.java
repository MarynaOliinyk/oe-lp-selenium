package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class TalkNowPage {

    public String contracenosContent = ".//*[@id='main']//div[@class='grid_3 user push_%s']",
            graciasMessageblock = ".//*[@id='alert']//div[@class='%s']",
            liveagent_button = "liveagent_button";

    private SelenideElement headerText = $(By.xpath(".//*[@class='push_1 page-title']/h2")),
            asesorText = $(By.xpath(String.format(contracenosContent, "2") + "//strong")),
            profesorText = $(By.xpath(String.format(contracenosContent, "4") + "//strong")),
            asesorImg = $(By.xpath(String.format(contracenosContent, "2") + "//img[1]")),
            asesorImgHoverText = $(By.xpath(String.format(contracenosContent, "2") + "//span")),
            profesorImg = $(By.xpath(String.format(contracenosContent, "4") + "//img[1]")),
            profesorImgHoverText = $(By.xpath(String.format(contracenosContent, "4") + "//span")),
            liveagentOnlineButton = $(By.id(liveagent_button + "_online")),
            liveagentOfflineButton = $(By.id(liveagent_button + "_offline")),
            liveagentPhoneNumber = $(By.id("callNumber")),
            enviarUnaPreguntaLink = $(By.xpath(".//li[@class='submit-question']/a")),
            popupPreguntaTitle = $(By.xpath(".//*[@id='ask-a-teacher']//h3")),
            popupPreguntaInstructionsText = $(By.xpath(".//div[@class='instructions']")),
            popupPreguntaMessageBlock = $(By.id("storyText")),
            popupPreguntaEnviarButton = $(By.id("askTeacherPopupSubmit")),
            popupGraciasTitle = $(By.xpath(".//*[@id='alert']//h3")),
            popupGraciasMessageBlock = $(By.xpath(String.format(graciasMessageblock, "alert-txt"))),
            popupGraciasCerrarButton = $(By.xpath(String.format(graciasMessageblock, "alert-btn-holder") + "/a"));
}
