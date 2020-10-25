package com.adidas.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/** Represents Test Runner Class 
 * this is executed as junit test 
 * class for cucumber based frame-
 * work.
 * @Runwith represnts it as cucumber 
 * class
 * @CucumberOptions tells the path of
 * feature file and step defintion file
 * used in framework
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resource/"
        ,glue={"com.adidas.stepDefinitions"}
)
public class TestRunner {
}