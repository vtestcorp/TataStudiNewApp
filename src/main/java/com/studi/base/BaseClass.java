package com.studi.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

public static WebDriver driver;
public static DesiredCapabilities caps; 

	@BeforeTest
	
	public void setUp() throws MalformedURLException, InterruptedException {
	
			caps=new DesiredCapabilities(); 
		
			caps.setCapability(MobileCapabilityType.DEVICE_NAME,"ZY223HQBHZ");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
			caps.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
			caps.setCapability("appPackage", "com.tce.studi");
			caps.setCapability("appActivity", "com.tce.view.ui.activities.SplashScreenActivity");
		
			
		
		String appiumserverURL="http://127.0.0.1:4723/wd/hub"; 
		URL url=new URL(appiumserverURL);
		driver = new AppiumDriver<MobileElement>(url, caps);
		Thread.sleep(2000);
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//		wait.withTimeout(10, TimeUnit.SECONDS);
//	
	}
	public static WebDriver getDriver() {
		return (WebDriver) driver; 
	}
	
}
