package StepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;

import com.nagarro.nagp.appium.baseClass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {
	private static final Logger log = LogManager.getLogger(BaseClass.class);

	/*
	 * its a hook annotation, running before each scenarios and before any
	 * background scenario. It will initialize the application after closing the
	 * current running instance if exists.
	 */

	@Before
	public void setUp(Scenario scenario) {
		log.info("Starting scenario: " + scenario.getName());

		// Forcefully close the app if it's already running
		if (getDriver() != null) {
			try {
				log.info("Forcefully stopping the app before scenario: " + scenario.getName());
				forceStopApp("com.boopathy.raja.tutorial"); // Replace with your app's package name
			} catch (Exception e) {
				log.error("Error while forcefully stopping the app: " + e.getMessage());
			}
		}

		if (getDriver() == null) {
			initializeApp(); // Ensure the app is initialized before each scenario
		}
	}

	/*
	 * method to take the screen shot if any scenario gets failed and to quite the
	 * driver after the scenario is completed.
	 */
	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			byte[] fileContent = null;
			try {
				fileContent = FileUtils.readFileToByteArray(src);
			} catch (IOException e) {
				e.printStackTrace();
			}
			scenario.attach(fileContent, "image/png", "Failure screen shot");
		}

		if (getDriver() != null) {
			log.info("Quitting the driver after scenario: " + scenario.getName());
			getDriver().quit(); // Ensure the app is closed after each scenario
			driver = null;
		}
	}

	/*
	 * Method to forcefully stop the app using adb command before initiliazing the
	 * new instnace of the app before the scenario
	 */

	private void forceStopApp(String packageName) throws IOException, InterruptedException {
		String command = "adb shell am force-stop " + packageName;
		Process process = Runtime.getRuntime().exec(command);
		process.waitFor();
	}

}
