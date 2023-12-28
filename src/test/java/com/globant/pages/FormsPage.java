package com.globant.pages;

import com.globant.utils.basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsPage extends BasePage {
    @AndroidFindBy(uiAutomator = ".text(\"Form components\")")
    private WebElement titleFormsPage;

    public FormsPage(AndroidDriver driver) {
        super(driver);
    }

    public void navigateToFormsPage() {
        WebElement element = this.getFormsIcon();
        waitForElementToBeVisible(element);
        tapElement(element);
        waitForElementToBeVisible(titleFormsPage);
    }
}
