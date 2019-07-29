package com.automationpractice;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/com.automationpractice/features"},
        glue = {"com.automationpractice"}
//        ,tags = "@all"
)
//public class RunCucumberTest extends AbstractTestNGCucumberTests {
public class RunCucumberTest {
}
