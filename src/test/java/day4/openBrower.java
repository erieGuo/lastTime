package day4;

import com.sun.java.util.jar.pack.DriverResource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

public class openBrower {

    WebDriver driver;

    @BeforeMethod
    public void openBrowerTest(){
        //指定IEDriverServer.exe路径
        System.setProperty("webdriver.ie.driver","E:\\driver\\IEDriverServer.exe");
        //启动ie浏览器
        driver=new InternetExplorerDriver();
    }

    @Test
    public void openIeTest() throws InterruptedException {

        //打开金格2015控件
        driver.get("http://www.kinggrid.com:8080/iWebOffice2015/DocumentList.jsp");
        Thread.sleep(5000);
        //定位下拉框
        WebElement element=driver.findElement(By.id("selectID"));
        //new一个select对象
         Select select=new Select(element);
         select.selectByVisibleText("　新建WORD文档");
         //element.click();
        //等待5s关闭
        Thread.sleep(5000);
    }
    @AfterMethod
    public void closeBrower(){
        //关闭浏览器
        driver.quit();
    }
}
