package config.browser_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class DriverFactory {

    public DriverFactory(){
    }
    private static WebDriver driver;

    public static WebDriver getDriver(){
        try {
            if(driver == null){
                switch (DriverType.browser){
                    case CHROME:
                        System.setProperty("webdriver.chrome.driver","src\\test\\java\\resources\\chromedriver\\chromedriver.exe");
                        ChromeOptions options = new ChromeOptions();
                        driver = new ChromeDriver(options);
                        break;
                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver","src\\test\\java\\resources\\geckodriver\\geckodriver.exe");
                        FirefoxOptions optionsFirefox = new FirefoxOptions();
                        driver = new FirefoxDriver(optionsFirefox);
                        break;
                }
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get("https://magento.softwaretestingboard.com/");
            }
        }catch(Exception e){
        }
        return driver;
    }
    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }
}
