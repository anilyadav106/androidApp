
# Cucumber BDD appium automation framework

This is a java based automation framework using cucumber BDD approach to automate the android application.

## Documentation

[Project hierarchy]

The project is based on Maven as a build tool and so all the packages and classes are organized in a proper manner.

The android device used in the automation is 
## Pixel_2_API_27 

so this emulator needs to be created first

---------------------------------

 src/main/java has 4 packages.
 1.baseClass package-It has 1 base class to initialize the appium driver and return the driver object.
 2.Global properties package:-It has 1 class having the configurations
 3.Pages package: It has POM based 5-page classes each for a specific app page
 4. Utility methods package: It has commonly used static methods to re-se them across the framework to enable re-useabillity and easy maintenance.

 /src/main/resources It has 1 .xml file.
 log4j2- It has all the logging setup and required appenders to setup file location, level of log to be captured and patterns of the logs content
 
 /src/test/java –It has 2 folders
 Cucumber options: This is testNG runner file to run any specific scenario with the help of a tag and also it has 2 annoted methods of @BeforeClass and @AfterClass. Here Emulator and Appium servers are started before launching any scenario test. It also ensure that emulator and server starts only once and gets stopped once all scenarios are executed.
 
 StepDefinations:  This folder has 2 classes.   StepDefinations.java: This is the class having the definition or the java implementation of all the steps   defined in the feature files.    Hooks.java: It has 2 hooks annoted methods. @Before method to launch the app before executing the scenario and @AfterStep method to capture screen-shot of the app page after every step and attach to the extent report.

/src/test/resources –It has 2 folders and 2 file.

A. Features folder : Its having 5 feature files and 7 scenarios written in Gherkin language.
1.Animation Page- contains 1 scenario
2.Landing Page- contains 2 scenarios
3.List view Page- contains 1 scenario outline with an example
4.Pop up Page- contains 2 scenarios
5.View Flow Page- contains 1 scenario

B.TestNG Suite Files folder: It has 1 tesng.XML file having one test of the class CucumberTestRunner
C.extent properties file: It has extent report related configuration like file path
D. .APK file of the application 

Logs folder: It has app logs folder . Logs are being captured on daily basis in a separate day-wise file.
Test report folder: Under test-output> SparkReport folder path, the extent report is generated with file name Appium_Test_Report.html


User is free to do required configuration from the configuration file such as -


#appium server
appiumServerIP=127.0.0.1

appiumServerURL=http://127.0.0.1

appiumServerPort:4723

#platform name  
 platformName=Android 
 
 #for emulator 
 androidDeviceName=Pixel_2_API_27

androidEmulatorudid=emulator-5554

androidAutomationName=UiAutomator2

adbExecTimeout=60000

androidVersion=8.1 
## Running Tests

Before running the tests/sceanrios, user can select the required test scenarios to be run usind the provided tags.

There are multiple tags attached in the feature files such as @sanity, @pop-up , @close  , @home etc

In the cucumberTestRunner file, user can provide these tags under the key name "tags"

Below is example to run all those scenarios tagged with @sanity.

Note: All the scenarios are tagged with @sanity tag

------Example started---

@CucumberOptions(features = "src/test/resources/features", glue = "StepDefinations", dryRun = false, plugin = {
		"pretty", "html:target/NAGP_cucumber_report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
tags = "@sanity"

)

------Example ended---


The feature file named "Search Country List View Page.feature" is using scenario outline , which means it has predefind user inputs as example

To run tests,there are 2 ways.

1.Run the following command after going to the project home directory.

Note: Make sure maven is installed on the machine

```bash
  maven test
```


2. In the IDE such as Eclipse IDE, on the project fodler right click and select Run As > Maven Test


## Logs

To check the logs, go to Logs folder under the project home directory

You will see log files created per day wise.

## Prerequisites

Before running the test scenarios , make sure Appium, Node, NPM ,Maven and Java is installed .

Also MAVEN_HOME and JAVA_HOME is set in the system variables of the system on which it will be run.

In the configuration file available under src/main/java folder's package name globalProperties,
 you have to do mention a one time file path of the system specific . This is needed to run the appium server and emulator using the Process class.

 3 paths are needed:-

A.emulatorPath

B.nodePath

C.appiumMainJsPath

 
 Examples:
 
 emulatorPath="C:\\Users\\anilkumar06\\AppData\\Local\\Android\\Sdk\\emulator\\emulator"

nodePath="C:\\Program Files\\nodejs\\node.exe"

appiumMainJsPath="C:\\Users\\anilkumar06\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
 
## Authors

- [@anilkumar](https://www.linkedin.com/in/anilkumarqa/)


## Demo

Insert gif or link to demo


## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`JAVA_HOME`
`ANDROID_HOME`
`MAVEN_HOME`




## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)


## Usage/Examples

```javascript
import Component from 'my-project'

function App() {
  return <Component />
}
```

