package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class LessonsPage {

    private SelenideElement text = $(By.xpath(".//*[@class='instructions']")),
            nameOfThePage = $(By.xpath(".//*[@id='main-content']//div[@class='container']//h1")),
            reminderTab = $(By.xpath(".//div[@class='reminder']")),
            reminderTabTitle = $(By.xpath(".//*[@id='progressCheck']//strong[@class='title']")),
            reminderTabBody = $(By.id("msg")),
            reminderTabLessonsLink = $(By.id("indexLink")),
            reminderTabPracticaLink = $(By.id("immersionLink")),
            reminderTabLiveClassesLink = $(By.id("liveClassLink")),
            lessonIFrame = $(By.id("lesson")),
            lessonContentBlock = $(By.xpath(".//*[@class='learning-player-wrapper']")),
            lessonNameHeader = $(By.xpath(".//*[@class='title-slide']/hgroup/h1")),
            lessonContentHeader = $(By.xpath(".//div[@class='title-slide']//hgroup//h2")),
            beginLessonButton = $(By.xpath(".//button[@class='continue']")),
            lessonMenu = $(By.xpath(".//*[@id='content']//div[@class='row']")),
            lessonMenuTitle = $(By.xpath(".//*[@id='lesson-menu']//*[@id='lesson-title']")),
            lessonMenuProgress = $(By.id("progress")),
            lessonsFirstNotActiveLesson = $(By.xpath(".//*[@id='menu-area']//ul[@class='lesson-menu']//li[not(contains(@class, 'lessonActive'))]/a")),
            lessonMostrarMenu = $(By.xpath(".//*[@id='content']//div[@class='link-box']")),
            lessonOcultarMenu = $(By.xpath(".//*[@id='menu-area']//a[@class='hide-link']")),
            lessonGreaterThenElement = $(By.xpath(".//div[@class='slide-controls']/span[@class='next']")),
            continuarLeccionLink = $(By.xpath(".//*[@id='menu-area']//a[@class='resume-link']")),
            lessonsMenuHeader = $(By.xpath(".//*[@id='menu-area']//div[@class='menu-block']//h2")),
            askTeacherTabHeader = $(By.id("tab-askateacher-anchor")),
            askTeacherTabInstructions = $(By.xpath(".//*[@id='ask-a-teacher-content']//p[@class='instructions']")),
            askTeacherTabStoryBlock = $(By.id("storyText")),
            askTeacherTabSubmitButton = $(By.id("askTeacherSubmit")),
            enviarButton = $(By.id("askTeacherSubmit")),
            allertBlock = $(By.id("alert")),
            allertHeader = $(By.xpath(".//*[@id='alert']//div[@class='heading']//h3")),
            allertBody = $(By.xpath(".//*[@id='alert']//div[@class='alert-txt']")),
            allertCerrarButton = $(By.xpath(".//*[@id='alert']//div[@class='alert-btn-holder']//a")),
            myNotesTab = $(By.id("tab-notes-anchor")),
            myNotesTabWholeBlock = $(By.xpath(".//*[@id='tab-notes']//div[@class='text-block']")),
            myNotesTabTextInputBlock = $(By.xpath(".//*[@class='text-block']/textarea")),
            myNotesTabNotesListHeader = $(By.xpath(".//ul[@class='notes-list']//a")),
            myNotesTabGuardarNotaButton = $(By.xpath(".//a[@class='orange-btn btn-note disabled save']")),
            popUpLoLogroTitle = $(By.xpath(".//*[@id='congratulations']//div[@class='heading']//h3")),
            popUpLoLogroProfilePhoto = $(By.xpath(".//*[@id='congratulations']//div[@class='photo-frame']//img")),
            popUpLoLogroUserName = $(By.xpath(".//*[@id='congratulations']//div[@class='student-name']")),
            popUpLoLogroLessonName = $(By.xpath(".//*[@id='congratulations']//h3[@class='title']")),
            popUpLoLogroLessonDescription = $(By.xpath(".//*[@id='congratulations']//div[@class='text-block']//p")),
            popUpLoLogroCompartaSusLogros = $(By.xpath(".//*[@id='social-share']//div[@class='social-share']//h2")),
            popUpLoLogroTwitterLogo = $(By.xpath(".//*[@id='social-share']//a[@class='social-icon-button twitter']")),
            popUpLoLogroFacebookLogo = $(By.xpath(".//*[@id='social-share']//a[@class='social-icon-button facebook']")),
            popUpLoLogroGoogleLogo = $(By.xpath(".//*[@id='social-share']//a[@class='social-icon-button google']")),
            popUpLoLogroProximaLessonButton = $(By.xpath(".//*[@id='congratulations']//a[@class='orange-btn home']"));

    private By allTheLessonsFromOcultarMenu = By.xpath(".//*[@id='menu-area']//ul[@class='lesson-menu']//a");

}