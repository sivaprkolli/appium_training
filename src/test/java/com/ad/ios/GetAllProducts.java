package com.ad.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetAllProducts {
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
    public void verifyProductsOnTheHomePage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[$value == 'Username'$]")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[$value == 'Username'$]")).sendKeys("standard_user");

        driver.findElement(AppiumBy.iOSNsPredicateString("name ='test-Password'")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("name ='test-Password'")).sendKeys("secret_sauce");

        driver.findElement(AppiumBy.name("test-LOGIN")).click();

        List<WebElement> products = driver.findElements(AppiumBy.iOSNsPredicateString("name == 'test-Item title'"));

        System.out.println(products.size());
        List<String> actualProductNames = new ArrayList<>();
        for (int i=0; i< products.size(); i++){
            String product = products.get(i).getText();
            actualProductNames.add(product);
        }

        System.out.println(actualProductNames);


        scrollToBottom();
        System.out.println("Test");

        scrollToTop();
    }


    public void scrollToBottom(){
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

    public void scrollToTop(){
        Dimension size = driver.manage().window().getSize();

        System.out.println("Height :: " + size.getHeight());
        System.out.println("Width :: " + size.getWidth());

        int startY = (int) (size.getHeight() * 0.20);
        int endY = (int) (size.getHeight() * 0.70);

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
