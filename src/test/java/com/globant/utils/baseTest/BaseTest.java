package com.globant.utils.baseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class BaseTest {

    SoftAssert softAssert = new SoftAssert();

    protected AndroidDriver driver;

    Dotenv dotenv = Dotenv.load();

    public Logger log = Logger.getLogger(BaseTest.class);

    @BeforeClass
    public void setupBase() {
        DesiredCapabilities capabilities = this.enviromentSetup();

        // Instantiate the driver
        try {
            driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    private DesiredCapabilities enviromentSetup(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set up desired capabilities for your device and app
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dotenv.get("DEVICE_NAME"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, dotenv.get("PLATFORM_NAME"));

        capabilities.setCapability("appPackage", dotenv.get("APP_PACKAGE"));
        capabilities.setCapability("appActivity", dotenv.get("APP_ACTIVITY"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, dotenv.get("AUTOMATION_NAME"));

        //for the installation
        File apkFile = new File(Objects.requireNonNull(dotenv.get("APP")));
        String apkPath = apkFile.getAbsolutePath();
        capabilities.setCapability(MobileCapabilityType.APP, apkPath);

        log.info(capabilities);

        return capabilities;
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


