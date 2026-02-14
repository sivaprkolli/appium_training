package com.ad.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenApplication {

    @Test
    public void launchApp() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Google Pixel 8 Pro");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("16.0");
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setApp("/Users/shiva/Documents/appium_training/src/main/resources/NoBroker.apk");
        uiAutomator2Options.setAppPackage("com.nobroker.app");
        uiAutomator2Options.setAppWaitActivity("com.nobroker.app.activities.NBLauncherActivity");
        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"),uiAutomator2Options);
    }
}
