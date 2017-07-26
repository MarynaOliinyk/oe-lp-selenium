package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import com.openenglish.core.TestBase;
import lombok.Getter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class TalkNowPage extends TestBase {

    @Getter
    private SelenideElement headerText = $(By.xpath(".//*[@class='push_1 page-title']/h2"));

}
