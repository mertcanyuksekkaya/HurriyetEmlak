package tests.mobile;

import base.BaseTest;
import org.testng.annotations.*;
import pages.mobile.MobileAdListPage;
import pages.mobile.MobileHomePage;
import utils.DriverManager;

public class MobileTestCase2  extends BaseTest {

    MobileHomePage mobileHomePage;
    MobileAdListPage mobileAdListPage;
    DriverManager driverManager = new DriverManager();

    @BeforeMethod
    public void setUp(){
        mobileHomePage = new MobileHomePage();
        mobileAdListPage  = new MobileAdListPage();
    }


    @Test(groups = "testNG")
    public void MobileTestCase2(){
        mobileHomePage.go_to_url();
        mobileHomePage.closeCookie();
        mobileHomePage.clickOnKiralikButton();
        mobileAdListPage.clickOnFilterButton();
        mobileAdListPage.selectProvinceFilter("Ankara");
        mobileAdListPage.selectDistictFilter("Çankaya");
        mobileAdListPage.selectRoomType("2+1");
        mobileAdListPage.selectInsideSite();
        mobileAdListPage.clickSearchFilter();
        mobileAdListPage.clickFirstAd();
        mobileAdListPage.getPhoneNumber();
        mobileAdListPage.clickListingOwnerPhoneNumber();
    }

    @AfterTest
    public void tearDown(){
        driverManager.getDriver().quit();
    }
}
