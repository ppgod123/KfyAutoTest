package com.fatester;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

public class SeleniumAction {
    //打开浏览器
    public WebDriver webDriver;
    @BeforeClass
    public void Open_Kfy_Brower(){
        Path p1=  Paths.get("src","drivers","chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",p1.toAbsolutePath().toString());
        //创建浏览器实例
        webDriver= new ChromeDriver();
    }
    //登录并切换至脱敏管理模块
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
    }
    @Test
    public String GetRuleName(){
        //获取当前日期
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,0);
        String Day = new SimpleDateFormat("yyyyMMddHHmmss").format(cal.getTime());
        String RuleName = "fa"+Day;
        return RuleName;
    }
    //新增MD5（32位）加密脱敏
    @Test(priority = 1)
    public void Add_MD5_32_Desensitization() throws InterruptedException {
         //切换至Hash脱敏函数模块
        WebElement Add_MD5_32_01 =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rc-tabs-0-tab-crypt\"]")));
        Add_MD5_32_01.click();
        //添加规则-确认添加规则按钮已加载
        WebElement Add_MD5_32_02  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rc-tabs-0-panel-crypt\"]/div/div[2]/div[1]/div/button/span")));
        Add_MD5_32_02.click();


        //System.out.println(GetRuleName());
        //System.out.println(webDriver.findElement(By.xpath("//*[@id=\"name\"]")).isEnabled());
        //webDriver.findElement(By.id("name")).sendKeys(GetRuleName());//脱敏规则名称
        WebElement Add_MD5_32_03  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[1]/div[2]/div/div/input")));
        Add_MD5_32_03.sendKeys(GetRuleName());
        //点击脱敏函数下拉框
        //webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[2]/div[2]/div/div/div")).click();
        WebElement Add_MD5_32_08  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[2]/div[2]/div/div/div")));
        Add_MD5_32_08.click();
        //判断下拉项是否可点击
        WebElement Add_MD5_32_04  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[1]/div")));
        Add_MD5_32_04.click();
        //脱敏测试
        WebElement Add_MD5_32_05  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"originalValue\"]")));
        Add_MD5_32_05.sendKeys(GetRuleName());
        //点击测试按钮
        WebElement Add_MD5_32_06  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[3]/form/div[1]/div[2]/div/div/div/button/span")));
        Add_MD5_32_06.click();
        Thread.sleep(2000);
        //确认添加按钮
        WebElement Add_MD5_32_07  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]/span")));
        Add_MD5_32_07.click();
        Thread.sleep(3000);
    }
    //编辑MD5（16位）加密脱敏
    @Test(priority = 2)
    public void Edit_MD5_32_Desensitization() throws InterruptedException {
        //切换至Hash脱敏函数模块
        WebElement Edit_MD5_32_01 =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rc-tabs-0-tab-crypt\"]")));
        Edit_MD5_32_01.click();
        //列表数据加载成功，点击新增数据编辑按钮
        WebElement Edit_MD5_32_02  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rc-tabs-0-panel-crypt\"]/div/div[2]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[7]/a[2]")));
        Edit_MD5_32_02.click();

        System.out.println(GetRuleName());
        //webDriver.findElement(By.id("name")).sendKeys(GetRuleName());//脱敏规则名称
        WebElement Edit_MD5_32_03  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[1]/div[2]/div/div/input")));
        //清理旧规则名称，添加新规则
        Edit_MD5_32_03.sendKeys(Keys.CONTROL,"a");
        Edit_MD5_32_03.sendKeys(Keys.BACK_SPACE);
        Edit_MD5_32_03.sendKeys(GetRuleName());

       // webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[2]/div[2]/div/div/div/div/span[2]")).click();
        WebElement Edit_MD5_32_04  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[2]/div[2]/div/div/div")));
        Edit_MD5_32_04.click();
        //判断下拉项是否可点击
        WebElement Edit_MD5_32_05  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div/div/div[2]/div[1]/div/div/div[2]/div")));
        Edit_MD5_32_05.click();
        //脱敏测试
        WebElement Edit_MD5_32_06  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"originalValue\"]")));
        Edit_MD5_32_06.sendKeys(Keys.CONTROL,"a");
        Edit_MD5_32_06.sendKeys(Keys.BACK_SPACE);
        Edit_MD5_32_06.sendKeys(GetRuleName());
        Thread.sleep(1000);
        //点击测试按钮
        WebElement Edit_MD5_32_07  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[3]/form/div[1]/div[2]/div/div/div/button/span")));
        Edit_MD5_32_07.click();
        //确认添加按钮
        WebElement Edit_MD5_32_08  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[3]/button[2]/span")));
        Edit_MD5_32_08.click();
        Thread.sleep(5000);

    }
    //脱敏规则上线
    @Test(priority = 3)
    public void ONline_MD5_32_Desensitization() throws InterruptedException {
        //切换至Hash脱敏函数模块
        WebElement ONline_MD5_32_01 =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rc-tabs-0-tab-crypt\"]")));
        ONline_MD5_32_01.click();
        //列表数据加载成功，点击编辑数据上线控件
        WebElement ONline_MD5_32_02  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rc-tabs-0-panel-crypt\"]/div/div[2]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[7]/a[1]")));
        ONline_MD5_32_02.click();
        //确认上线
        WebElement ONline_MD5_32_03 =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div[2]/button[2]/span")));
        ONline_MD5_32_03.click();
        Thread.sleep(3000);
    }
    //脱敏规则下线
    @Test(priority = 4)
    public void OFFline_MD5_32_Desensitization() throws InterruptedException {
        //切换至Hash脱敏函数模块
        WebElement OFFline_MD5_32_01 =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rc-tabs-0-tab-crypt\"]")));
        OFFline_MD5_32_01.click();
        //列表数据加载成功，点击编辑数据下线控件
        WebElement OFFline_MD5_32_02  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rc-tabs-0-panel-crypt\"]/div/div[2]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[7]/a[1]")));
        OFFline_MD5_32_02.click();
        //确认下线
        WebElement OFFline_MD5_32_03 =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div[2]/button[2]/span")));
        OFFline_MD5_32_03.click();
        Thread.sleep(3000);
    }
    //脱敏规则删除
    @Test(priority = 5)
    public void Drop_MD5_32_Desensitization() throws InterruptedException {
        //切换至Hash脱敏函数模块
        WebElement Drop_MD5_32_01 =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rc-tabs-0-tab-crypt\"]")));
        Drop_MD5_32_01.click();
        //列表数据加载成功，点击编辑数据删除控件
        WebElement Drop_MD5_32_02  =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rc-tabs-0-panel-crypt\"]/div/div[2]/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[7]/a[3]")));
        Drop_MD5_32_02.click();
        //确认删除
        WebElement Drop_MD5_32_03 =  new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/div[2]/button[2]/span")));
        Drop_MD5_32_03.click();
        Thread.sleep(3000);
    }
    //关闭浏览器
    @AfterClass
    public void Close_Kfy_Brower(){
        webDriver.quit();
    }
//    public static void main(String[] args) throws IOException, InterruptedException {
//       SeleniumAction  seleniumAction   = new SeleniumAction();
//       seleniumAction.Open_Kfy_Brower();
//       seleniumAction.Op_login();
//       //eleniumAction.GetRuleName();
//       seleniumAction.Add_MD5_32_Desensitization();
//       seleniumAction.Close_Kfy_Brower();
//
//    }
}
