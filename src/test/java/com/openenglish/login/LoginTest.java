package com.openenglish.login;

import com.openenglish.core.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends TestBase {

    @Test
    public void loginWithCorrectCredentialsTest(){
        open("/");
    }
}
