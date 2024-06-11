package com.nagarro.nagp.appium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.nagp.appium.baseClass.BaseClass;
import com.nagarro.nagp.appium.utilitymethods.UtilityMethods;

import io.appium.java_client.AppiumDriver;

public class HomePage extends BaseClass {
	private static final Logger log = LogManager.getLogger(BaseClass.class);

	public HomePage(AppiumDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "android:id/action_bar_title")
	private WebElement androidUiDesignBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='OPTIONS']")
	private WebElement optionsBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Welcome!']")
	private WebElement welcomeTxt;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title' and @text='Exit']")
	private WebElement exitBtn;

	/*
	 * method to click on the android UI design sub menu
	 */
	public void selectAndroidUIDesign() {
		log.info("Entered into selectAndroidUIDesign method");

		UtilityMethods.explicitlyWaitForElementClick(androidUiDesignBtn);
		log.info("androidUiDesignBtn button is going to be clicked");
		androidUiDesignBtn.click();
		log.info("androidUiDesignBtn button  clicked");

	}

	/*
	 * method to check if home page is displayed or not and to return the boolean
	 * value
	 */
	public boolean isHomePageDisplayed() {
		log.info("Entered into isHomePageDisplayed method");

		boolean state = false;
		UtilityMethods.explicitlyWaitForWebElement(welcomeTxt);
		log.info("welcome text message is displayed");

		state = welcomeTxt.isDisplayed();
		return state;
	}

	/*
	 * method to close the app from the option menu using exit button
	 */
	public void closeApp() {
		log.info("Entered into closeApp method");

		UtilityMethods.explicitlyWaitForElementClick(optionsBtn);
		log.info("Going to click option button");

		optionsBtn.click();
		log.info("option button is clicked");

		UtilityMethods.explicitlyWaitForElementClick(exitBtn);
		log.info("going to click on exit button  ");

		exitBtn.click();
		log.info("exit  button is clicked");

	}

}
