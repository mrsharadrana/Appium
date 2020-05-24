package appiumtests;



import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Appium_Connection {

	static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) {
		try {
			set_Capability();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * {
	 * "platformName": "Android", 
	 * "platformVersion": "4.0.4", 
	 * "deviceName":"3.7_IceCream",
	 * "automationName": "UiAutomator1",
	 * "appPackage":"com.android.calculator2",
	 * "appActivity":"com.android.calculator2.Calculator" 
	 *   }
	 */
	private static void set_Capability() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "4.4.2");
		cap.setCapability("deviceName", "KitKat_3.7");
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
	
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver(url,cap);
		System.out.println("Trying to Run");
	}


}
