package com.globant.pages;

import com.globant.utils.basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    @AndroidFindBy(uiAutomator = ".textContains(\"Demo\")")
    private WebElement titleHomePage;

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        WebElement element = this.getHomeIcon();
        waitForElementToBeVisible(element);
        tapElement(element);
        waitForElementToBeVisible(titleHomePage);
    }


}


