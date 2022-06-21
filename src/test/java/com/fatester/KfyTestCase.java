package com.fatester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class KfyTestCase {
    public WebDriver webDriver;
    @BeforeClass
    public void Open_Kfy_Brower(){
        Path p1=  Paths.get("src","drivers","chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",p1.toAbsolutePath().toString());
        //创建浏览器实例
        webDriver= new ChromeDriver();
    }
    @Test(priority = 0)
    public void Op_login() throws InterruptedException, IOException {
        webDriver.manage().window().maximize();
        webDriver.get("http://dfh-user-facade.test.kfy.xip.io/sso/login#/");
        webDriver.findElement(By.id("account")).sendKeys("admin");
        webDriver.findElement(By.id("password")).sendKeys("szzj123456");
        //点击脱敏管理
        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/button/span")).click();
        //判断元素是否出现，必须所有符合条件的元素都加载出来，才通过
        WebElement webElement =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root-master\"]/section/aside/div/ul/li[6]")));
        webElement.click();
        //判断元素是否可见并且是enable可点击
        WebElement webElement1 =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root-master ul:nth-child(1) li:nth-child(6) li")));
        webElement1.click();
        //判断元素是否出现
        WebElement webElement2 =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root-master ul:nth-child(1) li:nth-child(6) li")));
        webElement2.click();
        Thread.sleep(3000);
        File f = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f,new File(""));


    }
    @Test(priority = 1)
    //数字越大优先级越低
    public void Op_TM() throws InterruptedException {

        webDriver.findElement(By.xpath("//*[@id=\"root-master\"]/section/aside/div/ul/li[6]/div/span/span/span[2]")).click();
        Thread.sleep(5000);

    }

    @AfterClass
    public void Close_Kfy_Brower(){
        webDriver.quit();
    }
}
