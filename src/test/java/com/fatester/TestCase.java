package com.fatester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestCase {
    public WebDriver webDriver;
    @BeforeClass
    public void Open_Browser(){
        Path p1=  Paths.get("src","drivers","chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",p1.toAbsolutePath().toString());
        //创建浏览器实例
        webDriver= new ChromeDriver();
    }
    @Test
    public void openBaidu() throws InterruptedException {
       webDriver.manage().window().maximize();
       webDriver.get("https://www.baidu.com");
       webDriver.findElement(By.id("kw")).sendKeys("我爱一条柴");
       webDriver.findElement(By.id("su")).click();
       Thread.sleep(5000);
    }
    @Test
    public void testName() throws InterruptedException {
        webDriver.manage().window().maximize();
        webDriver.get("https://www.baidu.com");
        webDriver.findElement(By.name("wd")).sendKeys("我爱一条柴");
        webDriver.findElement(By.className("s_btn")).click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void Close_Brower(){
        webDriver.quit();
    }
}
