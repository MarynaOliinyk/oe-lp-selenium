package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FAQPage {

    @Getter
    private SelenideElement faqText =$(By.xpath("//div[@class='faq-area']/h3"));

}
