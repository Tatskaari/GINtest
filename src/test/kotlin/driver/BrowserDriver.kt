package driver

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.sql.DriverManager
import kotlin.reflect.KClass


enum class Drivers(val driverClass: KClass<out WebDriver>) {
  FIREFOX(FirefoxDriver::class), CHROME(ChromeDriver::class);

  fun driver(): WebDriver {
    WebDriverManager.getInstance(driverClass.java).setup()
    return driverClass.java.newInstance()
  }

  companion object {
    fun getDriver(name: String): Drivers {
      return Drivers.valueOf(name.toUpperCase())
    }
  }

}

object BrowserDriver {
  val driver = Drivers.getDriver(System.getProperty("browser.driver")).driver()
}