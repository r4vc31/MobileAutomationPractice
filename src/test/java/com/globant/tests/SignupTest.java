package com.globant.tests;

import com.globant.pages.*;
import com.globant.utils.basePage.BasePage;
import com.globant.utils.baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void signUpTest() {
        loginPage.navigateToLoginPage();
        loginPage.fillFormSignUp();
    }
}
