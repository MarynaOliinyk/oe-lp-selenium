package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class FAQsPage {
    private SelenideElement faqsText = $(By.xpath("//div[@class='faq-area']/h3"));

}
