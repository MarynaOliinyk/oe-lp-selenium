package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class TestYourSystemPage {

    private SelenideElement headerText = $(By.xpath(".//*[@class='title-bar']//h1")),
            systemRequirements = $(By.xpath(".//*[@id='system-requirements']/span")),
            browserRequirements = $(By.xpath(".//*[@id='browser-requirements']/span")),
            otherRequirements = $(By.xpath(".//*[@id='other-requirements']/span")),
            verificarTuSistemaButton = $(By.id("test-button")),
            windowsLinkOnOtros = $(By.xpath(".//*[@data-device='pc']")),
            popUpConfiguration = $(By.xpath(".//*[@id='instructions']/div[2]/img")),
            closePopupButton = $(By.xpath(".//*[@class='ui-icon ui-icon-closethick']")),
            verificacionDeEquipoLinkOnOtros = $(By.id("checkEquipment")),
            macLinkOnOtros = $(By.xpath(".//*[@data-device='mac']"));
    ;
}
