/**
 * 
 */
package test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * @author PRAJJU
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"E:\\batch246\\rest-cucumber\\src\\test\\resources\\features\\1feature.feature",
				"E:\\batch246\\rest-cucumber\\src\\test\\resources\\features\\2feature.feature"},
		glue = {"glue"},
		plugin = {"pretty","html:target/myresults"},
		monochrome=true,
		strict = true
		)
public class TestRunner {

}
