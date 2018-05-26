package StepDefinitions.WebSteps


import cucumber.api.java8.En
import driver.DriverManager.openBrowser
import driver.DriverManager.driver

class LaunchBrowser: En {


    init {
        Given("^I open \"([^\"]*)\"") {browser : String -> openBrowser(browser)}

        And("^I navigate to \"([^\"]*)\"") { page: String ->
            driver().navigate().to(page)
        }
    }

}


