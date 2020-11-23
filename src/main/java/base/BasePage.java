package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AjaxWaiter;
import utils.DriverManager;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    public final int waitSecond = 40;
    JavascriptExecutor jsExec;
    public WebDriverWait wait ;
    public AjaxWaiter ajaxWaiter;
    public final Logger log = Logger.getLogger(getClass());

    public BasePage(){
        this.driver = new DriverManager().getDriver();
        jsExec = (JavascriptExecutor) this.driver;
        System.setProperty("file.encoding", "UTF-8");
        PageFactory.initElements(this.driver, this);
    }

    public void waitForLoad() {
        new WebDriverWait(driver, waitSecond).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public void navigate(String url) {
        driver.get(url);
        log.info(url+" adresine gidiliyor.");
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public String  getBrowserName(){
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        return browserName;
    }

    public WebElement find(By by) {
        waitForLoad();
        WebElement element = driver.findElement(by);
        log.info(by+" elementi bulundu.");
        return element;
    }

    public List<WebElement> finds(By by) {
        List<WebElement> ListElement = driver.findElements(by);
        log.info(by+" elementleri bulundu.");
        return ListElement;
    }

    public void sendKeys(By by,String text) {
        waitForLoad();
        waitVisibility(by);
        //driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
        log.info(by+" elementine "+text+" yazıldı.");
    }

    public void sendKeysValue(By by,String text){
        WebElement element = find(by); // you can use any locator
        System.out.println("Element bulundu"+element);
        jsExec.executeScript("arguments[0].value='"+text+"';", element);
    }

    public void sendKeysClear(By by){
        driver.findElement(by).clear();
    }

    protected String getAttribute(By by,String attribute){
        return find(by).getAttribute(attribute);
    }

    public void click(By by) {
        waitForLoad();
        waitVisibility(by);
        waitClickable(by);
        driver.findElement(by).click();
        log.info(by+" elementine tıklandı.");
    }

    public void clickJS(By by) {
        waitForLoad();
        waitVisibility(by);
        WebElement element =find(by);
        waitVisibility(by);
        jsExec.executeScript("arguments[0].click();", element);
        log.info(by+" elementine JS ile tıklandı.");
    }

    public WebElement selectVisibleText(By by,String text){
        Select select = new Select(find(by));
        select.selectByVisibleText(text);
        return select.getFirstSelectedOption();
    }

    public void selectByValue(By by,String value){
        Select select = new Select(find(by));
        select.selectByValue(value);
    }

    public void selectByIndex(By by,int index){
        Select select = new Select(find(by));
        select.selectByIndex(index);
    }

    public boolean isElementExist(By by) {

        if (finds(by).size() > 0) {
            log.info(by + " elementi var.");
            return true;
        }else {
            log.info(by+" elementi yok.");
            return false;
        }
    }


    public boolean isElementExist(By by,String elementName) {

        if (finds(by).size() > 0) {
            log.info(elementName + " elementi var.");
            return true;
        }else {
            log.info(elementName+" elementi yok.");
            return false;
        }
    }

    public void wait(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitms(int msecond){
        try {
            Thread.sleep(msecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitVisibility(By by) {
        wait = new WebDriverWait(driver, waitSecond);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitClickable(By by) {
        wait = new WebDriverWait(driver, waitSecond);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected Boolean waitElement(By by, int second) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, second);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getElementText(By by){
        waitVisibility(by);
        return driver.findElement(by).getText();
    }

    public String getTextWithoutVisibility(By by){
        waitElement(by,20);
        return find(by).getText();
    }


}
