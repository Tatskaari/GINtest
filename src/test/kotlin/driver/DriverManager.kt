package driver

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import java.sql.DriverManager
import kotlin.reflect.KClass
import kotlin.test.fail


enum class Drivers {
  FIREFOX {
    override fun driver(): WebDriver {
      WebDriverManager.getInstance(FirefoxDriver::class.java).setup()
      return FirefoxDriver(FirefoxProfile())
    }
  }, CHROME {
    override fun driver(): WebDriver {
      WebDriverManager.getInstance(ChromeDriver::class.java).setup()
      return ChromeDriver()
    }
  };

  abstract fun driver(): WebDriver

  companion object {
    fun getDriver(name: String): Drivers {
      return Drivers.valueOf(name.toUpperCase())
    }
  }

}

object DriverManager {
  private var driver : WebDriver? = null

  fun openBrowser(browser: String) : WebDriver {
    driver = Drivers.getDriver(browser).driver()
    return driver!!
  }

  fun driver(): WebDriver {
    if (driver == null){
      fail("Please open the browser first")
    } else {
      return driver!!
    }
  }
}