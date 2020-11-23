package tests.mobile;

import base.BaseTest;
import org.testng.annotations.*;
import pages.mobile.MobileAdListPage;
import pages.mobile.MobileHomePage;
import utils.DriverManager;

public class MobileTestCase1 extends BaseTest{

    MobileHomePage mobileHomePage;
    MobileAdListPage mobileAdListPage;
    DriverManager driverManager = new DriverManager();

    @BeforeMethod
    public void setUp() {
        mobileHomePage = new MobileHomePage();
        mobileAdListPage  = new MobileAdListPage();
    }

    @Parameters({"browser"})
    @BeforeTest()
    public void setUpClass(@Optional("mobileChrome") String browser) throws Exception {
        driverManager.initializeDriver(browser);
    }

    @Test(groups = "testNG")
    public void MobileTestCase1(){
        mobileHomePage.go_to_url();
        mobileHomePage.closeCookie();
        mobileHomePage.clickOnSatilikButton();
        mobileAdListPage.clickOnFilterButton();
        mobileAdListPage.selectProvinceFilter("İzmir");
        mobileAdListPage.selectDistictFilter("Bornova");
        mobileAdListPage.selectCategory("İşyeri");
        mobileAdListPage.fillMinPrice("100.000");
        mobileAdListPage.fillMaxPrice("2.000.000");
        mobileAdListPage.selectBuildingAge("Sıfır Bina");
        mobileAdListPage.selectBuildingAge("1-5");
        mobileAdListPage.selectBuildingAge("6-10");
        mobileAdListPage.clickSearchFilter();
        mobileAdListPage.clickOnFilterButton();
        mobileAdListPage.checkProvinceFilterText("İzmir");
        mobileAdListPage.checkDistrictFilterText("Bornova");
        mobileAdListPage.checkCategory("İşyeri");
        mobileAdListPage.checkMinPrice("100.000");
        mobileAdListPage.checkMaxPrice("2.000.000");
        mobileAdListPage.checkBuildingAge();
    }

    @AfterTest
    public void tearDown(){
        driverManager.getDriver().quit();
    }


}
