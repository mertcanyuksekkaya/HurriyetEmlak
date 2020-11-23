package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverManager;

import java.io.IOException;

public class Hooks {

    @Before
    public void initialize(Scenario scenario) throws Exception {
        System.out.println(scenario.getName() + " is started!");
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) new DriverManager().getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", scenario.getName());
        }
        System.out.println(scenario.getName() + " is finished!");
    }
}
