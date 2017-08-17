package com.openenglish.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ImmersionPage {

    private String allTheDisplayedVideoBlocksCommonPath = ".//*[@id='immersionResultsTable']//ul[@class='post-list']//li";

    @Getter
    private SelenideElement headerText = $(By.xpath(".//*[@class='title-bar']//h1")),
            categoryFilterSection = $(By.xpath(".//*[@id='immersionRefinements']//span[contains(text(), 'Category')]")),
            typeFilterSection = $(By.xpath(".//*[@id='immersionRefinements']//span[contains(text(), 'Type')]")),
            holderForSelectedFilters = $(By.xpath(".//*[@id='immersionRefinements']//div[@class='holder']")),
            borrarTodoButton = $(By.xpath(".//*[@id='immersionRefinements']//a[@class='all']"));
    @Getter
    private ElementsCollection allTheActiveFiltersValues = $$(By.xpath(".//*[@id='immersionRefinements']//li[@class='open-close active']//li/a")),
            allTheSelectedFiltersValues = $$(By.xpath(".//*[@id='immersionRefinements']//div[@class='tag-box']//span")),
            allTheDisplayedVideoBlocks = $$(By.xpath(allTheDisplayedVideoBlocksCommonPath)),
            allTheDisplayedVideoTitles = $$(By.xpath(allTheDisplayedVideoBlocksCommonPath + "//h2//a")),
            allTheDisplayedVideoDescriptions = $$(By.xpath(allTheDisplayedVideoBlocksCommonPath + "//div[@class='description ellipsis']"));

}
