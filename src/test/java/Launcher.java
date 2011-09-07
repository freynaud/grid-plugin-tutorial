import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Launcher {

  
  public static void main(String[] args) throws MalformedURLException {
    RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.firefox());
    driver.get("http://localhost:4444/grid/console");
    driver.quit();
    
  }
}
