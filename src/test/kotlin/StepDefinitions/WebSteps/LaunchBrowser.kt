package StepDefinitions.WebSteps

import cucumber.api.java8.En
import drivermanager.driver

class LaunchBrowser: En {
    
    init {
        Given("^I open \"([^\"]*)\"") { page: String ->
            println("Launching to $page")
            driver.navigate().to(page)
        }
    }

}


