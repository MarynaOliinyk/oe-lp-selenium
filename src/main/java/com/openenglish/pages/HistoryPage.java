package com.openenglish.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

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

    public boolean isAllTheListContainsText(ElementsCollection elementsList, String textToCompare) {
        for (SelenideElement element : elementsList) {
            if (!element.getText().equals(textToCompare)) {
                return false;
            }
        }
        return true;
    }

}
