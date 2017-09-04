package com.openenglish.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
@Accessors(chain = true)
public class PreferencesPage {

    private String generalNotificationLocator = ".//*[@id='%s']/following-sibling::span",
            nombre = "firstName",
            apelido = "lastName",
            leftPlaceHolderPersonalSection = ".//*[@class='grid_3 holder']/div[1]/div[%s]/%s",
            rightPlaceHolderPersonalSection = ".//*[@class='grid_5 suffix_1 holder right']/div/div[%s]/%s",
            leftPlaceHolderDeContactoSection = ".//*[@class='input-holder address left']/div[%s]/label",
            email = "email",
            confirmEmail = "confirmEmail",
            contrasena = "newPassword",
            confirmaContrasena = "newPasswordCheck",
            checkboxName = ".//div[@id='gender']//span[contains(text(),'%s')]",
            idiomaDePreferencia = ".//*[@id='pref-langSelectBoxItContainer']",
            aprendizajeTabSectionsLocator = ".//*[@id='section-holder']//div[@data-qg-id='%s']",
            savePrefIdText = "save-pref";

    private SelenideElement activeTab = $(By.xpath(".//*[@class='active']/a")),
            notActiveTab = $(By.xpath("//nav[@class='add-nav fourth']//li[not(contains(@class,'active'))]/a")),
            prefilDeAprendizajeTab = $(By.xpath(".//*[@id='submenu']//li[2]/a")),
            nombreField = $(By.id(nombre)),
            direccionFirstField = $(By.id("address1")),
            direccionSecondField = $(By.id("address2")),
            errorMessage = $(By.xpath(".//*[@class='field-error']")),
            nombreFieldNotification = $(By.xpath(String.format(generalNotificationLocator, nombre))),
            apellidoField = $(By.id(apelido)),
            apellidoFieldNotification = $(By.xpath(String.format(generalNotificationLocator, apelido))),
            emailField = $(By.id(email)),
            emailFieldNotification = $(By.xpath(String.format(generalNotificationLocator, email))),
            confirmEmailField = $(By.id(confirmEmail)),
            confirmEmailFieldNotification = $(By.xpath(String.format(generalNotificationLocator, confirmEmail))),
            contrasenaField = $(By.id(contrasena)),
            contrasenaFieldNotification = $(By.xpath(String.format(generalNotificationLocator, contrasena))),
            guardarCambiosButtonOnPersonalSection = $(By.id("personal-info-save")),
            guardarCambiosButtonOnContactoSection = $(By.id("info-button")),
            guardarCambiosButtonOnInteresesSection = $(By.id(savePrefIdText)),
            confirmaContrasenaField = $(By.id(confirmaContrasena)),
            confirmaContrasenaFieldNotification = $(By.xpath(String.format(generalNotificationLocator, confirmaContrasena))),
            photoFrame = $(By.xpath(".//*[@class='photo-frame']")),
            cambiarFotoText = $(By.xpath(".//*[@class='orange-text']")),
            nombrePlaceholder = $(By.xpath(String.format(leftPlaceHolderPersonalSection, "1", "label"))),
            apellidoPlaceholder = $(By.xpath(String.format(leftPlaceHolderPersonalSection, "2", "label"))),
            sexoPlaceholder = $(By.xpath(String.format(leftPlaceHolderPersonalSection, "3", "strong"))),
            fechaDeNacimientoPlaceholder = $(By.xpath(String.format(leftPlaceHolderPersonalSection, "4", "strong"))),
            nombreVisibleParaOtrosPlaceholder = $(By.xpath(String.format(leftPlaceHolderPersonalSection, "5", "strong"))),
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
            paisBrasilOnDropDown = $(By.xpath(".//*[@id='ui-id-3']/li/a")),
            paisDrobDownInput = $(By.xpath(".//*[@id='ph']/div[1]/div/div/span/input")),
            telefonoPrincipal = $(By.xpath(".//*[@id='primaryPhone']/div/label")),
            telefonoSecundario = $(By.xpath(".//*[@id='secondaryPhone']/div/label")),
            femeninoField = $(By.xpath(String.format(checkboxName, "femenino"))),
            estadoPlaceholder = $(By.xpath(".//*[@id='ph']/div[2]/div/label")),
            femeninoCheckbox = $(By.id("female")),
            masculinoField = $(By.xpath(String.format(checkboxName, "masculino"))),
            masculinoCheckbox = $(By.id("male")),
            fechaDeNacimientoField = $(By.id("dob-picker")),
            calendar = $(By.id("ui-datepicker-div")),
            firstAvailableDate = calendar.$(By.xpath("//a[@class='ui-state-default']")),
            idiomaDePreferenciaField = $(By.xpath(idiomaDePreferencia)),
            interestsContainer = $(By.xpath(".//*[@class='button-list']/li/a/span")),
            compromisosYMotivacionesSection = $(By.xpath(String.format(aprendizajeTabSectionsLocator, "210"))),
            compromisosYMotivacionesSectionHeader = compromisosYMotivacionesSection.find("h3"),
            compromisosYMotivacionesSectionGuardarCambiosButton = compromisosYMotivacionesSection.$(By.id(savePrefIdText)),
            generalSection = $(By.xpath(String.format(aprendizajeTabSectionsLocator, "211"))),
            generalSectionHeader = generalSection.find("h3"),
            generalSectionGuardarCambiosButton = generalSection.$(By.id(savePrefIdText)),
            telefonoPrincipalFirstField = $(By.id("phone_field-0")),
            telefonoPrincipalSecondField = $(By.id("phone_field-1")),
            codigoPostalField = $(By.id("postalCode")),
            codigoPostalErrorText = $(By.xpath(".//*[@id='contact-info1']/div[1]/div[3]/div/span"));

    private ElementsCollection allTheIdiomasList = $$(By.xpath(idiomaDePreferencia + "//a"));

}
