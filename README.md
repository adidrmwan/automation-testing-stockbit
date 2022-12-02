# AUTOMATION TESTING - JAVA

System Under Test:
1. Android
2. API

Features:
1. REST API using rest-assured
2. Junit
3. Cucumber
4. Appium for Android

## Prerequisites
* [JDK 11](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)
* [Git](https://git-scm.com/downloads)
* [Intellij IDEA](https://www.jetbrains.com/idea/download/)
* [Gradle](https://gradle.org/install/)
* [Appium Desktop](https://github.com/appium/appium-desktop)
* [Android Studio](https://developer.android.com/studio)
* [Virtual Device](https://developer.android.com/studio/run/managing-avds)
* [ADB](https://developer.android.com/studio/command-line/adb)

## Getting started
1. Clone the repository
2. Start android emulator or connect with real device

## Intellij Plugin
### Cucumber for Java
Add IntelliJ Cucumber for Java plugin:

* Open `Preferences` (⌘ + ,)
* Go to `Plugins > Marketplace`
* Search for `Cucumber for Java` and Install

### Lombok Plugin
Add IntelliJ Cucumber for Java plugin:
* Open `Preferences` (⌘ + ,)
* Go to `Plugins > Marketplace`
* Search for `Lombok` and Install

## Running the Test
* To execute API Test cases
  > ./gradlew clean cucumber --tags @Api generateCucumberReports

* To execute Android Test cases
  > ./gradlew clean cucumber --tags @Android generateCucumberReports

## Report
* Find the reporting file on `build/customreport/overview-features.html`
* Open the reporting file in browser

## Documentations
* https://appium.io/docs/en/about-appium/getting-started/?lang=en
* https://www.guru99.com/introduction-to-appium.html