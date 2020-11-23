package pages.web;

import org.openqa.selenium.By;
import pages.web.constants.HomePageConstants;
import utils.PropertiesReader;

public class HomePage extends HomePageConstants {

    public void go_to_url() {
        String environmentName = PropertiesReader.getEnvironment();
        String browserName = PropertiesReader.getBrowser();
        navigate("https://www.hurriyetemlak.com");
    }

    public void clickOnSatilikButton(){
        click(By.xpath(satilikButton));
    }

    public void clickOnKiralikButton(){
        click(By.xpath(kiralikButton));
    }

}
