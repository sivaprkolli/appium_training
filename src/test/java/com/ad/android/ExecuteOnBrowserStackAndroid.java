package com.ad.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class ExecuteOnBrowserStackAndroid {
AndroidDriver androidDriver;
    @Test
    public void launchApp() throws MalformedURLException {

        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformVersion("13.0");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setDeviceName("Google Pixel 7");
        uiAutomator2Options.setApp("bs://a541ed3da00e225d46ddd68f57f09d4f10692ba5");
        uiAutomator2Options.setCapability("newCommandTimeout", 120);

        uiAutomator2Options.setCapability("project", "SauceDemo");
        uiAutomator2Options.setCapability("build", "SauceDemo Build V1.1");
        uiAutomator2Options.setCapability("name", "Login Test");

        androidDriver = new AndroidDriver(new URL("https://sivakolli_aIpA4i:8MZSbx6Y8RsspGzMTRsr@hub.browserstack.com/wd/hub"), uiAutomator2Options);

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        androidDriver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        androidDriver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        androidDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOGIN\"]")).click();

        androidDriver.quit();
    }
}
