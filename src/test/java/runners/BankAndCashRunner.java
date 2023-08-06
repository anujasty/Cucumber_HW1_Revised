package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src\\test\\resources\\features\\BankAndCash.feature", 
	glue = "steps", 
	tags = "@Techfiosloginandaaccount", 
	monochrome = true, 
	dryRun = false, 
	plugin = {
		"pretty", 
		"html:target/reports/cucumber.html", 
		"json:target/reports/cucumber.json", }

)
public class BankAndCashRunner {

}
