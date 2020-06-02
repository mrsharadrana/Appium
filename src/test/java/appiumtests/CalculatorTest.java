package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {
	AppiumDriver<MobileElement> driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Set up desired capabilities and pass the Android app-activity and app-package
		// to Appium
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "4.4.2");
		cap.setCapability("deviceName", "KitKat_3.7");
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver(url, cap);
	}

	@Test
	public void testCal() throws Exception {
		// locate the Text on the calculator by using By.id()
		MobileElement two = driver.findElement(By.id("digit2"));
		two.click();
		MobileElement plus = driver.findElement(By.id("plus"));
		plus.click();
		MobileElement four = driver.findElement(By.id("digit4"));
		four.click();
		MobileElement delete = driver.findElement(By.id("delete"));
		delete.click();
		MobileElement seven = driver.findElement(By.id("digit7"));
		seven.click();
		MobileElement equalTo = driver.findElement(By.id("equal"));
		equalTo.click();
		// locate the edit box of the calculator by using By.tagName()
		// WebElement results=driver.findElement(By.tagName("EditText"));
		MobileElement results = driver.findElement(By.className("android.widget.EditText"));
		// Check the calculated value on the edit box
		assert results.getText().equals("6") : "Actual value is : " + results.getText()
				+ " did not match with expected value: 6";
		System.out.println("Result is :- " + results.getText());

	}

	@AfterClass
	public void teardown() {
		// close the app
		driver.quit();
	}
}