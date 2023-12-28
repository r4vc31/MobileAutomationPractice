package com.globant.pages;

import com.globant.utils.basePage.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class LoginPage extends BasePage {
    @AndroidFindBy(uiAutomator = ".className(\"android.widget.TextView\").index(0).text(\"Login / Sign up Form\")")
    private WebElement titleLoginPage;
    @AndroidFindBy(uiAutomator = ".className(\"android.widget.TextView\").text(\"Sign up\")")
    private WebElement signUpOptionMenu;
    @AndroidFindBy(uiAutomator = ".className(\"android.widget.TextView\").text(\"Login\").index(0)")
    private WebElement loginOptionMenu;

    @AndroidFindBy(uiAutomator = ".description(\"button-SIGN UP\")")
    private WebElement signUpBtn;
    @AndroidFindBy(uiAutomator = ".description(\"button-LOGIN\")")
    private WebElement loginBtn;
    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailField;
    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordField;
    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement confirmPasswordField;
    @AndroidFindBy(uiAutomator = ".className(\"android.widget.TextView\").text(\"You successfully signed up!\")")
    private WebElement signUpPopUp;
    @AndroidFindBy(uiAutomator = ".resourceId(\"android:id/button1\")")
    private WebElement okBtn;
    @AndroidFindBy(uiAutomator = ".className(\"android.widget.TextView\").text(\"You are logged in!\")")
    private WebElement loginPopUp;

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage() {
        WebElement element = this.getLoginIcon();
        waitForElementToBeVisible(element);
        tapElement(element);
        waitForElementToBeVisible(titleLoginPage);
    }
    public void navigateToSignUpSection() {
        waitForElementToBeVisible(signUpOptionMenu);
        tapElement(signUpOptionMenu);
        waitForElementToBeVisible(signUpBtn);
    }

    public List<String> fillFormSignUp() {
        waitForElementToBeVisible(signUpOptionMenu);
        tapElement(signUpOptionMenu);
        waitForElementToBeVisible(signUpBtn);

        // Generate random email
        String randomEmail = generateEmail();
        // Generate random password
        String randomPassword = generatePassword();
        //Fill fields
        emailField.sendKeys(randomEmail);
        passwordField.sendKeys(randomPassword);
        confirmPasswordField.sendKeys(randomPassword);

        tapElement(signUpBtn);
        waitForElementToBeVisible(signUpPopUp);
        tapElement(okBtn);

        return Arrays.asList(randomEmail, randomPassword);
    }

    public void fillFormLogin() {
        //credentials
        List<String> credentials = fillFormSignUp();

        waitForElementToBeVisible(loginOptionMenu);
        tapElement(loginOptionMenu);
        waitForElementToBeVisible(loginBtn);

        //Fill fields
        emailField.sendKeys(credentials.get(0));
        passwordField.sendKeys(credentials.get(1));

        tapElement(loginBtn);
        waitForElementToBeVisible(loginBtn);
        tapElement(okBtn);
    }

    private String generateEmail() {
        return RandomStringUtils.randomAlphabetic(8) + "@test.com";
    }
    private String generatePassword() {
        return RandomStringUtils.randomAlphabetic(8);
    }
}
