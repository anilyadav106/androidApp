package com.nagarro.nagp.appium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.nagp.appium.baseClass.BaseClass;
import com.nagarro.nagp.appium.utilitymethods.UtilityMethods;

import io.appium.java_client.AppiumDriver;

public class AnimationPage extends BaseClass {
	private static final Logger log = LogManager.getLogger(BaseClass.class);

	public AnimationPage(AppiumDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.boopathy.raja.tutorial:id/title\" and @text=\"Animations\"]")
	private WebElement animationSubMenu;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.boopathy.raja.tutorial:id/Alpha\"]")
	private WebElement alphaAnimationbtn;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.boopathy.raja.tutorial:id/FadeIn\"]")
	private WebElement fadeinAnimationbtn;

	/*
	 * method to click on the animation sub menu
	 */ public void clickAnimationSubMenu() {
		log.info("Entered into clickAnimationSubMenu method");

		UtilityMethods.explicitlyWaitForElementClick(animationSubMenu);
		log.info("Going to click animation sub menu button");
		animationSubMenu.click();

	}

	/*
	 * method to check whether animation is displayed or not and return the boolean
	 * value
	 */
	public boolean isFadeInAnimationsListDisplayed() {
		log.info("Entered into isFadeInAnimationsListDisplayed method");

		boolean state = false;
		UtilityMethods.explicitlyWaitForElementClick(alphaAnimationbtn);
		if (fadeinAnimationbtn.isDisplayed()) {
			log.info("fade in animation button is displayed");
			state = fadeinAnimationbtn.isDisplayed();
			log.info("Going to click fade in animation button");
			fadeinAnimationbtn.click();

		}

		return state;
	}

}
