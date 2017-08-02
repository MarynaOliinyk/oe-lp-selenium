package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

    private String registerSectionNotifications = ".//*[@id='%s']/following-sibling::div/span";
    private String mobileSection = "//input[@placeholder='%s']";
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
            tooltipWindowClose = $(By.xpath(".//*[@id='popmake-1005']/button")),
            startNowButton = $(By.id("submit-button")),
            iframe = $(By.xpath("//iframe")),
            mobileSectionOne = $(By.xpath(String.format(mobileSection, "XX"))),
            mobileSectionTwo = $(By.xpath(String.format(mobileSection, "XXX"))),
            mobileSectionThree = $(By.xpath(String.format(mobileSection, "XXXX"))),
            ageOptions = $(By.xpath(".//*[@id='isforme-radio']/label[1]")),
            ageRangeSelect = $(By.id("agerange-select")),
            thanksText = $(By.xpath("//h1[@class='page-title']"));

    public void bannerVisibility() {
        if (tooltipWindowClose.isDisplayed()) {
            tooltipWindowClose.click();
        }
    }

    public void fillAndSubmitRegistration(String firstName, String lastName, String email,
                                          String mobileSectionOne, String mobileSectionTwo,
                                          String mobileSectionThree, String age) {
        this.nombreField.val(firstName);
        this.appelidoField.val(lastName);
        this.correoElectronField.val(email);
        this.mobileSectionOne.should(visible).val(mobileSectionOne);
        this.mobileSectionTwo.should(visible).val(mobileSectionTwo);
        this.mobileSectionThree.should(visible).val(mobileSectionThree);
        ageOptions.click();
        ageRangeSelect.selectOptionByValue(age);
        startNowButton.click();
    }

}
