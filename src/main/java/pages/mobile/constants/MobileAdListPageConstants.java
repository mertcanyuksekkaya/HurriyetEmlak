package pages.mobile.constants;

import base.BasePage;

public class MobileAdListPageConstants extends BasePage {


   protected String generalFilterButton  = "//button[@class='btn btn-white']//span[contains(text(),'Filtrele')]";

   protected String provinceFilter       = "//div[@class='city']/select";
   protected String selectProvinceFilter = "//div[@class='city']/select/option[contains(text(),'İzmir')]";
   protected String provinceFilterText   = "//section[contains(@class,'locationCitySec')]//div[@class='he-select-base']//span[contains(@class,'he-select-base__value')]";

   protected String districtFilter       = "//div[@class='custom-select']/span[contains(text(),'İlçe')]";
   protected String selectDistrictFilter = "//div[@class='district-list-dialog']//span[contains(text(),'Bornova')]";
   protected String districtFilterText   = "//section[contains(@class,'select-content')]//span/span";

   protected String searchProvince       = "//input[@placeholder='İl Ara']";
   protected String searchdistrict       = "//input[@placeholder='İlçe Ara']";

   protected String selectProvince       = "//li[@class='he-select__list-item']/span[contains(text(),'İzmir')]";
   protected String selectdistrict       = "//li[@class='he-multiselect__list-item']/span[contains(text(),'Bornova')]";

   protected String priceMinInput        = "//section[@class='price']//div[contains(@class,'floating-label')][1]//input";
   protected String priceMaxInput        = "//section[@class='price']//div[contains(@class,'floating-label')][2]//input";

   protected String selectbuildingAge    = "//section[contains(@class,'building-age')]/section/div";

   protected String selectRoomType       = "//section[contains(@class,'room-type')]/section/div";
   protected String insideSite           = "//span[@class='title-right' and contains(text(),'Site')]";

   protected String firstAd              = "//div[@class='reality-single-card'][1]//div[contains(@class,'swiper-slide-active')]/img";
   protected String getPhoneNumber       = "//div[@class='call-owner sticky-owner-call']//a[@id='call-owner']";
   protected String listingOwnerPhoneNumber = "//div[@class='call-owner sticky-owner-call']//a[@id='call-owner']/span[1]";
   protected String filterSearch         = "//button[contains(@class,'get-result')]";

}
