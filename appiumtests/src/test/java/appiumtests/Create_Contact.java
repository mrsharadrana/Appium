package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class Create_Contact {
	AppiumDriver<MobileElement> driver;
	@BeforeClass
	public void Setup() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "4.4.2");
		cap.setCapability("deviceName", "KitKat_3.7");
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("appPackage", "com.android.mms");
		cap.setCapability("appActivity", "ui.ComposeMessageActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver(url,cap);
	}
	@Test
	public void create_contact(){
		System.out.println("Inside Create Contact");
		//Enter number by id recipients_editor
		MobileElement Recipient = driver.findElement(By.id("recipients_editor"));
		Recipient.setValue("99999999");
		
		//Enter msg by id embedded_text_editor
		MobileElement Sms_txt = driver.findElement(By.id("embedded_text_editor"));
		Sms_txt.sendKeys("Hello Appium");
		//Click send  button by id send_button_sms
		MobileElement Send_btn = driver.findElement(By.id("send_button_sms"));
		Send_btn.click();
		//Read the msg by id history
		//Delete the msg 
		 
	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}
}

