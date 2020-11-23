package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    //public final Logger log = Logger.getLogger(getClass());


    public WebDriver getDriver(){
        return driver.get();
    }

    public void setDriver(WebDriver webDriver){
        driver.set(webDriver);
    }

    public void initializeDriver(String browser) throws Exception {
        WebDriver driver = null;
        OptionsManager optionsManager = new OptionsManager();
        if(driver == null){
            try{
                System.setProperty("file.encoding", "UTF-8");
                switch(browser){
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver/chromedriver.exe");
                        driver = new ChromeDriver(optionsManager.getChromeOptions());
                        break;
                      case "firefox":
                        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver/geckodriver.exe");
                        driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
                        break;
                    case "mobileChrome":
                        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver/chromedriver.exe");
                        driver = new ChromeDriver(optionsManager.getMobileChromeOption());
                        break;
                    case "mobileFirefox":
                        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver/geckodriver.exe");
                        driver = new FirefoxDriver(optionsManager.getMobileFirefoxOptions());
                        break;
                }
                if(driver == null){
                    throw new Exception("driver is null!");
                }
                this.driver.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }

    }

}
