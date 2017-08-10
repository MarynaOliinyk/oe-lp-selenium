package com.openenglish.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class HistoryPage {

    private String table = ".//*[@id='table-holder']",
            tableHeaderLine = table + "//*[@class='historyTable']//th[@class='%s']",
            tipoTableEllements = table + "//div[@class='historyType']",
            tituloTableEllements = table + "//tr/td[3]";

    private SelenideElement headerBlock = $(By.xpath(".//*[@class='page-heading']")),
            headerRegistroDeActividadesText = $(By.xpath(".//*[@id='content']//div[@class='grid_8']//h1")),
            headerVerIndiceDelCursoLink = $(By.xpath(".//*[@id='content']//div[@class='grid_2']//a")),
            paginationBlock = $(By.xpath(table + "//div[@class='history-paging paging2']")),
            searchBlock = $(By.id("twocolumns")),
            refinementsBlock = $(By.xpath(".//*[@id='searchRefinements']//*[@class='refinements']")),
            typeButton = $(By.xpath(".//*[@class='opener']")),
            typeList = $(By.xpath(".//*[@class='slide']/ul/li/a")),
            firstPracticeType = $(By.xpath(".//*[@id='searchRefinements']//li[4]//a")),
            secondUnitAsessmentType = $(By.xpath(".//*[@id='searchRefinements']//li[6]//a")),
            borrarTodoText = $(By.xpath(".//*[@class='all']")),
            selectedTypeInList = $(By.xpath(".//*[@class='refinementSelected']")),
            deleteOneType = $(By.xpath(".//*[@id='searchRefinements']//a[2]/span")),
            refinementsIsDeleted = $(By.xpath(".//*[@class='delete']")),
            historyTable = $(By.xpath(".//*[@id=istoryPage.getT'twocolumns']/div[2]")),

    tableBlock = $(By.xpath(table + "//*[@class='historyTable']")),
            fechaHeaderCellText = $(By.xpath(String.format(tableHeaderLine, "date"))),
            tipoHeaderCellText = $(By.xpath(String.format(tableHeaderLine, "type"))),
            tituloHeaderCellText = $(By.xpath(String.format(tableHeaderLine, "title"))),
            descriptionHeaderCellText = $(By.xpath(String.format(tableHeaderLine, "description"))),
            resultsAndActionsHeaderCellText = $(By.xpath(table + "//th[last()]")),

    dayCompletedAllElements = $(By.xpath(table + "//div[@class='dateCompleted']")),
            timeCompletedAllElements = $(By.xpath(table + "//div[@class='timeCompleted smaller']")),
            tipoTableAllElements = $(By.xpath(tipoTableEllements)),
            tituloTableAllElements = $(By.xpath(tituloTableEllements)),
            descriptionTableAllElements = $(By.xpath(table + "//tr/td[4]")),
            resultsAndActionsTableAllElements = $(By.xpath(table + "//*[@data-action='replay']")),

    addTypeButton = $(By.xpath(".//*[@id='searchRefinements']//a[@class='opener']/span")),
            searchTypePractice = $(By.xpath(".//*[@id='searchRefinements']//a[text()='Practice']"));

    private ElementsCollection selectedTypeList = $$(By.xpath(".//*[@class='delete']")),
            selectedTypeInHistory = $$(By.xpath(".//*[@id='table-holder']//tr/td[2]/div"));

    public boolean isAllTheListContainsText(String elToSearch, String textToCompare) {
        return $$(By.xpath(elToSearch)).stream().allMatch(element -> element.hover().getText().equalsIgnoreCase(textToCompare));
    }

}
