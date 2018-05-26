package driver

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import java.sql.DriverManager
import kotlin.reflect.KClass


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
  val driver = run {
    val driverName = try {
      System.getProperty("browser.driver")!!
    } catch (e: Exception) {
      "chrome"
    }
    Drivers.getDriver(driverName).driver()
  }
}