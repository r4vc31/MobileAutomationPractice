package com.globant.tests;

import com.globant.pages.LoginPage;
import com.globant.utils.baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        loginPage.navigateToLoginPage();
        loginPage.fillFormLogin();
    }
}
