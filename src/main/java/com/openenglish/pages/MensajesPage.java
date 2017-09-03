package com.openenglish.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class MensajesPage {

    private String tablePath = ".//*[@id='table-holder']",
            tableFirstRow = tablePath + "//th[@class='col0%s']/a",
            tableFirstRowCell = ".//*[@id='table-holder']//td[1]/span[%s]",
            paginationPagesValues = "//span[@data-backbonepager='%s']",
            paginationSigns = "//a[@class='%s']";

    private SelenideElement pageTitle = $(By.xpath(".//div[@class='title-bar']//h1")),
            sinLeer = $(By.xpath(".//*[@id='status']//span[@class='unread']")),
            avisos = $(By.xpath(".//span[contains(text(),'Avisos')]")),
            totalPagesAmount = $(By.xpath(tablePath + "//span[@data-backbonepager='totalPages']")),
            fechaHoraColumnTitle = $(By.xpath(String.format(tableFirstRow, "1"))),
            enviadoPorColumnTitle = $(By.xpath(String.format(tableFirstRow, "2"))),
            avisoColumnTitle = $(By.xpath(tablePath + "//th[@class='col03']//strong")),
            enviadoPhoto = $(By.xpath(tablePath + "//img[@class='ico']")),
            enviadoUserName = $(By.xpath(tablePath + "//span[@class='user-name']")),
            avisoMessageTitle = $(By.xpath(tablePath + "//strong[@class='title']")),
            tableFirstRowFirstColumn = $(By.xpath(tablePath + "//td[1]")),
            tableFirstRowFirstColumnDate = $(By.xpath(String.format(tableFirstRow, "1"))),
            tableFirstRowFirstColumnTime = $(By.xpath(String.format(tableFirstRow, "2"))),
            tableFirstRowDeleteIcon = $(By.xpath(tablePath + "//a[@class='delete']")),
            popupBlock = $(By.id("notification")),
            popupCloseButton = $(By.xpath(".//a[@role='button']")),
            paginationBlock = $(By.xpath(tablePath + "//div[@class='page']")),
            paginationCurrentPageValue = $(By.xpath(tablePath + String.format(paginationPagesValues, "currentPage"))),
            paginationTotalPagesValue = $(By.xpath(tablePath + String.format(paginationPagesValues, "totalPages"))),
            paginationPreviusPage = $(By.xpath(tablePath + String.format(paginationSigns, "prev"))),
            paginationNextPage = $(By.xpath(tablePath + String.format(paginationSigns, "next")));

    private ElementsCollection allTheMessagesOnThePage = $$(By.xpath(tablePath + "//tbody//tr"));

}
