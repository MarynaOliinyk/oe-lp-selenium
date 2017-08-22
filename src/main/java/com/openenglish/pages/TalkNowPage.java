package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class TalkNowPage {
    public String contracenosContent = ".//*[@id='main']//div[@class='grid_3 user push_";
    private SelenideElement headerText = $(By.xpath(".//*[@class='push_1 page-title']/h2")),
            asesorText = $(By.xpath(String.format(contracenosContent + "2']//strong"))),
            profesorText = $(By.xpath(String.format(contracenosContent + "4']//strong"))),
            asesorImg = $(By.xpath(String.format(contracenosContent + "2']//img[1]"))),
            asesorImgHoverText = $(By.xpath(String.format(contracenosContent + "2']//span"))),
            profesorImg = $(By.xpath(String.format(contracenosContent + "4']//img[1]"))),
            profesorImgHoverText = $(By.xpath(String.format(contracenosContent + "4']//span"))),
            liveagentOnlineButton = $(By.id("liveagent_button_online")),
            liveagentOfflineButton = $(By.id("liveagent_button_offline")),
            liveagentPhoneNumber = $(By.id("callNumber")),
            enviarUnaPreguntaLink = $(By.xpath(".//li[@class='submit-question']/a")),
            popupPreguntaTitle = $(By.xpath(".//*[@id='ask-a-teacher']//h3")),
            popupPreguntaInstructionsText = $(By.xpath(".//div[@class='instructions']")),
            popupPreguntaMessageBlock = $(By.id("storyText")),
            popupPreguntaEnviarButton = $(By.id("askTeacherPopupSubmit")),
            popupGraciasTitle = $(By.xpath(".//*[@id='alert']//h3")),
            popupGraciasMessageBlock = $(By.xpath(".//*[@id='alert']//div[@class='alert-txt']")),
            popupGraciasCerrarButton = $(By.xpath(".//*[@id='alert']//div[@class='alert-btn-holder']/a"));
}
