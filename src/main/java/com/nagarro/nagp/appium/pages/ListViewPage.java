package com.nagarro.nagp.appium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.nagp.appium.baseClass.BaseClass;
import com.nagarro.nagp.appium.utilitymethods.UtilityMethods;

import io.appium.java_client.AppiumDriver;

public class ListViewPage extends BaseClass {
	private static final Logger log = LogManager.getLogger(BaseClass.class);

	public ListViewPage(AppiumDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.boopathy.raja.tutorial:id/title\" and @text=\"ListView\"]")
	private WebElement listViewSubMenu;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.boopathy.raja.tutorial:id/List_SearchableListView\"]")
	private WebElement searchableListViewbtn;

	@FindBy(id = "com.boopathy.raja.tutorial:id/listview_search")
	private WebElement searchCountrybtn;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.boopathy.raja.tutorial:id/listview_seacrh_text\"]")
	private WebElement searchedCountryName;

	/*
	 * method to click on the list view sub menu
	 */
	public void clickListViewSubMenu() {
		log.info("Entered into clickListViewSubMenu method");

		UtilityMethods.explicitlyWaitForElementClick(listViewSubMenu);
		log.info("Going to click list view sub menu button");
		listViewSubMenu.click();
		log.info("clicked list view sub menu button");

	}

	/*
	 * method to check if searchable list view page is displayed or not and to
	 * return the boolean value
	 */
	public boolean isSearchableListViewDisplayed() {
		log.info("Entered into isSearchableListViewDisplayed method");

		boolean state = false;
		UtilityMethods.explicitlyWaitForElementClick(searchableListViewbtn);
		if (searchableListViewbtn.isDisplayed()) {
			state = searchableListViewbtn.isDisplayed();
			log.info("going to click searchable list view button");
			searchableListViewbtn.click();
			log.info(" searchable list view button is clicked");
		}

		return state;
	}

	/*
	 * method to check if the desired country is searched or not and to return the
	 * boolean value
	 */
	public boolean isAbleToSearchCountry(String country) {
		log.info("Entered into isAbleToSearchCountry method for :" + country);

		boolean state = false;
		UtilityMethods.explicitlyWaitForWebElement(searchCountrybtn);
		log.info("Going to click search country button");
		searchCountrybtn.click();

		log.info("going to enter country name " + country);
		searchCountrybtn.sendKeys(country);
		log.info("country name " + country + " is entered");

		if (searchCountrybtn.isDisplayed()) {
			state = searchedCountryName.getText().equals(country);
			log.info("Entered country " + country + " is same as expected");

		}
		return state;
	}

}
