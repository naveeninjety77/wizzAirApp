**Project Structure:**
src
 └── test
      ├── java
      │    ├── base
      │    │     ├── drivers
      │    │     │      ├── Driver.java
      │    │     │      └── DriverManager.java
      │    │     ├── utils
      │    │     │      ├── WaitUtils.java
      │    │     │      ├── ScrollUtils.java
      │    │     │      └── ConfigReader.java
      │    │
      │    ├── pages
      │    ├── stepdefinitions
      │    ├── hooks
      │    └── runners
      │
      └── resources
           ├── features
           └── config.properties

**This project is a cross-platform mobile automation framework built using:**
-- Java
--Appium 
--Cucumber (BDD)
--TestNG
--Maven
--SLF4J Logging

**Steps to flow for Setup**
-- Install Jave 17 or above
-- Install Maven
-- Install Node.js (Required for Appium)
-- Install Appium (Required for Appium server setup)
-- Clone the repo (https://github.com/naveeninjety77/wizzAirApp/tree/wizzAirAppTest)
-- Update the Config file(according to Real Device or Emulator)
-- Confirm the Platform in the XML and run it
