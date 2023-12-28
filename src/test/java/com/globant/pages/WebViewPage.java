package com.globant.pages;

import com.globant.utils.basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class WebViewPage extends BasePage {
    @AndroidFindBy(uiAutomator = ".className(\"android.widget.TextView\").index(1).textContains(\"browser\")")
    private WebElement titleWebViewPage;


    public WebViewPage(AndroidDriver driver) {
        super(driver);
    }

    public void navigateToWebViewPage() {
        WebElement element = this.getWebViewIcon();
        waitForElementToBeVisible(element);
        tapElement(element);
        waitForElementToBeVisible(titleWebViewPage);
    }
}
