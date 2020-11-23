package pages.mobile;

import org.openqa.selenium.By;
import pages.mobile.constants.MobileHomePageConstants;
import utils.PropertiesReader;

public class MobileHomePage extends MobileHomePageConstants {

    public void go_to_url() {
        String environmentName = PropertiesReader.getEnvironment();
        String browserName = PropertiesReader.getBrowser();
        navigate("https://www.hurriyetemlak.com");
    }

    public void closeCookie(){
        if (isElementExist(By.xpath(closeCookie)))
            clickJS(By.xpath(closeCookie));
    }

    public void clickOnSatilikButton(){
        click(By.xpath(satilikButton));
    }

    public void clickOnKiralikButton(){
        click(By.xpath(kiralikButton));
    }

}
