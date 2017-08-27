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
            leftPlaceHolderPersonalSection = ".//*[@class='grid_3 holder']/div[1]/div[%s]/%s",
            rightPlaceHolderPersonalSection = ".//*[@class='grid_5 suffix_1 holder right']/div/div[%s]/%s",
            leftPlaceHolderDeContactoSection = ".//*[@class='input-holder address left']/div[%s]/label";

    private SelenideElement miPerfilTabActive = $(By.xpath(".//*[@class='active']/a")),
            prefilDeAprendizajeTab = $(By.xpath(".//*[@id='submenu']/nav/ul/li[1]/a")),
            nombreField = $(By.id(nombre)),
            nombreFieldNotification = $(By.xpath(String.format(generalNotificationLocator, nombre))),
            apellidoField = $(By.id(apelido)),
            apellidoFieldNotification = $(By.xpath(String.format(generalNotificationLocator, apelido))),
            guardarCambiosButtonOnPersonalSection = $(By.id("personal-info-save")),
            guardarCambiosButtonOnContactoSection = $(By.id("info-button")),
            guardarCambiosButtonOnInteresesSection = $(By.id("save-pref")),
            photoFrame = $(By.xpath(".//*[@class='photo-frame']")),
            cambiarFotoText = $(By.xpath(".//*[@class='orange-text']")),
            nombrePlaceholder = $(By.xpath(String.format(leftPlaceHolderPersonalSection, "1", "label"))),
            apellidoPlaceholder = $(By.xpath(String.format(leftPlaceHolderPersonalSection, "2", "label"))),
            sexoPlaceholder = $(By.xpath(String.format(leftPlaceHolderPersonalSection, "3", "strong"))),
            fechaDeNacimientoPlaceholder = $(By.xpath(String.format(leftPlaceHolderPersonalSection, "4", "strong"))),
            nombreVisibleATodosPlaceholder = $(By.xpath(String.format(leftPlaceHolderPersonalSection, "5", "strong"))),
            nivelAcademicoPlaceholder = $(By.xpath(String.format(leftPlaceHolderPersonalSection, "6", "strong"))),
            emailPlaceholder = $(By.xpath(String.format(rightPlaceHolderPersonalSection, 1, "label"))),
            contrasenaPlaceholder = $(By.xpath(String.format(rightPlaceHolderPersonalSection, 3, "label"))),
            confirmarContrasenaPlaceholder = $(By.xpath(String.format(rightPlaceHolderPersonalSection, 4, "label"))),
            idiomaDePreferenciaPlaceholder = $(By.xpath(String.format(rightPlaceHolderPersonalSection, 5, "label"))),
            userNameAndHolaText = $(By.xpath(".//*[@class='student-greeting']/h3")),
            contactoSection = $(By.xpath(".//*[@id='content']/div[1]/div[2]/fieldset/div[2]")),
            direccionOnePlaceholder = $(By.xpath(String.format(leftPlaceHolderDeContactoSection, 1))),
            direccionTwoPlaceholder = $(By.xpath(String.format(leftPlaceHolderDeContactoSection, 2))),
            codidoPostalPlaseholder = $(By.xpath(String.format(leftPlaceHolderDeContactoSection, 3))),
            zonaHorariaPlaseholder = $(By.xpath(String.format(leftPlaceHolderDeContactoSection, 4))),
            fechaYHoraActualPlaseholder = $(By.xpath(String.format(leftPlaceHolderDeContactoSection, 5))),
            pais = $(By.xpath(".//*[@id='ph']/div[1]/div/label")),
            telefonoPrincipal = $(By.xpath(".//*[@id='primaryPhone']/div/label")),
            telefonoSecundario = $(By.xpath(".//*[@id='secondaryPhone']/div/label")),
            interestsContainer = $(By.xpath(".//*[@class='button-list']/li/a/span"));
}
