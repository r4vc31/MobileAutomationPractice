package com.globant.tests;

import com.globant.pages.*;
import com.globant.utils.baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    private HomePage homePage;
    private WebViewPage webViewPage;
    private LoginPage loginPage;
    private FormsPage formsPage;
    private SwipePage swipePage;
    private DragPage dragPage;

    @BeforeClass
    public void setUp() {
        homePage = new HomePage(driver);
        webViewPage = new WebViewPage(driver);
        loginPage = new LoginPage(driver);
        formsPage = new FormsPage(driver);
        swipePage = new SwipePage(driver);
        dragPage = new DragPage(driver);
    }

    @Test
    public void navigationTest() {
        homePage.navigateToHomePage();
        webViewPage.navigateToWebViewPage();
        loginPage.navigateToLoginPage();
        formsPage.navigateToFormsPage();
        swipePage.navigateToSwipePage();
        dragPage.navigateToDragPage();
    }

    // ... other test methods for navigation scenarios
}

