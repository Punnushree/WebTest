package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

//Baseclass to initialise and setup before test and after test actions
public class Baseclass {

    //initialising and loading the browser
    public static WebDriver driver;
    public String baseUrl = "http://localhost:8080";

    @BeforeTest
    public void LaunchBrowser(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    //method to take screenshots on failed testcase
    public void getScreenshot(String testCaseName,WebDriver driver){
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String ssFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        try {
            FileUtils.copyFile(source,new File(ssFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Close the browser
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
