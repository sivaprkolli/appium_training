package com.ad.android;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;

public class AppiumServerUsingProgram {


          public AppiumDriverLocalService service;
          public AppiumServiceBuilder serviceBuilder;

        @Test
        public void start_stop_server() throws InterruptedException {
            startServer();
            Thread.sleep(5000);
            stopServer();
        }

        public  void startServer() {
            service = new AppiumServiceBuilder()
                    .withIPAddress("127.0.0.1")
                    .usingPort(4723)
                    .build();

            service.start();
            System.out.println("Appium server started at :: " + service.getUrl());
        }

        public  void stopServer() {
            if (service != null) {
                service.stop();
                System.out.println("Appium server stopped");
            }
        }
    }

