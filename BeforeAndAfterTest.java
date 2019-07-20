package com.cybertek.Test.Day8_TestNG_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http:/google.com");

    }
    @Test(priority = 1)
    public void test1(){
        Assert.assertTrue(driver.getTitle().contains("Google"));
    }

    @Test (priority = 0)
    public void test2(){
        Assert.assertTrue(driver.getTitle().contains("amazon"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
