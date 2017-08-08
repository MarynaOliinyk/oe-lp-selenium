package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.openenglish.core.TestData.Lessons.REMINDER_BODY;
import static org.testng.Assert.assertTrue;
@Getter
public class LessonsPage {

    private SelenideElement text = $(By.xpath(".//*[@class='instructions']")),
            reminderTab = $(By.xpath(".//div[@class='reminder']")),
            reminderTabTitle = $(By.xpath(".//*[@id='progressCheck']//strong[@class='title']")),
            reminderTabBody = $(By.id("msg")),
            reminderTabLessonsLink = $(By.id("indexLink")),
            reminderTabPracticaLink = $(By.id("immersionLink")),
            reminderTabLiveClassesLink = $(By.id("liveClassLink")),
            lessonIFrame = $(By.id("lesson")),
            lessonContentBlock = $(By.xpath(".//*[@class='learning-player-wrapper']")),
            beginLessonButton = $(By.xpath(".//button[@class='continue']")),
            lessonMenu = $(By.xpath(".//*[@id='content']//div[@class='row']")),
            lessonMenuTitle = $(By.xpath(".//*[@id='lesson-menu']//*[@id='lesson-title']")),
            lessonMenuProgress = $(By.id("progress")),
            lessonMostrarMenu = $(By.xpath(".//*[@id='content']//div[@class='link-box']")),
            lessonOcultarMenu = $(By.xpath(".//*[@id='menu-area']//a[@class='hide-link']")),
            continuarLeccionLink = $(By.xpath(".//*[@id='menu-area']//a[@class='resume-link']")),
            lessonsMenuHeader = $(By.xpath(".//*[@id='menu-area']//div[@class='menu-block']//h2")),
            askTeacherTabHeader = $(By.id("tab-askateacher-anchor")),
            askTeacherTabInstructions = $(By.xpath(".//*[@id='ask-a-teacher-content']//p[@class='instructions']")),
            askTeacherTabStoryBlock = $(By.id("storyText")),
            askTeacherTabSubmitButton = $(By.id("askTeacherSubmit")),
            myNotesTabHeader = $(By.id("tab-notes-anchor")),
            myNotesTabTextBlock = $(By.xpath(".//*[@id='tab-notes']//div[@class='text-block']")),
            myNotesTabNotesListHeader = $(By.xpath(".//ul[@class='notes-list']//a")),
            myNotesTabGuardarNotaButton = $(By.xpath(".//a[@class='orange-btn btn-note disabled save']"));

    private By allTheLessonsFromOcultarMenu = By.xpath(".//*[@id='menu-area']//ul[@class='lesson-menu']//a");

}
