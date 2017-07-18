package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RecoveryPage {

    @Getter
    private SelenideElement requestFormTitle = $(By.xpath(".//*[@id='requestForm']/div/h3")),
                                       email = $(By.id("email")),
                                        chat = $(By.xpath(".//*[@id='login-support-offline']/a")),
                               returnToLogin = $(By.xpath(".//*[@id='login2-return']/strong")),
                                         faq = $(By.id("read-faq")),
                                      singUp = $(By.id("sign-up")),
                                   submit = $(By.id("recovery-submit")),
                                 tooltipText = $(By.xpath(".//div[@class='tooltipster-content']"));

}
