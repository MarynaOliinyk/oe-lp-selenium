package com.openenglish.curso.practica;

import com.codeborne.selenide.SelenideElement;
import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.ImmersionPage;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.History.HISTORY_BORRAR_TODO_TEXT;
import static com.openenglish.core.TestData.Immersion.IMMERSION_HEADER_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.pages.AbstractPage.scrollDown;
import static com.openenglish.pages.AbstractPage.scrollUp;
import static org.testng.Assert.assertTrue;

public class C36VerifyFiltersTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void categoryScenarioTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getPracticaLink().click();
        ImmersionPage immersionPage = new ImmersionPage();
        immersionPage.getHeaderText().shouldBe(visible, text(IMMERSION_HEADER_TEXT));

        scrollDown();
        immersionPage.getCategoryFilterSection().shouldBe(exist, visible);
        immersionPage.getTypeFilterSection().shouldBe(exist, visible);

        immersionPage.getCategoryFilterSection().click();

        List<SelenideElement> activeFiltersValuesList = immersionPage.getAllTheActiveFiltersValues();

        String firstSelectedFilter = activeFiltersValuesList.get(1).getText();
        String secondSelectedFilter = activeFiltersValuesList.get(2).getText();

        activeFiltersValuesList.get(1).click();
        activeFiltersValuesList.get(2).click();

        immersionPage.getHolderForSelectedFilters().shouldBe(exist).scrollTo();
        List<SelenideElement> selectedFiltersValuesList = immersionPage.getAllTheSelectedFiltersValues();
        assertTrue(selectedFiltersValuesList.stream().allMatch(element ->
                element.getText().equals(firstSelectedFilter) || element.getText().equals(secondSelectedFilter)));
        // TODO: Expected Result of Step 3 Category Scenario need to be update: "Videos of categories selected are displayed"

        immersionPage.getBorrarTodoButton().shouldBe(exist, visible, exactText(HISTORY_BORRAR_TODO_TEXT));
        immersionPage.getCategoryFilterSection().click();
        immersionPage.getAllTheActiveFiltersValues().forEach(element -> element.shouldBe(empty));
        List<SelenideElement> displayedVideoBlocksList = immersionPage.getAllTheSelectedFiltersValues();
        displayedVideoBlocksList.forEach(element -> element.shouldBe(exist, visible, not(empty)));
        scrollUp();
        selectedFiltersValuesList.get(0).click();
        List<SelenideElement> selectedFiltersValuesListAfterDeletingFirst = immersionPage.getAllTheSelectedFiltersValues();
        assertTrue(selectedFiltersValuesListAfterDeletingFirst.stream().allMatch(element ->
                element.getText().equals(secondSelectedFilter)));
        immersionPage.getBorrarTodoButton().click();
        List<SelenideElement> displayedVideoBlocksListAfterFilterDeleting = immersionPage.getAllTheSelectedFiltersValues();
        displayedVideoBlocksListAfterFilterDeleting.forEach(element -> element.shouldBe(exist, visible, not(empty)));
    }

    @Test
    public void typeScenarioTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getPracticaLink().click();
        ImmersionPage immersionPage = new ImmersionPage();
        immersionPage.getHeaderText().shouldBe(visible, text(IMMERSION_HEADER_TEXT));

        scrollDown();
        immersionPage.getCategoryFilterSection().shouldBe(exist, visible);
        immersionPage.getTypeFilterSection().shouldBe(exist, visible);

        immersionPage.getTypeFilterSection().click();

        List<SelenideElement> activeFiltersValuesList = immersionPage.getAllTheActiveFiltersValues();

        String firstSelectedFilter = activeFiltersValuesList.get(1).getText();
        String secondSelectedFilter = activeFiltersValuesList.get(2).getText();

        activeFiltersValuesList.get(1).click();
        activeFiltersValuesList.get(2).click();

        immersionPage.getHolderForSelectedFilters().shouldBe(exist).scrollTo();
        List<SelenideElement> selectedFiltersValuesList = immersionPage.getAllTheSelectedFiltersValues();
        assertTrue(selectedFiltersValuesList.stream().allMatch(element ->
                element.getText().equals(firstSelectedFilter) || element.getText().equals(secondSelectedFilter)));
        // TODO: Expected Result of Step 3 Typo Scenario need to be update: "Videos of categories selected are displayed"

        immersionPage.getBorrarTodoButton().shouldBe(exist, visible, exactText(HISTORY_BORRAR_TODO_TEXT));
        immersionPage.getTypeFilterSection().click();
        immersionPage.getAllTheActiveFiltersValues().forEach(element -> element.shouldBe(empty));
        List<SelenideElement> displayedVideoBlocksList = immersionPage.getAllTheDisplayedVideoBlocks();
        displayedVideoBlocksList.forEach(element -> element.shouldBe(exist, visible, not(empty)));
        scrollUp();
        selectedFiltersValuesList.get(0).click();
        List<SelenideElement> selectedFiltersValuesListAfterDeletingFirst = immersionPage.getAllTheSelectedFiltersValues();
        assertTrue(selectedFiltersValuesListAfterDeletingFirst.stream().allMatch(element ->
                element.getText().equals(secondSelectedFilter)));
        immersionPage.getBorrarTodoButton().click();
        List<SelenideElement> displayedVideoBlocksListAfterFilterDeleting = immersionPage.getAllTheDisplayedVideoBlocks();
        displayedVideoBlocksListAfterFilterDeleting.forEach(element -> element.shouldBe(exist, visible, not(empty)));
    }

}
