package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.web.AdListPage;

public class AdListSteps {

    AdListPage adListPage = new AdListPage();

    @Then("^click on province filter and select province as (.*) in ad list page$")
    public void clickOnProvinceFilter(String province){
        adListPage.clickOnProvinceFilter(province);
    }

    @And("^click on district filter and select district as (.*) in ad list page$")
    public void clickOnDistrictFilter(String district){
        adListPage.clickOnDistictFilter(district);
    }

    @Then("^select category as (.*) in ad list page$")
    public void selectCategory(String category){
        adListPage.selectCategory(category);
    }

    @And("^fill min price as (.*) in ad list page$")
    public void fillMinPrice(String minPrice){
        adListPage.fillMinPrice(minPrice);
    }

    @And("^fill max price as (.*) in ad list page$")
    public void fillMaxPrice(String maxPrice){
        adListPage.fillMaxPrice(maxPrice);
    }

    @Then("^click on room type filter in ad list page$")
    public void clickRoomType(){
        adListPage.clickRoomType();
    }

    @And("^select room type as (.*) in ad list page$")
    public void selectRoomType(String roomType){
        adListPage.selectRoomType(roomType);
    }

    @Then("^click on building age filter  in ad list page$")
    public void selectBuildingAge(){
        adListPage.clickBuildingAge();
    }

    @And("^select building age as (.*) in ad list page$")
    public void selectBuildingAge(String buildingAge){
        adListPage.selectBuildingAge(buildingAge);
    }

    @Then("^click on search button in ad list page$")
    public void clickFilterSearch(){
        adListPage.clickSearchFilter();
    }

    @And("^check province filter text as (.*)$")
    public void checkProvinceFilterText(String provinceText){
        adListPage.checkProvinceFilterText(provinceText);
    }

    @And("^check district filter text as (.*)$")
    public void checkDistrictFilterText(String districtText){
        adListPage.checkDistrictFilterText(districtText);
    }

    @And("^check category filter text as İşyeri$")
    public void checkCategoryIsSelected(){
        adListPage.checkCategory();
    }

    @And("^check min price filter text as (.*)$")
    public void checkMinPrice(String minPrice){
        adListPage.checkMinPrice(minPrice);
    }

    @And("^check max price filter text as (.*)$")
    public void checkMaxPrice(String maxprice){
        adListPage.checkMaxPrice(maxprice);
    }

    @And("^click with in site$")
    public void clickWithInSite(){
        adListPage.clickWithInSite();
    }

    @And("^check building age filter$")
    public void checkBuildingAge(){
        adListPage.checkBuildingAge();
    }

    @And("^click first card$")
    public void clickFirstCard(){
        adListPage.clickOnFirstCardLink();
    }

    @Then("^click and show phone number$")
    public void clickAndShowPhoneNumber(){
        adListPage.clickAndShowPhoneNumber();
    }


}
