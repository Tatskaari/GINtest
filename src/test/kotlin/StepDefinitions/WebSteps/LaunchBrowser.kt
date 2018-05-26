package StepDefinitions.WebSteps

import cucumber.api.java8.En
import driver.BrowserDriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import kotlin.test.fail

class LaunchBrowser: En {
    init{
        val driver = BrowserDriver.driver


        Given("^I open \"([^\"]*)\"") { page: String ->
            println("Launching to $page")
            driver.navigate().to(page)
        }



    }

}