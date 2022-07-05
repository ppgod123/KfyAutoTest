package com.fatester.service;

import com.fatester.Dao.LoginMovies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 业务层
 */
public class TestPageObject {
    public String URL = "http://dfh-user-facade.test.kfy.xip.io/sso/login#/";
    public WebDriver driver;
    @BeforeClass
    public void Open_Kfy_Brower(){
//        Path p1=  Paths.get("src","drivers","chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver",p1.toAbsolutePath().toString());
        System.setProperty("webdriver.chrome.driver","D:\\KfyAutoTest\\src\\drivers\\chromedriver.exe");
        //创建浏览器实例
        driver= new ChromeDriver();
        driver.get(URL);
    }
    /**
     * 测试登录
     *
     */
    @Test
    public void testLogin() throws InterruptedException {
      LoginMovies loginMovies= new LoginMovies(driver);
        loginMovies.login("admin","aa66666","密码或账号不正确");
        loginMovies.login("admin","szzj123456","");
    }

    /**
     * 脱敏函数
     *
     */
    @Test
    public void testDesensitization(){
        System.out.println("脱敏管理");

    }
    @AfterClass
    public void Close_Kfy_Brower(){
        driver.quit();
    }
}
