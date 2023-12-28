package com.globant.utils.basePage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Home")
    private WebElement homeIcon;
    @AndroidFindBy(accessibility = "Webview")
    private WebElement webViewIcon;
    @AndroidFindBy(accessibility = "Login")
    private WebElement loginIcon;
    @AndroidFindBy(accessibility = "Forms")
    private WebElement formsIcon;
    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipeIcon;
    @AndroidFindBy(accessibility = "Drag")
    private WebElement dragIcon;


    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Common methods for tapping elements (using TouchAction for reliability)
    public void tapElement(WebElement element) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(element)))
                .perform();
    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void swipeRight(WebElement element) {
        new Actions(driver)
                .moveToElement(element)
                .clickAndHold()
                .pause(500)
                .moveByOffset(-element.getSize().width/2, 0)
                .release()
                .perform();
    }


    public void swipeLeft(WebElement element) {
        new Actions(driver)
                .moveToElement(element)
                .clickAndHold()
                .pause(500)
                .moveByOffset(+element.getSize().width/2, 0)
                .release()
                .perform();
    }

    public WebElement getHomeIcon() {
        return homeIcon;
    }

    public WebElement getWebViewIcon() {
        return webViewIcon;
    }

    public WebElement getLoginIcon() {
        return loginIcon;
    }

    public WebElement getFormsIcon() {
        return formsIcon;
    }

    public WebElement getSwipeIcon() {
        return swipeIcon;
    }

    public WebElement getDragIcon() {
        return dragIcon;
    }
}




