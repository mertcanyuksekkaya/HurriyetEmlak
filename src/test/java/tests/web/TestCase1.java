package tests.web;


import base.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.web.AdListPage;
import pages.web.HomePage;

public class TestCase1 extends BaseTest {

    HomePage homePage;
    AdListPage adListPage;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
        adListPage  = new AdListPage();
    }


    @Test(groups = "testNG")
    public void testCase1(){
        homePage.go_to_url();
        homePage.clickOnSatilikButton();
        adListPage.clickOnProvinceFilter("İzmir");
        adListPage.clickOnDistictFilter("Bornova");
        adListPage.selectCategory("İşyeri");
        adListPage.fillMinPrice("100.000");
        adListPage.fillMaxPrice("2.000.000");
        adListPage.clickBuildingAge();
        adListPage.selectBuildingAge("Sıfır Bina");
        adListPage.selectBuildingAge("1-5");
        adListPage.selectBuildingAge("6-10");
        adListPage.clickSearchFilter();
        adListPage.checkProvinceFilterText("İzmir");
        adListPage.checkDistrictFilterText("Bornova");
        adListPage.checkCategory();
        adListPage.checkMinPrice("100.000");
        adListPage.checkMaxPrice("2.000.000");
        adListPage.checkBuildingAge();
    }




}
