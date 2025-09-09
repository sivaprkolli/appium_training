package com.ad.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginToApplication {

    IOSDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        XCUITestOptions xcuiTestOptions = new XCUITestOptions();
        xcuiTestOptions.setDeviceName("iPhone 16 Pro");
        xcuiTestOptions.setPlatformVersion("18.5");
        xcuiTestOptions.setPlatformName("iOS");
        xcuiTestOptions.setAutomationName("XCUITest");
        xcuiTestOptions.setApp(System.getProperty("user.dir")+ "/src/main/resources/SauceLabs.app");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), xcuiTestOptions);
    }

    @Test
    public void verifyLoginSuccess(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[$value == 'Username'$]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[$value == 'Username'$]")).sendKeys("standard_user");

        driver.findElement(AppiumBy.iOSNsPredicateString("name ='test-Password'")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("name ='test-Password'")).sendKeys("secret_sauce");

        driver.findElement(AppiumBy.name("test-LOGIN")).click();

        String productsTitle = driver.findElement(AppiumBy.iOSNsPredicateString("value == 'PRODUCTS'")).getText();

        Assert.assertEquals(productsTitle, "PRODUCTS");


    }
}
