package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OpenenglishPage {

    @Getter
    private SelenideElement registerForm = $(By.id("leadForm")),
            nombreField = $(By.id("firstname-input")),
            comienzaAhoraButton = $(By.id("submit-button")),
            nombreFieldNotification = $(By.xpath(".//*[@id='leadForm']/div[1]/div[2]/div/span")),
            banerEscButton = $(By.xpath(".//*[@id='popmake-1005']/button"));


    public void bannerVisibility() {
        banerEscButton.should(visible).click();
    }

    public String randonNumbers(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String randCharacters(int charactersQuantity) {
        return RandomStringUtils.randomAlphabetic(charactersQuantity);
    }

}