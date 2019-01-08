package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    WebDriver driver;



       @BeforeMethod
       public void openFirefox(){
        //System.setProperty("webdriver.chrome.driver","E:\\driver\\chromedriver.exe");
        //driver=new ChromeDriver();
        System.setProperty("webdriver.ie.driver","E:\\driver\\IEDriverServer.exe");
        driver=new InternetExplorerDriver();
        driver.get("https://mail.163.com/");
    }

       @Test
       public void registest()throws InterruptedException{
        //控制权交到iframe里面

        WebElement frame=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
        //点击去注册按钮
        Thread.sleep(10000);

        driver.findElement(By.id("changepage")).click();
        //获取当前driver所在页面handle值
        String handle1=driver.getWindowHandle();

        for(String handles :  driver.getWindowHandles()){
            if(handles.equals(handle1))
                continue;
            driver.switchTo().window(handles);
        }

        //获得一个随机数
        String time=String.valueOf(System.currentTimeMillis()/100);
        driver.findElement(By.id("nameIpt")).sendKeys("email"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("12321432423432");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("12321432423432");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        driver.findElement(By.id("vcodeIpt")).sendKeys("qw21");
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("1234");
        driver.findElement(By.id("mainRegA")).click();
        Thread.sleep(5000);
        String errorInfo=driver.findElement(By.className("txt-err")).getText();
        Assert.assertEquals(errorInfo,"  手机验证码不正确，请重新填写","未提示手机验证码不正确，请重新填写");
    }

       @Test
       public void login() throws InterruptedException {
        RegisterTest.loginInfo(driver,"erie_qu329","jianjian0.0");
        Thread.sleep(10000);
        //new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        Boolean promptInfo=driver.findElement(By.linkText("退出")).isDisplayed();

        Assert.assertTrue(promptInfo);
       }

       @Test
       public void loginError(){
           RegisterTest.loginInfo(driver,"erie_qu329","jianjian00");

           new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
           Boolean promptInfo=driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).isDisplayed();

           Assert.assertTrue(promptInfo);

       }

       @Test
       public static void loginInfo( WebDriver driver, String email,String pwd) {
           WebElement frame = driver.findElement(By.tagName("iframe"));
           driver.switchTo().frame(frame);

           new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.name("email")));

           driver.findElement(By.name("email")).sendKeys("email");
           driver.findElement(By.name("password")).sendKeys("pwd");
           driver.findElement(By.id("dologin")).click();
       }

       @AfterMethod
       public void closeBrower(){
           driver.quit();
       }

}
