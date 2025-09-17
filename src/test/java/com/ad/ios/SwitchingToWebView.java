package com.ad.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class SwitchingToWebView {


    IOSDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        XCUITestOptions xcuiTestOptions = new XCUITestOptions();
        xcuiTestOptions.setDeviceName("iPhone 16 Plus");
        xcuiTestOptions.setPlatformVersion("18.5");
        xcuiTestOptions.setPlatformName("iOS");
        xcuiTestOptions.setAutomationName("XCUITest");
        xcuiTestOptions.setApp(System.getProperty("user.dir")+ "/src/main/resources/UIKitCatalog.app");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), xcuiTestOptions);
    }

    @Test
    public void switchToWebView() throws InterruptedException {

        String nativeContext = driver.getContext();
        System.out.println("nativeContext :: " + nativeContext);
        driver.findElement(AppiumBy.accessibilityId("Web View")).click();

        Set<String> contexts = driver.getContextHandles();
        System.out.println(contexts);

        Thread.sleep(5000);
        for (String context: contexts){
            if (context.contains("WEBVIEW")){
                Thread.sleep(5000);
                driver.context(context);
            }

        }

        WebElement message = driver.findElement(By.cssSelector("body > h1"));
        System.out.println(message.getText());

    }
}
