package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ONUR on 07.01.2017.
 */
public class AjaxWaiter {

    public static WebDriverWait jsWait;
    public static JavascriptExecutor jsExec;
    public WebDriver jsWaitDriver;

    public AjaxWaiter(WebDriver driver) {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, 20);
        jsExec = (JavascriptExecutor) jsWaitDriver;
    }

    //Wait for AJAX
    public void ajaxComplete() {
        jsExec = (JavascriptExecutor) jsWaitDriver;
        jsExec.executeScript("var callback = arguments[arguments.length - 1];"
                + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
                + "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
                + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
    }

    //Wait for JQuery Load
    public void waitForJQueryLoad() {
        //Wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) jsWaitDriver)
                .executeScript("return jQuery.active") == 0);

        //Get JQuery is Ready
        boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

        //Wait JQuery until it is Ready!
        if (!jqueryReady) {
            System.out.println("JQuery is NOT Ready!");
            //Wait for jQuery to load
//            jsWait.until(jQueryLoad);
        } else {
            //System.out.println("JQuery is Ready!");
        }
    }

    //Wait for Angular Load
    public void waitForAngularLoad() {
        WebDriverWait wait = new WebDriverWait(jsWaitDriver, 20);
        JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

        //Wait for ANGULAR to load
        ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
                .executeScript(angularReadyScript).toString());

        //Get Angular is Ready
        boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());

        //Wait ANGULAR until it is Ready!
        if (!angularReady) {
            System.out.println("ANGULAR is NOT Ready!");
            //Wait for Angular to load
            wait.until(angularLoad);
        } else {
            System.out.println("ANGULAR is Ready!");
        }
    }

    //Wait Until JS Ready (Page Complete Ready)
    public void waitUntilJSReady() {
        WebDriverWait wait = new WebDriverWait(jsWaitDriver, 20);
        JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) jsWaitDriver)
                .executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("JS in NOT Ready!");
            //Wait for Javascript to load
            wait.until(jsLoad);
        } else {
            //System.out.println("JS is Ready!");
        }
    }

    //Wait Until JQuery Ready
    public void waitUntilJQueryReady() {
        JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

        //First check that JQuery is defined on the page. If it is, then wait AJAX
        Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined == true) {
            //Pre Wait for stability (Optional)
            sleep(20);

            //Wait JQuery Load
            waitForJQueryLoad();

            //Post Wait for stability (Optional)
            sleep(20);
        } else {
            System.out.println("jQuery is not defined on this site!");
        }
    }

    //Wait Until Angular Ready
    public void waitUntilAngularReady() {
        JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

        //First check that ANGULAR is defined on the page. If it is, then wait ANGULAR
        Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
        if (!angularUnDefined) {
            Boolean angularInjectorUnDefined = (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
            if (!angularInjectorUnDefined) {
                //Pre Wait for stability (Optional)
                sleep(20);

                //Wait Angular Load
                waitForAngularLoad();

                //Post Wait for stability (Optional)
                sleep(20);
            } else {
                System.out.println("Angular injector is not defined on this site!");
            }
        } else {
            System.out.println("Angular is not defined on this site!");
        }
    }

    //Wait Until JS (PageLoad), AJAX, JQuery Angular is Ready
    public void waitAllRequest() {
        waitUntilJSReady();
        ajaxComplete();
        waitUntilJQueryReady();
        //waitUntilAngularReady();
    }

    public static void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //-------------------DEPRECIATED METHODS--------------------------------------------
    //AF: Below wait are too slow. I commented out them and add new wait methods.
/*  private static final String AJAX_WAIT_SCRIPT = "return typeof jQuery != 'undefined' && jQuery.active != 0";
    private static final String ANGULAR_WAIT_SCRIPT = "return angular.element(document).injector().get('$http').pendingRequests.length != 0";
    private static final boolean Debug = true;
    private static final int ImplicitWaitInSeconds = 30;

    public WebDriver waDriver;

    public AjaxWaiter(WebDriver driver){
        waDriver = driver;
    }

    static JavascriptExecutor jsDriver = null;
    public void ajaxComplete() {

        jsDriver = (JavascriptExecutor)waDriver;
        jsDriver.executeScript("var callback = arguments[arguments.length - 1];"
                + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
                + "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
                + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
    }

    private void pageLoadComplete() {
        jsDriver = (JavascriptExecutor)waDriver;
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                return jsDriver.executeScript("return document.readyState", true).toString().equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(waDriver, 20);
            wait.until(expectation);
        } catch (Throwable error) {
        }
    }

    private void jQueryComplete() {

        jsDriver = (JavascriptExecutor)waDriver;
        if(jsDriver.executeScript("return window.jQuery != undefined").toString().contains("true")) {
            if (jsDriver.executeScript("return jQuery.active").toString().equals("0")) {
                System.out.println("Page Is loaded.");
                return;
            }

            for (int i = 0; i < 25; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
                if (jsDriver.executeScript("return jQuery.active").toString().equals("0")) {
                    break;
                }
            }
        }
    }

    public void waitAllRequest(){

        *//*pageLoadComplete();
        ajaxComplete();
        jQueryComplete();*//*
    }*/

}
