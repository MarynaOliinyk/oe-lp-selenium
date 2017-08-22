package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class TalkNowPage {
    public String contracenosContent = ".//*[@id='main']//div[@class='grid_3 user push_";
    private SelenideElement headerText = $(By.xpath(".//*[@class='push_1 page-title']/h2")),
            asesorText = $(By.xpath(String.format(contracenosContent + "2']//strong"))),
            profesorText = $(By.xpath(String.format(contracenosContent + "4']//strong"))),
            asesorImg = $(By.xpath(String.format(contracenosContent + "2']//img[1]"))),
            asesorImgHoverText = $(By.xpath(String.format(contracenosContent + "2']//span"))),
            profesorImg = $(By.xpath(String.format(contracenosContent + "4']//img[1]"))),
            profesorImgHoverText = $(By.xpath(String.format(contracenosContent + "4']//span")));
}
