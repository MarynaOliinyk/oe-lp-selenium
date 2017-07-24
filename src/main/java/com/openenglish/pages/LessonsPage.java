package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LessonsPage {

    @Getter
    private SelenideElement lessonTitle = $(By.id("lesson-title")),
                            beginLessonButton = $(By.xpath(".//*[@class='continue']"));
}
