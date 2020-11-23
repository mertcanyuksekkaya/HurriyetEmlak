package runners;

import io.cucumber.testng.CucumberOptions;
import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;


@CucumberOptions(
        plugin = {"pretty"
                //, "html:target/ChromeWeb/cucumber"
                , "summary"
                , "de.monochromata.cucumber.report.PrettyReports:target/browser-reports/Chrome"}
        ,features = {"src/test/java/features"}
        ,glue = {"stepDefinition"}
        ,dryRun=false
        ,monochrome=true
        ,strict=true
        ,snippets = CAMELCASE
        ,tags = {"@cucumberTestcase1 or @cucumberTestcase2"}
)
public class ChromeWebRunner extends RunnerBase {

}
