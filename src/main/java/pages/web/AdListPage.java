package pages.web;

import org.openqa.selenium.By;
import org.testng.Assert;
import pages.web.constants.AdListPageConstants;

public class AdListPage  extends AdListPageConstants {

    public void clickOnProvinceFilter(String province){
        wait(1);
        click(By.xpath("//div[@class='he-filter-control he-select js-city-filter']"));
        sendKeys(By.xpath(searchProvince),province);
        clickJS(By.xpath("//li[@class='he-select__list-item']/span[contains(text(),'"+province+"')]"));
    }


    public void checkProvinceFilterText(String provinceText){
        Assert.assertEquals(provinceText,getElementText(By.xpath(provinceFilterText)),"İl filtresi istenilen değerde seçilmemiş!");
    }

    public void clickOnDistictFilter(String district){
        clickJS(By.xpath(districtFilter));
        sendKeys(By.xpath(searchdistrict),district);
        clickJS(By.xpath("//li[@class='he-multiselect__list-item']/span[contains(text(),'"+district+"')]"));
    }

    public void checkDistrictFilterText(String districtText){
        Assert.assertEquals(districtText,getElementText(By.xpath(districtFilterText)),"İlçe filtresi istenilen değerde seçilmemiş!");
    }

    public void selectCategory(String category){
        clickJS(By.xpath("//li[@class='grid-50']/div[@class='md-radio']/label[contains(text(),'"+category+"')]"));
    }

    public void checkCategory(){
        Assert.assertEquals(find(By.xpath("//li[@class='grid-50']/div[@class='md-radio']/input[@id='main-category1']")).isSelected(),true,"istenilen kategori seçilmemiş!");
    }

    public void fillMinPrice(String minPrice){
        waitms(1500);
        clickJS(By.xpath(priceMinInput));
        waitms(1500);
        sendKeys(By.xpath(priceMinInput),minPrice);
        clickJS(By.xpath(priceMaxInput));
    }

    public void checkMinPrice(String minPriceText){
        Assert.assertEquals(minPriceText,getAttribute(By.xpath(priceMinInput),"value"),"minimum fiyat filtresi istenilen değerde girilmemiş!");
    }

    public void fillMaxPrice(String maxPrice){
        clickJS(By.xpath(priceMaxInput));
        waitms(1500);
        sendKeys(By.xpath(priceMaxInput),maxPrice);
        clickJS(By.xpath(priceMaxInput));
    }

    public void checkMaxPrice(String maxPriceText){
        Assert.assertEquals(maxPriceText,getAttribute(By.xpath(priceMaxInput),"value"),"maksimum fiyat filtresi istenilen değerde girilmemiş!");
    }

    public void clickRoomType(){
        wait(1);
        clickJS(By.xpath(roomType));
    }

    public void selectRoomType(String getRoomType){
        wait(1);
        clickJS(By.xpath("//label[@class='md-checkbox']//span[contains(text(),'"+getRoomType+"')]"));
    }

    public void clickBuildingAge(){
        clickJS(By.xpath(buildingAge));
    }

    public void selectBuildingAge(String getBuildingAge){
        clickJS(By.xpath("//label[@class='md-checkbox']//span[contains(text(),'"+getBuildingAge+"')]"));
    }

    public void clickWithInSite(){
        clickJS(By.xpath(withInSite));
    }

    public void checkBuildingAge(){
        clickJS(By.xpath(buildingAge2));
        wait(1);
        Assert.assertEquals(find(By.xpath("//li[1]//label[@class='md-checkbox']/input")).isSelected(),true,"Sıfır bina filtresi seçilmemiş!");
        Assert.assertEquals(find(By.xpath("//li[2]//label[@class='md-checkbox']/input")).isSelected(),true,"1-5  filtresi seçilmemiş!");
        Assert.assertEquals(find(By.xpath("//li[3]//label[@class='md-checkbox']/input")).isSelected(),true,"6-10 filtresi seçilmemiş!");
    }

    public void clickSearchFilter(){
        clickJS(By.xpath(filterSearch));
    }

    public void clickOnFirstCardLink(){
        clickJS(By.xpath(firstCardLink));
    }

    public void clickAndShowPhoneNumber(){
        clickJS(By.xpath(showPhoneNumber));
        wait(10);
    }

}
