package com.cybertek.Test.Day8_TestNG_Intro;

import com.cybertek.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class DropDownTests {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //    open website http://practice.cybertekschool.com/dropdown
//    verify default year is current 2019
//    verify default month is current July
//    verify default day is current 7
    @BeforeMethod
    public void setUp(){
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test1(){
        int expectedYear = 2019;
        String expectedMonth = "July";
        int expectedDay = 7;
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        int actualYear = Integer.parseInt(selectYear.getFirstSelectedOption().getText());
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        int actualDay = Integer.parseInt(selectDay.getFirstSelectedOption().getText());

        Assert.assertEquals(actualDay,expectedDay);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualYear, expectedYear);

    }
    @Test(priority = 3)
    public void openAmazonTest(){
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Amazon")).click();
        SeleniumUtils.waitPlease(2);
        String expectedURL = "https://www.amazon.com/";
        Set<String> windows = driver.getWindowHandles();
        for(String w: windows){
            if(!currentWindow.equals(w)){
                driver.switchTo().window(w);
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }







    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}