package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TalkNowPage {

    @Getter
    private SelenideElement headerText = $(By.xpath(".//*[@class='push_1 page-title']/h2")),
            asesorText = $(By.xpath(".//*[@id='main']//div[@class='grid_3 user push_2']//strong")),
            profesorText = $(By.xpath(".//*[@id='main']//div[@class='grid_3 user push_4']//strong")),
            asesorImg = $(By.xpath(".//*[@id='main']//div[@class='grid_3 user push_2']//img[1]")),
            asesorImgHoverText = $(By.xpath(".//*[@id='main']//div[@class='grid_3 user push_2']//span")),
            profesorImg = $(By.xpath(".//*[@id='main']//div[@class='grid_3 user push_4']//img[1]"));

}
