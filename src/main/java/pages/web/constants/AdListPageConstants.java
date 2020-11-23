package pages.web.constants;

import base.BasePage;

public class AdListPageConstants  extends BasePage {

   protected String provinceFilter = "//div[@class='he-select-base']//span[contains(text(),'İl Seçiniz')]";
   protected String provinceFilterText = "//section[contains(@class,'locationCitySec')]//div[@class='he-select-base']//span[contains(@class,'he-select-base__value')]";
   protected String districtFilter = "//div[@class='he-select-base']//span[contains(text(),'İlçe Seçiniz')]";
   protected String districtFilterText = "//section[contains(@class,'locationCountySec')]//div[@class='he-select-base']//span[contains(@class,'he-select-base__value')]";
   protected String searchProvince = "//input[@placeholder='İl Ara']";
   protected String searchdistrict = "//input[@placeholder='İlçe Ara']";
   protected String priceMinInput  = "//input[contains(@class,'priceMin')]";
   protected String priceMaxInput  = "//input[contains(@class,'priceMax')]";
   protected String roomType       = "//div[@class='c-title' and contains(text(),'Oda Seçiniz')]";
   protected String buildingAge    = "//div[@class='c-title' and contains(text(),'Bina Yaşı Seçiniz')]";
   protected String buildingAge2   = "//span[contains(@class,'c-item-val')]";
   protected String withInSite     = "//section[contains(@class,'withinSiteSec')]/label";
   protected String filterSearch   = "//section[@class='filter-button-wrapper']/a[1]";
   protected String firstCardLink  = "//div[@id='57012-5449block0']//a[@class='card-link']";
   protected String showPhoneNumber = "//button[contains(@class,'owner-phone-numbers-button')]/span[contains(text(),'Telefon')]";
}
