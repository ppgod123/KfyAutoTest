package com.fatester;

import com.sun.javafx.binding.StringFormatter;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestCase {
    public WebDriver webDriver;
    @BeforeClass
    public void Open_Browser(){
        Path p1=  Paths.get("src","drivers","chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",p1.toAbsolutePath().toString());
        //创建浏览器实例
        webDriver= new ChromeDriver();
        //隐式等待(全局设置)
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        //获取当前日期
        Calendar cal = Calendar.getInstance();
                 cal.add(Calendar.DATE,20);
                 String Day = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        System.out.println(cal.getTime());
        System.out.println("当前日期"+Day);
    }

    @AfterClass
    public void Close_Brower(){
        webDriver.quit();
    }
}
