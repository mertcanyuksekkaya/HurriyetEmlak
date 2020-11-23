package base;
import org.testng.annotations.*;
import utils.DriverManager;

public class BaseTest {

    DriverManager driverManager = new DriverManager();
    @Parameters({"browser"})
    @BeforeTest()
    public void setUpClass(@Optional("mobileChrome") String browser) throws Exception {
        driverManager.initializeDriver(browser);
    }

    @AfterTest
    public void tearDown(){
        driverManager.getDriver().quit();
    }
}
