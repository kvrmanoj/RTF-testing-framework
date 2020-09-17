package test;

import io.cucumber.testng.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin= {"Pretty","html:target/cucumberHtmlReport"
		},
		glue= {"test"},
		features="classpath:Features"
		
		)
public class Runner {

}