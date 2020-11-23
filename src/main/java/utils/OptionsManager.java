package utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionsManager {
	
	 //Get Chrome Options
    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 11_0_1 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A402 Safari/604.1");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--disable-gpu");
//        if (PropertiesReader.getHeadless().equalsIgnoreCase("true")){
//            options.addArguments("--headless");
//        }
        return options;
    }

    public ChromeOptions getMobileChromeOption(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 11_0_1 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A402 Safari/604.1");
        options.addArguments("--window-size=360,740");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--disable-gpu");
//        if (PropertiesReader.getHeadless().equalsIgnoreCase("true")){
//            options.addArguments("--headless");
//        }
        return options;
    }

    //Get Firefox Options
    public FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("network.proxy.type", 0);
        profile.setPreference("browser.privatebrowsing.autostart", true);
        profile.setPreference("javascript.enabled", true);
        profile.setPreference("browser.link.open_newwindow", 2);
//        if (PropertiesReader.getHeadless().equalsIgnoreCase("true")){
//            options.addArguments("--headless");
//        }
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

    public FirefoxOptions getMobileFirefoxOptions () {
        String responsiveMode = "{"+"\"key\":\"800x600\",\n"+"\"name\":\"POS Terminal\",\n"+"\"width\":800,\n"+"\"height\": 600"+"}";
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0_1 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A402 Safari/604.1");
        profile.setPreference("browser.privatebrowsing.autostart", true);
        profile.setPreference("network.proxy.type", 0);
        profile.setPreference("browser.link.open_newwindow", 2);
//        if (PropertiesReader.getHeadless().equalsIgnoreCase("true")){
//            options.addArguments("--headless");
//        }
        options.addArguments("--width=360");
        options.addArguments("--height=700");
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

//    //AF: Browserstack Capabilities
//    public DesiredCapabilities setBrowserStackCaps(){
//        DesiredCapabilities capabilities = null;
//        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");
//        Date date = new Date();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("test-type");
//        options.addArguments("disable-popup-blocking");
//        options.addArguments("ignore-certificate-errors");
//        options.addArguments("disable-translate");
//        options.addArguments("--incognito");
//        options.addArguments("--allow-insecure-localhost");
//        //options.addArguments("--headless");
//        options.addArguments("--disable-gpu");
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        capabilities.setCapability("os", "Windows");
//        capabilities.setCapability("os_version", "10");
//        capabilities.setCapability("browser", "Chrome");
//        capabilities.setCapability("browser_version", "79.0");
//        capabilities.setCapability("resolution", "1366x768");
//        capabilities.setCapability("project", "test");
//        capabilities.setCapability("build", 	dateFormat.format(date));
//        capabilities.setCapability("name", "test1");
//        capabilities.setCapability("browserstack.use_w3c", "true");
//        capabilities.setCapability("browserstack.local", "false");
//        capabilities.setCapability("browserstack.networkLogs", "true");
//        capabilities.setCapability("browserstack.selenium_version", "3.141.59");
//
//        return capabilities;
//    }

}
