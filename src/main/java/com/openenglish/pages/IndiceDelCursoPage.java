package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class IndiceDelCursoPage {

    private SelenideElement unitOneLevelOne = $(By.xpath(".//*[@id='courseIndexTable']//div[@class='column'][1]/ul/li[1]/div/a/strong"));

    private By allTheLessonsFromUnitOneLevelOne = By.xpath(".//*[@id='courseIndexTable']//li[@class='open-close active']//div[@class='slide']//a");

}
