package com.fatester.pages;

import org.openqa.selenium.*;

/**
 * @auther 冯爱军
 * 操作层代码实现（持久层）
 */
public class LoginPage {
   public WebDriver driver;
    //定位 用户名输入框
    public    By userNameInput = By.id("account");
    //定位 密码输入框
    public    By passWordInput = By.id("password");
    //定位 登录按钮
    public    By loginBtn = By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/button/span");
    //定位 提示错误信息
//    WebElement webElement =  new WebDriverWait(driver, Duration.ofSeconds(10))
//            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div/span[2]")));

    public    By errorMsg = By.xpath("/html/body/div[2]/div/div/div/div/div/span[2]");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * 用户名输入操作
     *
     * @param userName
     */
    public void sendKeysUserName(String userName) {
        driver.findElement(userNameInput).sendKeys(Keys.CONTROL,"a");
        driver.findElement(userNameInput).sendKeys(Keys.BACK_SPACE);
        driver.findElement(userNameInput).sendKeys(userName);
    }

    /**
     * 密码输入操作
     *
     * @param passWord
     */
    public void sendKeysPassWord(String passWord) {
        driver.findElement(passWordInput).sendKeys(Keys.CONTROL,"a");
        driver.findElement(passWordInput).sendKeys(Keys.BACK_SPACE);
        driver.findElement(passWordInput).sendKeys(passWord);
    }

}
