package StepDefinations;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nagarro.nagp.appium.baseClass.BaseClass;
import com.nagarro.nagp.appium.pages.AnimationPage;
import com.nagarro.nagp.appium.pages.HomePage;
import com.nagarro.nagp.appium.pages.ListViewPage;
import com.nagarro.nagp.appium.pages.PopUpPage;
import com.nagarro.nagp.appium.pages.ViewFlowPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinations extends BaseClass {

	// initialize required page classes
	HomePage homePage = new HomePage(getDriver());
	AnimationPage animationPage = new AnimationPage(getDriver());
	ListViewPage listViewPage = new ListViewPage(getDriver());
	PopUpPage popUpPage = new PopUpPage(getDriver());
	ViewFlowPage viewFlowPage = new ViewFlowPage(getDriver());

	// initialize Log manager
	static Logger log = LogManager.getLogger("StepDefinations");

	public StepDefinations() throws IOException {

	}

	@Given("^Home page is displayed$")

	public void homePageIsDisplayed() {
		Assert.assertTrue(homePage.isHomePageDisplayed());

	}

	@When("^User can close the app$")

	public void closeApp() {
		homePage.closeApp();
	}

	@When("^Animation sub menu page is clicked$")

	public void goToAnimationSubMenu() {
		homePage.selectAndroidUIDesign();
		animationPage.clickAnimationSubMenu();
	}

	@Then("^User can select fade in animation$")

	public void clickFadeInAnimation() {

		Assert.assertTrue(animationPage.isFadeInAnimationsListDisplayed());
	}

	@When("^List view sub menu page is displayed$")

	public void goToListViewSubMenu() {
		homePage.selectAndroidUIDesign();
		listViewPage.clickListViewSubMenu();
		Assert.assertTrue(listViewPage.isSearchableListViewDisplayed());

	}

	@Then("User can search the county {string} in the list")
	public void searchACountry(String country) {
		
		Assert.assertTrue(listViewPage.isAbleToSearchCountry(country));

		getDriver().navigate().back(); // click back button to go to previous page
		getDriver().navigate().back(); // click back button once again to go to home page

		homePage.closeApp();
	}

	@Given("Pop up sub menu is clicked")
	public void goToPopUpSubMenu() {
		homePage.selectAndroidUIDesign();
		popUpPage.clickPopUpSubMenu();
	}

	@And("Pop up options are displayed")
	public void verifyPopUpOptionsDisplayed() {
		popUpPage.isPopUpOptionsDisplayed();

	}

	@When("user selects quickaction menu option")
	public void goToQuickActionMenuOption() {
		popUpPage.selectQuickActionMenuOption();
	}

	@Then("Billa menu item is displayed")
	public void verifyBillaMenuItemDisplayed() {
		assertTrue(popUpPage.isBillaMenuItemDisplayed());

	}

	@When("user selects PopUp menu option")
	public void goToPopUpMenuOption() {
		popUpPage.selectPopUpMenuOption();
	}

	@Then("Music player items are displayed")
	public void verifyMusicPlayerItemsDisplayed() {
		assertTrue(popUpPage.isMusicPlayerItemsDisplayed());

	}

	@When("View flow sub menu page is clicked")
	public void clickViewFlowSubMenubtn() {
		homePage.selectAndroidUIDesign();
		viewFlowPage.clickViewFlowSubMenu();

	}

	@Then("User can see circle flow option on the page")
	public void displayOfAllFlows() {
		Assert.assertTrue(viewFlowPage.isCirclewFlowbtnDisplayed());
	}

}
