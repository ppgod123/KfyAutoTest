package com.fatester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

/**
 * 操作层
 */
public class LoginMovies {
    public WebDriver driver;

    public LoginMovies(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String username,String password,String expected){
        LoginPage loginPage= new LoginPage(driver);
        driver.manage().window().maximize();
        loginPage.sendKeysUserName(username);
        loginPage.sendKeysPassWord(password);
        driver.findElement(loginPage.loginBtn).click();
        String msg= "";
        try {
            WebElement webElement =  new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(loginPage.errorMsg));
             msg = webElement.getText();
        }catch (Exception e){
             msg = "";
        }

        Assert.assertEquals(msg, expected);
    }

}
