package com.openenglish.login.fields_validation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;


public class C143VerifyRecordarMisDatosCheckTest extends TestBase {

    //TODO BUG LPTRIAGE-170
    @Test
    public void rememberEnteredDataTest() {
        positiveLogIn();
        logOut();
        loginPage.getEmail().shouldHave(value(email));
//        loginPage.getPassword().shouldHave(value(password));
    }

}
