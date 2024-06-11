package com.nagarro.nagp.appium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.nagp.appium.baseClass.BaseClass;
import com.nagarro.nagp.appium.utilitymethods.UtilityMethods;

import io.appium.java_client.AppiumDriver;

public class PopUpPage extends BaseClass {
	private static final Logger log = LogManager.getLogger(BaseClass.class);

	public PopUpPage(AppiumDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.boopathy.raja.tutorial:id/title' and @text='PopUp']")
	private WebElement popUpSubMenu;

	@FindBy(xpath = "//android.widget.Button[@resource-id='com.boopathy.raja.tutorial:id/PopUp_Menu']")
	private WebElement popUpOption;
	@FindBy(id = "com.boopathy.raja.tutorial:id/PopUp_MenuFull")
	private WebElement showPopUpButton;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.boopathy.raja.tutorial:id/tv_title' and @text='Play']")
	private WebElement playPopUpMusicButton;

	@FindBy(xpath = "//android.widget.Button[@resource-id='com.boopathy.raja.tutorial:id/PopUp_QuickAction']")
	private WebElement quickActionOption;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1' and @text='Billa']")
	private WebElement billaQuickActionOption;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.boopathy.raja.tutorial:id/title' and @text='Play']")
	private WebElement playQuickActionMusicButton;

	/*
	 * method to click on the pop-up sub menu button
	 */
	public void clickPopUpSubMenu() {
		log.info("Entered into clickPopUpSubMenu method");

		UtilityMethods.explicitlyWaitForElementClick(popUpSubMenu);
		log.info("Going to click pop-up sub menu button");
		popUpSubMenu.click();
		log.info("popup menu option is clicked");

	}

	/*
	 * Method to verify that both the pop-up options are displayed and return the
	 * boolean value
	 */
	public boolean isPopUpOptionsDisplayed() {
		log.info("Entered into isPopUpOptionsDisplayed method");

		boolean state = false;
		UtilityMethods.explicitlyWaitForElementClick(popUpOption);
		if (popUpOption.isDisplayed() && quickActionOption.isDisplayed()) {
			log.info("Both popup options are displayed");

			state = true;

		}

		return state;
	}

	/*
	 * method to select quick action pop-up option
	 */
	public void selectQuickActionMenuOption() {
		log.info("Entered into selectQuickActionMenuOption method");
		quickActionOption.click();
		log.info("clicked quick action");
		UtilityMethods.explicitlyWaitForWebElement(billaQuickActionOption);

	}

	/*
	 * method to select pop-up option
	 */
	public void selectPopUpMenuOption() {
		log.info("Entered into selectPopUpMenuOption method");

		UtilityMethods.explicitlyWaitForElementClick(popUpOption);
		log.info("Going to click on pop-up option button");
		popUpOption.click();
		log.info("clicked on pop-up option ");
		UtilityMethods.explicitlyWaitForElementClick(showPopUpButton);

	}

	/*
	 * Method to verify that billa menu item is displayed and clickable and return
	 * the boolean value
	 */ public boolean isBillaMenuItemDisplayed() {
		log.info("Entered into isBillaMenuItemDisplayed method");

		boolean state = false;
		UtilityMethods.explicitlyWaitForElementClick(billaQuickActionOption);
		if (billaQuickActionOption.isDisplayed()) {
			log.info("Going to click on bill QuickAction Option button");

			billaQuickActionOption.click();
			log.info("clicked on bill QuickAction Option button");

			state = playQuickActionMusicButton.isDisplayed();

		}

		return state;
	}

	/*
	 * Method to verify that music buttons are displayed for popup menu option and
	 * return the boolean value
	 */ public boolean isMusicPlayerItemsDisplayed() {
		log.info("Entered into isMusicPlayerItemsDisplayed method");
		boolean state = false;
		UtilityMethods.explicitlyWaitForElementClick(showPopUpButton);
		showPopUpButton.click();
		state = playPopUpMusicButton.isDisplayed();

		return state;
	}

}
