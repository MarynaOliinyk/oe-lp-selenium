package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class TeacherFeedbackPage {
    private SelenideElement headerText = $(By.xpath(".//*[@class='title-bar']/div/h1")),
            verElIndiceDelCursoLink = $(By.cssSelector(".more")),
            fechaColumn = $(By.xpath(".//*[@class='date']")),
            sugerenciaSolicitadaColumn = $(By.xpath(".//*[@class='feedback']")),
            respuestaDelProfesorColumn = $(By.xpath(".//*[@class='response']")),
            paginador = $(By.xpath(".//*[@class='paging2']")),
            dayAndDateOfMessage = $(By.xpath(".//*[@id='feedback']/tbody/tr[1]/td[1]/span")),
            subjectOfSentQuestion = $(By.xpath(".//*[@class='action']/div[@class='ellipsis-wrapper']")),
            teachersProfilePicture = $(By.xpath("//*[@class='mask']")),
            teachersName = $(By.xpath(".//*[@class='frame']/h4")),
            teachersMessage = $(By.xpath(".//*[@class='action']/div//div[@class='ellipsis-wrapper']")),
            goodRateFace = $(By.xpath(".//*[@class='happy no-rated']")),
            badRateFace = $(By.xpath(".//*[@class='sad no-rated']")),
            titleOfSentQuestion = $(By.xpath(".//*[@class='action']/h3")),
            suggestionLink = $(By.xpath(".//*[@id='feedback']/tbody/tr")),
            popUp = $(By.xpath(".//*[@id='feed-back']")),
            popUpHeaderText = $(By.xpath(".//*[@class='heading']/h3")),
            popUpImage = $(By.xpath(".//*[@class='photo-frame']")),
            teachersResponseText = $(By.xpath(".//*[@class='teacherResponse']")),
            closePopUp = $(By.xpath(".//*[@class='ui-icon ui-icon-closethick']")),
            faceHappyNoRated = $(By.xpath(".//*[@class='happy no-rated']")),
            faceSadRatedDisabled = $(By.xpath(".//*[@class='sad rated disabled']")),
            popUpAfterSadFace = $(By.id("survey-popup")),
            popUpHeaderTextAfterSadFace = $(By.xpath("//*[@id='survey-popup']/div/h3")),
            faceSadNoRated = $(By.xpath("//*[@class='sad no-rated']")),
            enviarButtonOnPopUpIsDisabled = $(By.xpath(".//*[@class='orange-btn submit-btn disabled']")),
            checkboxOnPopUp = $(By.xpath(".//*[@class='option']//*[@data-option='395']")),
            enviarButtonOnPopUpVisible = $(By.xpath(".//*[@class='orange-btn submit-btn']")),
            messageOnPopUpSaveSuccsess = $(By.xpath(".//*[@class='message saveSuccess']")),
            exitButtonOnPopUp = $(By.xpath(".//*[@class='orange-btn exit-btn']"));



}

