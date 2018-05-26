package StepDefinitions.WebSteps

import cucumber.api.java.en.Given
import cucumber.api.java8.En
import driver.DriverManager

class LaunchBrowser: En {
    val driver = DriverManager.driver


    init {
        Given("^I open \"([^\"]*)\"") { page: String ->
            println("Launching to $page")
            driver.navigate().to(page)
        }
    }

}


