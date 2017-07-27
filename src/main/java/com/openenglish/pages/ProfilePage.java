package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    @Getter
    private SelenideElement headerText = $(By.xpath(".//*[@class='grid_3']/h1"));

}
