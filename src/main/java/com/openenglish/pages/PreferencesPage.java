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
            leftPlaceHolder = ".//*[@class='grid_3 holder']/div[1]/div[%s]/%s",
            rightPlaceHolder = ".//*[@class='grid_5 suffix_1 holder right']/div/div[%s]/%s",
            email = "email",
            confirmEmail = "confirmEmail",
            contrasena = "newPassword",
            checkboxName = ".//div[@id='gender']//span[contains(text(),'%s')]";

    private SelenideElement miPerfilTabActive = $(By.xpath(".//*[@class='active']/a")),
            prefilDeAprendizajeTab = $(By.xpath(".//*[@id='submenu']//li[2]/a")),
            nombreField = $(By.id(nombre)),
            nombreFieldNotification = $(By.xpath(String.format(generalNotificationLocator, nombre))),
            apellidoField = $(By.id(apelido)),
            apellidoFieldNotification = $(By.xpath(String.format(generalNotificationLocator, apelido))),
            emailField = $(By.id(email)),
            emailFieldNotification = $(By.xpath(String.format(generalNotificationLocator, email))),
            confirmEmailField = $(By.id(confirmEmail)),
            confirmEmailFieldNotification = $(By.xpath(String.format(generalNotificationLocator, confirmEmail))),
            contrasenaField = $(By.id(contrasena)),
            contrasenaFieldNotification = $(By.xpath(String.format(generalNotificationLocator, contrasena))),
            guardarCambiosButton = $(By.id("personal-info-save")),
            photoFrame = $(By.xpath(".//*[@class='photo-frame']")),
            cambiarFotoText = $(By.xpath(".//*[@class='orange-text']")),
            nombrePlaceholder = $(By.xpath(String.format(leftPlaceHolder, "1", "label"))),
            apellidoPlaceholder = $(By.xpath(String.format(leftPlaceHolder, "2", "label"))),
            sexoPlaceholder = $(By.xpath(String.format(leftPlaceHolder, "3", "strong"))),
            fechaDeNacimientoPlaceholder = $(By.xpath(String.format(leftPlaceHolder, "4", "strong"))),
            nombreVisibleATodosPlaceholder = $(By.xpath(String.format(leftPlaceHolder, "5", "strong"))),
            nivelAcademicoPlaceholder = $(By.xpath(String.format(leftPlaceHolder, "6", "strong"))),
            emailPlaceholder = $(By.xpath(String.format(rightPlaceHolder, 1, "label"))),
            contrasenaPlaceholder = $(By.xpath(String.format(rightPlaceHolder, 3, "label"))),
            confirmarContrasenaPlaceholder = $(By.xpath(String.format(rightPlaceHolder, 4, "label"))),
            idiomaDePreferenciaPlaceholder = $(By.xpath(String.format(rightPlaceHolder, 5, "label"))),
            userNameAndHolaText = $(By.xpath(".//*[@class='student-greeting']/h3")),
            femeninoField = $(By.xpath(String.format(checkboxName, "femenino"))),
            femeninoCheckbox = $(By.id("female")),
            masculinoField = $(By.xpath(String.format(checkboxName, "masculino"))),
            masculinoCheckbox = $(By.id("male")),
            fechaDeNacimientoField = $(By.id("dob-picker")),
            calendar = $(By.id("ui-datepicker-div")),
            firstAvailableDate = calendar.$(By.xpath("//a[@class='ui-state-default']"));
}

