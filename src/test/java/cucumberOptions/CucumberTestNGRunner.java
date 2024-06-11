package cucumberOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.nagarro.nagp.appium.utilitymethods.TestResultHandler;
import com.nagarro.nagp.appium.utilitymethods.UtilityMethods;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "StepDefinations", dryRun = false, plugin = {
		"pretty", "html:target/NAGP_cucumber_report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
tags = "@animation"

)

public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {

	static Properties prop = UtilityMethods.loadPropertyFile();

	private static Process appiumProcess;
	private static Process emulatorProcess;

	@BeforeClass
	public static void setUp() {
		TestResultHandler.archivePreviousResults();

		startEmulator();
		startAppiumServer();

	}

	@AfterClass
	public static void tearDown() {
		TestResultHandler.storeTestResults();

		stopAppiumServer();
		stopEmulator();

	}

	/*
	 * method to start the emulator
	 */ private static void startEmulator() {
		if (emulatorProcess == null) {
			try {
				System.out.println("Starting Emulator...");
				String emulatorPath = prop.getProperty("emulatorPath");
				String avdName = prop.getProperty("androidDeviceName");
				ProcessBuilder builder = new ProcessBuilder(emulatorPath, "-avd", avdName);
				builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
				builder.redirectError(ProcessBuilder.Redirect.INHERIT);
				emulatorProcess = builder.start();
				BufferedReader reader = new BufferedReader(new InputStreamReader(emulatorProcess.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
					if (line.contains("boot completed")) {
						break;
					}
				}
				emulatorProcess.waitFor(30, TimeUnit.SECONDS);
				System.out.println("Emulator started.");
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * method to stop the emulator
	 */

	private static void stopEmulator() {
		if (emulatorProcess != null) {
			System.out.println("Stopping Emulator...");
			emulatorProcess.destroy();
			try {
				emulatorProcess.waitFor(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			emulatorProcess = null;

			System.out.println("Emulator stopped.");
		}
	}

	/*
	 * method to start the appium server on the desired IP address and port no
	 */ private static void startAppiumServer() {
		if (appiumProcess == null) {
			try {
				System.out.println("Starting Appium Server...");
				String nodePath = prop.getProperty("nodePath");
				String appiumMainJsPath = prop.getProperty("appiumMainJsPath");
				String ipAddress = prop.getProperty("appiumServerIP");
				String port = prop.getProperty("appiumServerPort");
				ProcessBuilder builder = new ProcessBuilder(nodePath, appiumMainJsPath, "--address", ipAddress,
						"--port", port);
				builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
				builder.redirectError(ProcessBuilder.Redirect.INHERIT);
				appiumProcess = builder.start();
				BufferedReader reader = new BufferedReader(new InputStreamReader(appiumProcess.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
					if (line.contains("Appium REST http interface listener started on")) {
						break;
					}
				}
				appiumProcess.waitFor(30, TimeUnit.SECONDS);
				System.out.println("Appium Server started.");
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * method to stop the emulator
	 */ private static void stopAppiumServer() {
		if (appiumProcess != null) {
			System.out.println("Stopping Appium Server...");
			appiumProcess.destroy();
			try {
				appiumProcess.waitFor(30, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			appiumProcess = null;
			System.out.println("Appium Server stopped.");
		}
	}

}
