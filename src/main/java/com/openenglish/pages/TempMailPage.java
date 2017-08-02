package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class TempMail {
    private SelenideElement tempMail = $(By.id("mail")),
                            receivedMail = $(By.xpath(".//*[@class='title-subject']"));
}
