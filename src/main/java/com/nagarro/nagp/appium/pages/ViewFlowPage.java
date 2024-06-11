package com.nagarro.nagp.appium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.nagp.appium.baseClass.BaseClass;
import com.nagarro.nagp.appium.utilitymethods.UtilityMethods;

import io.appium.java_client.AppiumDriver;

public class ViewFlowPage extends BaseClass {
	private static final Logger log = LogManager.getLogger(BaseClass.class);

	public ViewFlowPage(AppiumDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.boopathy.raja.tutorial:id/title\" and @text=\"ViewFlow\"]")
	private WebElement viewFlowSubMenu;

	@FindBy(id = "com.boopathy.raja.tutorial:id/ViewFlow_Circle")
	private WebElement circleFlowbtn;
	@FindBy(id = "com.boopathy.raja.tutorial:id/ViewFlow_Circle")
	private WebElement lineFlowIndbtn;
	@FindBy(id = "com.boopathy.raja.tutorial:id/ViewFlow_Circle")
	private WebElement scrollingTabbtn;
	@FindBy(id = "com.boopathy.raja.tutorial:id/ViewFlow_Circle")
	private WebElement sweipybtn;
	@FindBy(id = "com.boopathy.raja.tutorial:id/ViewFlow_Circle")
	private WebElement titleFlowbtn;

	/*
	 * method to click on the view flow sub menu
	 */
	public void clickViewFlowSubMenu() {
		log.info("Entered into clickViewFlowSubMenu method");

		log.info("Going to click list view flow sub menu button");
		viewFlowSubMenu.click();
		log.info("clicked view flow ub menu button");

	}

	/*
	 * method to check if circle flow button is displayed or not and to return the
	 * boolean value
	 */
	public boolean isCirclewFlowbtnDisplayed() {
		log.info("Entered into isAllViewFlowbtnDisplayed method");
		UtilityMethods.explicitlyWaitForElementClick(circleFlowbtn);
		return circleFlowbtn.isDisplayed();
	}

}
