package StepDefinitions.WebSteps

import cucumber.api.java8.En
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import kotlin.test.fail

class LaunchBrowser: En {
    init{
        var driver: WebDriver

        fun initializeDriver(browser: String): WebDriver {
            return when (browser) {
                "Firefox" -> FirefoxDriver()
                "Chrome"  -> ChromeDriver()
                else      -> fail("Unsupported Browser") //TODO Create exception for this
            }
        }

        Given("^I launch (Firefox|Chrome) to \"([^\"]*)\"") { browser: String, page: String ->
            println("Launching $browser to $page")
            driver = initializeDriver(browser)
        }


    }
}