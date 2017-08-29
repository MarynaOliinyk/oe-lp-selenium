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
            email = "email",
            confirmEmail = "confirmEmail",
            contrasena = "newPassword",
            confirmaContrasena = "newPasswordCheck",
            checkboxName = ".//div[@id='gender']//span[contains(text(),'%s')]";

    private SelenideElement miPerfilTabActive = $(By.xpath(".//*[@class='active']/a")),
            prefilDeAprendizajeTab = $(By.xpath(".//*[@id='submenu']/nav/ul/li[1]/a")),
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
            confirmaContrasenaField = $(By.id(confirmaContrasena)),
            confirmaContrasenaFieldNotification = $(By.xpath(String.format(generalNotificationLocator, confirmaContrasena))),
            guardarCambiosButton = $(By.id("personal-info-save")),
            photoFrame = $(By.xpath(".//*[@class='photo-frame']")),
            cambiarFotoText = $(By.xpath(".//*[@class='orange-text']")),
            nombrePlaceholder = $(By.xpath(".//*[@for='firstName']")),
            userNameAndHolaText = $(By.xpath(".//*[@class='student-greeting']/h3")),
            femeninoField = $(By.xpath(String.format(checkboxName, "femenino"))),
            femeninoCheckbox = $(By.id("female")),
            masculinoField = $(By.xpath(String.format(checkboxName, "masculino"))),
            masculinoCheckbox = $(By.id("male")),
            fechaDeNacimientoField = $(By.id("dob-picker")),
            calendar = $(By.id("ui-datepicker-div")),
            firstAvailableDate = calendar.$(By.xpath("//a[@class='ui-state-default']"));
}
