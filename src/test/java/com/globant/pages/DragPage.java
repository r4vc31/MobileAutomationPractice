package com.globant.pages;

import com.globant.utils.basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragPage extends BasePage {
    @AndroidFindBy(uiAutomator = ".text(\"Drag and Drop\")")
    private WebElement titleDragPage;

    public DragPage(AndroidDriver driver) {
        super(driver);
    }

    public void navigateToDragPage() {
        WebElement element = this.getDragIcon();
        waitForElementToBeVisible(element);
        tapElement(element);
        waitForElementToBeVisible(titleDragPage);
    }
}
