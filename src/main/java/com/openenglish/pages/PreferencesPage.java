package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Accessors(chain = true)
public class PreferencesPage {

    private String generalNotificationLocator = ".//*[@id='%s']/following-sibling::span",
            nombre = "firstName",
            apelido = "lastName",
            checkboxName = ".//div[@id='gender']//span[contains(text(),'%s')]";

    private SelenideElement miPerfilTab = $(By.xpath(".//*[@id='submenu']//li[@class='active']/a")),
            nombreField = $(By.id(nombre)),
            nombreFieldNotification = $(By.xpath(String.format(generalNotificationLocator, nombre))),
            apellidoField = $(By.id(apelido)),
            apellidoFieldNotification = $(By.xpath(String.format(generalNotificationLocator, apelido))),
            guardarCambiosButton = $(By.id("personal-info-save")),
            femeninoField = $(By.xpath(String.format(checkboxName, "femenino"))),
            femeninoCheckbox = $(By.id("female")),
            masculinoField = $(By.xpath(String.format(checkboxName, "masculino"))),
            masculinoCheckbox = $(By.id("male"));
}
