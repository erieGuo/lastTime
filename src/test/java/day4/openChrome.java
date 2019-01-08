package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class openChrome {
    WebDriver driver;

    @BeforeMethod
    public void openBrower() {
        System.setProperty("webdriver.chrome.driver", "E:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void kingGrid() throws InterruptedException {
        driver.get("http://www.kinggrid.com:8080/iWebOffice2015/DocumentList.jsp");
        Thread.sleep(5000);
        //新建一个word文档
        WebElement element = driver.findElement(By.xpath("//*[@id=\"selectID\"]/option[2]"));
        element.click();
        //等待5s关闭
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeBrower() {
        //关闭浏览器
        driver.quit();
    }
}
