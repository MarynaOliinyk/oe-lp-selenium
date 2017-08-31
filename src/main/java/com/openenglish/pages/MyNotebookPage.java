package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class MyNotebookPage {
    private SelenideElement headerText = $(By.xpath(".//*[@class='title-bar']/div/h1")),
            verElIndiceDelCursoLink = $(By.cssSelector(".more")),
            dataMyNotebookTable = $(By.xpath(".//*[@data-my-notebook-table='wrapper']")),
            textIfNotNotes = $(By.xpath(".//*[@class='no-data']")),
            pagination = $(By.xpath(".//*[@class='my-notebook-paging paging2']")),
            notes = $(By.xpath(".//*[@class='table-holder']")),
            fechaColumn = $(By.xpath(".//*[@class='date']")),
            dateAndHourOfNoteCreationData = $(By.xpath(".//*[@class='noteDate']")),
            unitAndLessonColumn = $(By.xpath(".//*[@class='unitAndLesson']")),
            unitAndLessonNumberData = $(By.xpath(".//*[@class='noteUnitLesson']")),
            titleLessonColumn = $(By.xpath(".//*[@class='title']")),
            lessonTitleData = $(By.xpath(".//*[@class='noteLessonTitle']")),
            noteColumn = $(By.xpath(".//*[@class='description']")),
            noteDescription = $(By.xpath(".//*[@class='noteText']"));
}
