package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RecoveryPage {

    @Getter
    private SelenideElement requestFormTitle = $(By.xpath(".//*[@id='requestForm']/div/h3")),
                                       email = $(By.id("email"));
}
