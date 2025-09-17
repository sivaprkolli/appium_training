package com.ad.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleDriversDemo {
    WebDriver chromeDriver;
    WebDriver firefoxDriver;

    @BeforeTest
    public void launchBrowsers() {
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxDriver1 = new FirefoxOptions();
        chromeOptions.setBrowserVersion("140");
        chromeDriver = new ChromeDriver(chromeOptions);
        firefoxDriver = new FirefoxDriver();
    }

    @AfterTest
    public void killSession(){
        chromeDriver.quit();
        firefoxDriver.quit();
    }

    @Test
    public void switchingBrowsers(){
        chromeDriver.get("https://www.saucedemo.com/");
        firefoxDriver.get("https://www.salesforce.com/");
        chromeDriver.findElement(By.cssSelector("[placeholder=\"Username\"]")).sendKeys("Standard_user");

        firefoxDriver.findElement(By.cssSelector("#password")).sendKeys("Test@12345");
    }
}
