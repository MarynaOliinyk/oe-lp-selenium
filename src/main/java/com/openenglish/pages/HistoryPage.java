package com.openenglish.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class HistoryPage {

    private SelenideElement headerText = $(By.xpath(".//*[@class='page-heading']")),
            typeButton = $(By.xpath(".//*[@class='opener']")),
            typeList = $(By.xpath(".//*[@class='slide']/ul/li/a")),
            selectFirstType = $(By.xpath(".//*[@id='searchRefinements']//li[4]//a")),
            selectSecondType = $(By.xpath(".//*[@id='searchRefinements']//li[6]//a")),
            borrarTodoText = $(By.xpath(".//*[@class='all']")),
            selectedTypeInList = $(By.xpath(".//*[@class='refinementSelected']")),
            deleteOneType = $(By.xpath(".//*[@id='searchRefinements']//a[2]/span")),

            refinementsIsDeleted = $(By.xpath(".//*[@class='delete']")),
            historyTable = $(By.xpath(".//*[@id='twocolumns']/div[2]"));

    private ElementsCollection selectedTypeList = $$(By.xpath(".//*[@class='delete']")),
            selectedTypeInHistory = $$(By.xpath(".//*[@id='table-holder']//tr/td[2]/div"));

}
