package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OpenEnglishPage {

    @Getter
    private SelenideElement registerForm = $(By.id("leadForm")),
            nombreField = $(By.id("firstname-input")),
            appelidoField = $(By.id("lastname-input")),
            correoElectronField = $(By.id("emailaddress-input")),
            comienzaAhoraButton = $(By.id("submit-button")),
            nombreFieldNotification = $(By.xpath(".//*[@id='leadForm']/div[1]/div[2]/div/span")),
            appelidoFieldNotification = $(By.xpath(".//*[@id='leadForm']/div[1]/div[3]/div/span")),
            correoElectronFieldNotification = $(By.xpath(".//*[@id='leadForm']/div[1]/div[4]/div/span")),
            popUpIdentifier = $(By.xpath("//iframe")),
            banerEscButton = $(By.xpath(".//*[@id='popmake-1005']/button"));


    public void bannerVisibility() {
        if (banerEscButton.isDisplayed()) banerEscButton.click();
    }

}