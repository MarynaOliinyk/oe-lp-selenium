package com.openenglish.login.restablecercontrasena;

import com.openenglish.core.TestBase;
import org.testng.annotations.Test;

public class C10VerifyResetPasswordEmailIsSentTest extends TestBase{

    @Test
    public void verifyResetPasswordEmailIsSentTest() {
       positiveLogIn();
       logOut();
    }
}
