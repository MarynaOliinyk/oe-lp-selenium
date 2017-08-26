package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class TestYourSystemPage {

    public String browserReqirementsfield = ".//*[@id='%s-requirements']/span",
            browserReqirements = ".//*[@id='browser-requirements']//dl";

    private SelenideElement headerText = $(By.xpath(".//*[@class='title-bar']//h1")),
            systemRequirements = $(By.xpath(String.format(browserReqirementsfield, "system"))),
            browserRequirements = $(By.xpath(String.format(browserReqirementsfield, "browser"))),
            otherRequirements = $(By.xpath(String.format(browserReqirementsfield, "other"))),
            verificarTuSistemaButton = $(By.id("test-button")),
            browserReqirementsInput = $(By.xpath(browserReqirements + "//input")),
            allRequirementsForBrowser = $(By.xpath(browserReqirements + "/dd")),
            windowsLinkOnOtros = $(By.xpath(".//*[@data-device='pc']")),
            popUpConfiguration = $(By.xpath(".//*[@id='instructions']/div[2]/img")),
            closePopupButton = $(By.xpath(".//*[@class='ui-icon ui-icon-closethick']")),
            verificacionDeEquipoLinkOnOtros = $(By.id("checkEquipment")),
            macLinkOnOtros = $(By.xpath(".//*[@data-device='mac']"));
}
