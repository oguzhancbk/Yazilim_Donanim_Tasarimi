package org.selenium.pom.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.pom.utils.ReadConfig;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public static WebDriver driver;
    public static Logger logger;
    public final String url = readConfig.getBaseUrl();
    public final String browser = readConfig.getInstance().getBrowser();

    @BeforeClass
    public void setup() {
        BaseDevTools baseDevTools = new BaseDevTools();
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            DevTools devTools = ((ChromeDriver)driver).getDevTools();
            //baseDevTools.BaseDevTools(devTools);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            DevTools devTools = ((FirefoxDriver)driver).getDevTools();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            DevTools devTools = ((EdgeDriver)driver).getDevTools();
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        logger = LogManager.getLogger("Trendyol_Fe_Test_Automation");
    }

    @AfterClass
    public void tearDown(){
        //driver.close();
        //driver.quit();
    }
    @AfterMethod
    public void takeScreenShot(ITestResult result){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new java.util.Date());
        String path = System.getProperty("user.dir") + "/Screenshots/" + result.getName() + " " + timeStamp + ".png";
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);
        try {
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
