package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.web.HomePage;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @Given("user goes to hurriyetemlak.com")
    public void go_to_url() {
        homePage.go_to_url();
    }

    @When("click on satilik button")
    public void clickOnSatilikButton(){
        homePage.clickOnSatilikButton();
    }

    @When("click on kiralik button")
    public void clickOnKiralikButton(){
        homePage.clickOnKiralikButton();
    }

}
