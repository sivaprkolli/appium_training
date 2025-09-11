package com.ad.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

public class ScrollAndSwipe {

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
    public void handleScrollingAndSwiping(){

        Dimension size = driver.manage().window().getSize();

        System.out.println("Height :: " + size.getHeight());
        System.out.println("Width :: " + size.getWidth());

        int startY = (int) (size.getHeight() * 0.90);
        int endY = (int) (size.getHeight() * 0.30);

        int x = size.getWidth()/2;

        System.out.println("startY, x :: " + x + ":: " + startY );
        System.out.println("endY, x :: " + x + ":: " + endY );


        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger1, 1);

        scroll.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
        scroll.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        scroll.addAction(finger1.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(), x, endY));
        scroll.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(scroll));




    }
}
