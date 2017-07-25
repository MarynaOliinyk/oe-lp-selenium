package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.value;


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
