package com.nagarro.nagp.appium.baseClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.nagarro.nagp.appium.utilitymethods.UtilityMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	protected static AndroidDriver driver; // declare android driver
	private static URL url; // initialize Log manager
	public static Properties prop; // initialize Properties class variable
	private static final Logger log = LogManager.getLogger(BaseClass.class); // declare and initialize Log manager

	/*
	 * static method to initialize the app and return the appium driver instance
	 */
	public static AndroidDriver initializeApp() {

		Properties prop = UtilityMethods.loadPropertyFile();
		log.info("Going to set the desired capabilities on the server");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", prop.getProperty("platformName"));
		cap.setCapability("platformVersion", prop.getProperty("androidVersion"));
		cap.setCapability("deviceName", prop.getProperty("androidDeviceName"));
		cap.setCapability("automationName", prop.getProperty("automationName"));
		cap.setCapability("appPackage", prop.getProperty("appPackage"));
		cap.setCapability("appActivity", prop.getProperty("appActivity"));
		cap.setCapability("noReset", "false"); // Ensures the app data is cleared between sessions
		cap.setCapability("fullReset", true); // Ensures a fresh app is installed for each session
		cap.setCapability("uiautomator2ServerInstallTimeout", "60000");
		cap.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/Android_UI_Design-1.0.1.apk");
		cap.setCapability("udid", prop.getProperty("androidEmulatorudid"));
		cap.setCapability("adbExecTimeout", prop.getProperty("adbExecTimeout"));
		cap.setCapability("autoGrantPermissions", true);

		try {
			url = new URL("http://127.0.0.1:4723"); // loading URL of appium server
			log.info("Appium Driver initialized successfully");

		} catch (MalformedURLException e) {

			System.out.println(e.getMessage());
			log.error("Malformed URL: ", e);

		}

		catch (Exception e) {
			log.error("Error initializing Appium Driver: ", e);
		}

		/* created android driver class object and provided URL and Cap */

		driver = new AndroidDriver(url, cap);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		System.out.println("Android app is launched successfully.");
		return driver;
	}

	/*
	 * static method to return the initialized driver
	 */ public static AppiumDriver getDriver() {

		return driver;
	}

}
