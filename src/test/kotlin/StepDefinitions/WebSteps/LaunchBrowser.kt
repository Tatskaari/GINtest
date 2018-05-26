package StepDefinitions.WebSteps

import cucumber.api.java.en.Given
import cucumber.api.java8.En
import driver.DriverManager

class LaunchBrowser: En {
    val driver = DriverManager.driver

    @Given("^I open \"([^\"]*)\"")
    fun openBrowser(url: String) {
        println("Launching to $url")
        driver.navigate().to(url)
    }

}