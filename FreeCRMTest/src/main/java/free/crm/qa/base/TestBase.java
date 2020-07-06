package free.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		
		
		prop = new Properties();   //Import Properties Class from Java.util
		
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\RSS\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {	
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}


    public static void initialization()
    {
    	
    	String browserName = prop.getProperty("browser");
    	
    	if (browserName.equals("chrome"))
    	{
    		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSS\\Ravi\\chromedriver_win32 (6)\\chromedriver.exe");
    			 driver = new ChromeDriver();
    	} else if (browserName.equals("IE"))
    	{
    		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSS\\Ravi\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
    	}
    	
  //Creating Objects for WebDriverEventListener
    	e_driver = new EventFiringWebDriver(driver);
    	
    	eventListener = new WebEventListener();
    	e_driver.register(eventListener);
    	driver = e_driver;
    	
    	
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 
	 driver.get(prop.getProperty("url"));
	 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);  //Here were hardcoding the timeOut to 20. Lets update these values in Test.util
	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);   //Here were hardcoding the timeOut to 30. Lets update these values in Test.util
	 }
}

