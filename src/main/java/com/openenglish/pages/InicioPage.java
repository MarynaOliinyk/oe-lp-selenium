package com.openenglish.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class InicioPage {
    private SelenideElement userInfoElement = $(By.xpath(".//*[@id='student-info']//div[@class='student-level']")),
            userName = $(By.xpath(".//*[@class='student-greeting']/h3/span")),
            userPhoto = $(By.xpath(".//*[@class='rounded-circle img-thumbnail']")),
            accountMenu = $(By.id("account-menu-nav")),
            mensajesCuentaSuboptionButton = $(By.id("messages")),
            preferenciasCuentaSuboptionButton = $(By.xpath(".//*[@class='dropdown-menu dropdown-menu-center']//a[text()='Preferencias']")),
            inicioLink = $(By.xpath(".//ul[@class='navbar-nav']//a[@class='nav-link']")),
            cuentaSuboptions = $(By.xpath(".//div[@class='support-links collapse']//li[2]//div[@class='dropdown-menu dropdown-menu-center']")),
            headingElement = $(By.id("student-info")),
            planDeEstudioElement = $(By.xpath(".//*[@id='student-info']//div[@class='grid_6']//div")),
            planDeEstudioText = $(By.xpath(".//*[@id='index-holder']/lp2-title-bar/div/div/h1")),
            logOutLinkElement = $(By.xpath(".//*[@id='index-holder']/.//a[@href='/j_spring_security_logout']")),
            ayudaDropDown = $(By.id("nav-help")),
            contactenos = $(By.id("nav-talknow")),
            videosTutoriales = $(By.id("nav-howto")),
            oeLogo = $(By.xpath(".//*[@class='navbar-brand']")),
            verificaTuSistema = $(By.id("testYourSystem")),
            adobeConnectGuiaRapida = $(By.id("adobeQuickGuide")),
            verifiqueSuConfiguracion = $(By.id("testSetupLink")),
            preguntasFrecuentes = $(By.xpath(".//*[@class='dropdown-menu dropdown-menu-center']//a[@href='/support/faq.html']")),
            videoClickPlay = $(By.xpath(".//*[@id='video-popup']/div[2]/div[2]")),
            videoClickClose = $(By.xpath(".//*[@class='ui-dialog-titlebar-close ui-corner-all']")),
            cursoButton = $(By.id("nav-learn")),
            clasesEnVivoButton = $(By.id("nav-liveclasses")),
            unidadesYLeccionesButton = $(By.id("nav-lessons")),
            practicaLink = $(By.id("nav-immersion")),
            progresoLink = $(By.xpath(".//*[@id='index-holder']/lp2-header/nav/div/div[2]/ul/li[2]/a")),
            introdussionLink = $(By.id("nav-levelzero")),
            miProgressoLink = $(By.id("nav-profile")),
            sugerenciasDelProfesorLink = $(By.id("nav-feedback")),
            registroLink = $(By.id("nav-history")),
            cuadernoDeNotasLink = $(By.id("nav-notebook")),
            videoBlock = $(By.id("main")),
            carouselVideoBlock = $(By.xpath(".//*[@id='main']//div[@class='carousel']")),
            lessonVideoBlock = $(By.xpath(".//*[@id='main']//div[@class='lesson']")),
            comenzarButtonVideoBlock = $(By.xpath(".//*[@id='main']//div[@class='lesson']")),
            greaterThenSign = $(By.xpath(".//*[@id='main']//a[@class='next']")),
            lessThenSign = $(By.xpath(".//*[@id='main']//div[@class='carousel']//a[@class='next']")),
            topicLiveClassVideo = $(By.xpath(".//*[@id='main']//div[@class='carousel']//h3")),
            topicPracticeVideo = $(By.xpath(".//*[@id='main']//div[@class='immersion']//h3")),
            topicLessonsVideo = $(By.xpath(".//*[@id='main']//div[@class='grid_3 block']//h3")),
            reloadPracticeVideoButton = $(By.xpath(".//*[@id='main']//div[@class='grid_3']//a[@class='close']")),
            reloadLessonsVideoButton = $(By.xpath(".//*[@id='main']/div[@class='grid_3 block']//a[@class='close']"));

    private String logOutLink = "a[href='/j_spring_security_logout']";

    private By practiceVideosBlocks = By.xpath(".//*[@id='main']//div[@data-show-video='overlay']"),
            videoBlocksContainer = By.xpath(".//*[@id='main']//div[@data-show-video='overlay']/following-sibling::div[contains(@class,'item')]"),
            allThePracticeVideoImgs = By.xpath(".//*[@class='block']//div[@data-show-video='overlay']//img"),
            allTheLessonsVideoImgs = By.xpath(".//*[@class='grid_3 block']//div[@class='lesson']//img"),
            allTheLiveClassesVideoImgs = By.xpath(".//*[@class='grid_6 block live-class']//div[@class='carousel']//img");

    public boolean verifyAtLeastOneElementTextIsEqual(ElementsCollection collection, String xPath, String textToSearch) {
        return collection.stream().anyMatch(element -> $(element).hover().$(byXpath(xPath)).getText().equalsIgnoreCase(textToSearch));
    }

    public boolean visibilityOfListElements(By paramsToSearch) {
        return $$(paramsToSearch).stream().allMatch(element -> element.is(exist) & element.is(visible));
    }

    public boolean stringsComparator(String constant, String toSplit) {
        String[] techString = toSplit.split("\\-");
        String[] wordsArr = techString[1].split(" ");
        for (String toCompare: wordsArr) {
            if (!constant.toLowerCase().contains(toCompare.toLowerCase())) return false;
        }
        return true;
    }

}
