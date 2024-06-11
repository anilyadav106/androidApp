package com.nagarro.nagp.appium.utilitymethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nagarro.nagp.appium.baseClass.BaseClass;

public class UtilityMethods extends BaseClass {

	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
	static FileInputStream file;
	static Properties prop;
	InputStream dataIs;

	/*
	 * static method to wait for visibility of mobile web element
	 */
	public static void explicitlyWaitForWebElement(WebElement we) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(we));

	}

	/*
	 * static method to wait for click ability of mobile web element
	 */
	public static void explicitlyWaitForElementClick(WebElement we) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}

	/*
	 * static method to load the property file and get the values
	 */
	public static Properties loadPropertyFile() {

		/* read properties file */
		String propertiesPath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";

		try {
			file = new FileInputStream(propertiesPath);

		} catch (FileNotFoundException e1) {
			System.out.println("Some issue in reading property file");
			e1.printStackTrace();
		}

		try {
			prop = new Properties();
			prop.load(file);
		} catch (IOException e) {
			System.out.println("Some issue in loading property file");
			e.printStackTrace();
		}
		return prop;
	}

}
