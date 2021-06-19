package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="Features", glue= {"com.StepDefinitions"},
plugin= {
		"pretty","html:target/MyCucumberReport.html",
		"json:target/cucumber.json",
		"junit:target/cucmber.xml"
		
  }		
)

public class Runner {

}


