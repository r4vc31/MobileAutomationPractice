package com.globant.tests;

import com.globant.pages.LoginPage;
import com.globant.pages.SwipePage;
import com.globant.utils.baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {
    private SwipePage swipePage;

    @BeforeClass
    public void setUp() {
        swipePage = new SwipePage(driver);
    }

    @Test
    public void swipeTest() {
        swipePage.navigateToSwipePage();
        swipePage.swipeCardsToRight();
        swipePage.swipeCardsToLeft();
    }
}
