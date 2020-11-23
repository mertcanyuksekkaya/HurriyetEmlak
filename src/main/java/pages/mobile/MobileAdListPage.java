package pages.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.mobile.constants.MobileAdListPageConstants;

public class MobileAdListPage extends MobileAdListPageConstants {

    public String getSeelectItem;

    public void clickOnFilterButton(){
        waitVisibility(By.xpath(generalFilterButton));
        clickJS(By.xpath(generalFilterButton));
    }

    public void selectProvinceFilter(String province){
       WebElement e = selectVisibleText(By.xpath(provinceFilter),province);
       getSeelectItem = e.getText();
    }


    public void checkProvinceFilterText(String provinceText){
        Assert.assertEquals(provinceText,getSeelectItem.trim(),"İl filtresi istenilen değerde seçilmemiş!");
    }

    public void selectDistictFilter(String district){
        clickJS(By.xpath(districtFilter));
        clickJS(By.xpath("//div[@class='district-list-dialog']//span[contains(text(),'"+district+"')]"));
        clickJS(By.xpath("//div[@id='dropdown-lightbox-district']//button[contains(@class,'filter-close')]"));
    }

    public void checkDistrictFilterText(String districtText){
        Assert.assertEquals(districtText,getElementText(By.xpath(districtFilterText)),"İlçe filtresi istenilen değerde seçilmemiş!");
    }


    public void selectCategory(String category){
        clickJS(By.xpath("//li/div[@class='md-radio']/label[contains(text(),'"+category+"')]"));
    }

    public void checkCategory(String category){
        Assert.assertEquals(find(By.xpath("//li/div[@class='md-radio']/input[@id='main-category1']")).isSelected(),true,"istenilen kategori seçilmemiş!");
    }

    public void fillMinPrice(String minPrice){
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

    public void selectBuildingAge(String buildingAge){
        clickJS(By.xpath(selectbuildingAge));
        clickJS(By.xpath("//div[contains(@id,'dropdown-lightbox-filter')]//li//span[contains(text(),'"+buildingAge+"')]"));
        clickJS(By.xpath("//div[@id='dropdown-lightbox-filter']//button[contains(@class,'filter-close')]"));

    }

    public void checkBuildingAge(){
        clickJS(By.xpath(selectbuildingAge));
        wait(1);
        Assert.assertEquals(find(By.xpath("//div[contains(@id,'dropdown-lightbox-filter')]//li[1]//input")).isSelected(),true,"Sıfır Bina filtresi seçilmemiş!");
        Assert.assertEquals(find(By.xpath("//div[contains(@id,'dropdown-lightbox-filter')]//li[2]//input")).isSelected(),true,"1-5 yaş arası bina filtresi seçilmemiş!");
        Assert.assertEquals(find(By.xpath("//div[contains(@id,'dropdown-lightbox-filter')]//li[3]//input")).isSelected(),true,"6-10 yaş arası bina filtresi seçilmemiş!");
    }

    public void selectRoomType(String roomType){
        wait(1);
        clickJS(By.xpath(selectRoomType));
        wait(1);
        clickJS(By.xpath("//div[contains(@id,'dropdown-lightbox-filter')]//li//span[contains(text(),'"+roomType+"')]"));
        clickJS(By.xpath("//div[@id='dropdown-lightbox-filter']//button[contains(@class,'filter-close')]"));

    }

    public void selectInsideSite(){
        clickJS(By.xpath(insideSite));
    }

    public void clickFirstAd(){
        clickJS(By.xpath(firstAd));
    }

    public void clickListingOwnerPhoneNumber(){
        clickJS(By.xpath(listingOwnerPhoneNumber));
    }

    public void getPhoneNumber(){
        waitElement(By.xpath(getPhoneNumber),20);
        System.out.println("Phone number: "+getAttribute(By.xpath(getPhoneNumber),"href"));
        Assert.assertFalse(getAttribute(By.xpath(getPhoneNumber),"href").isEmpty(),"Telefon numarası alınamadı!");
    }

    public void clickSearchFilter(){
        clickJS(By.xpath(filterSearch));

    }



}
