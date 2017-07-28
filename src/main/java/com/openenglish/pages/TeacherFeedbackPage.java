package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TeacherFeedbackPage {

    @Getter
    private SelenideElement headerText = $(By.xpath(".//*[@class='grid_8']/div/h1")),
            verElIndiceDelCursoLink = $(By.cssSelector(".more")),//Ver el índice del curso .//*[@class='more']"))
            fechaColumn = $(By.xpath(".//*[@class='date']")),//Fecha
            sugerenciaSolicitadaColumn = $(By.xpath(".//*[@class='feedback']")),//Sugerencia Solicitada
            respuestaDelProfesorColumn = $(By.xpath(".//*[@class='response']")),//Respuesta del Profesor
            paginador = $(By.xpath(".//*[@class='paging2']")),//1/1
            dayAndDateOfMessage = $(By.xpath(".//*[@id='feedback']/tbody/tr[1]/td[1]/span")), //30/06
            subjectOfSentQuestion = $(By.xpath(".//*[@class='action']/div[@class='ellipsis-wrapper']")),
            teachersProfilePicture = $(By.xpath("//*[@class='mask']")),
            teachersName = $(By.xpath(".//*[@class='frame']/h4")),
            teachersMessage = $(By.xpath(".//*[@class='action']/div//div[@class='ellipsis-wrapper']")),
            goodRateFace = $(By.xpath(".//*[@class='happy no-rated']")),
            badRateFace = $(By.xpath(".//*[@class='sad no-rated']")),
            titleOfSentQuestion = $(By.xpath(".//*[@class='action']/h3"));

}

