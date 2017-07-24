package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

    private String registerSectionNotifications = ".//*[@id='%s']/following-sibling::div/span";

    @Getter
    private SelenideElement registerForm = $(By.id("leadForm")),
            nombreField = $(By.id("firstname-input")),
            appelidoField = $(By.id("lastname-input")),
            correoElectronField = $(By.id("emailaddress-input")),
            comienzaAhoraButton = $(By.id("submit-button")),
            nombreFieldNotification = $(By.xpath(String.format(registerSectionNotifications, "firstname-input"))),
            appelidoFieldNotification = $(By.xpath(String.format(registerSectionNotifications, "lastname-input"))),
            correoElectronFieldNotification = $(By.xpath(String.format(registerSectionNotifications, "emailaddress-input"))),
            popUpIdentifier = $(By.xpath("//iframe")),
            tooltipWindowClose = $(By.xpath(".//*[@id='popmake-1005']/button"));

    public void bannerVisibility() {
        if (tooltipWindowClose.isDisplayed()) tooltipWindowClose.click();
    }

}
