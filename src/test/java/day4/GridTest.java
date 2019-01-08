package day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class GridTest {
    String url="http://192.168.61.131:4444/wd/hub";
    @Test
    public void TestChrome() throws InterruptedException, MalformedURLException {
        DesiredCapabilities chromeDC=DesiredCapabilities.chrome();
        WebDriver driver =new RemoteWebDriver(new URL(url),chromeDC);
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }

    @DataProvider(name="data1")
    public Object[][] dateT(){
        return new Object[][]{
                {"chrome"},
                {"firefox"},
        };
    }

    @Test(dataProvider="data1")
    public void testGrid2(String brower) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities;
        if (brower.equals("chrome")) {
            desiredCapabilities=DesiredCapabilities.chrome();
        }else if(brower.equals("firefox")){
            desiredCapabilities=DesiredCapabilities.firefox();
        }else{
            desiredCapabilities=DesiredCapabilities.internetExplorer();
        }
        //String url=url+"/wd/hub";
        WebDriver driver=new RemoteWebDriver(new URL(url),desiredCapabilities);
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
        }
    }

