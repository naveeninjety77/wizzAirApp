# 📱 WizzAir Mobile Automation Framework
 
A scalable, cross-platform **mobile test automation framework** built using industry-standard tools and best practices.
 
Designed to support **Android and iOS** automation using BDD architecture and a clean Page Object Model structure.
 
---
 
## 🚀 Tech Stack
 
- ☕ Java 17+

- 📦 Maven

- 🤖 Appium

- 🥒 Cucumber (BDD)

- 🧪 TestNG

- 📝 SLF4J Logging
 
---
 
## 🏗️ Framework Architecture
 
This framework follows a clean layered structure:
 
```

src

└── test

    ├── java

    │   ├── base

    │   │   ├── drivers

    │   │   │   ├── Driver.java

    │   │   │   └── DriverManager.java

    │   │   ├── utils

    │   │   │   ├── WaitUtils.java

    │   │   │   ├── ScrollUtils.java

    │   │   │   └── ConfigReader.java

    │   ├── pages

    │   ├── stepdefinitions

    │   ├── hooks

    │   └── runners

    └── resources

        ├── features

        └── config.properties

```
 
---
 
## ⚙️ Prerequisites
 
Make sure the following are installed:
 
- Java 17 or higher  

- Maven  

- Node.js  

- Appium (installed globally)
 
### Verify Installations
 
```bash

java -version

mvn -version

node -v

npm -v

appium -v

```
 
---
 
## 📥 Clone the Repository
 
```bash

git clone https://github.com/naveeninjety77/wizzAirApp.git

cd wizzAirApp

git checkout wizzAirAppTest

```
 
---
 
## 🔧 Configuration
 
Update:
 
```

src/test/resources/config.properties

```
 
Modify values based on:
 
- Platform (Android / iOS)

- Real Device or Emulator

- Device Name

- Platform Version

- App Path

- Appium Server URL
 
### Example Configuration
 
```

platformName=Android

deviceName=emulator-5554

platformVersion=14

automationName=UiAutomator2

app=/path/to/app.apk

```
 
---
 
## ▶️ How to Run Tests
 
### 1️⃣ Start Appium Server
 
```bash

appium

```
 
### 2️⃣ Confirm Platform in `testng.xml`
 
Ensure correct platform parameters are configured.
 
### 3️⃣ Execute Tests
 
```bash

mvn clean test

```
 
Or run directly using the TestNG runner from your IDE.
 
---
 
## 🧪 BDD Execution Flow
 
1. Feature file defines scenario  

2. Step Definition implements steps  

3. Hooks initialize driver  

4. Page Objects perform actions  

5. TestNG executes scenarios  
 
---
 
## 📊 Logging
 
Logging is implemented using SLF4J for clean and structured logging output.
 
---
 
## 🌟 Key Features
 
- ✅ Cross-platform support (Android & iOS)

- ✅ Page Object Model design

- ✅ Config-driven execution

- ✅ BDD implementation

- ✅ Scalable architecture

- ✅ Clean separation of concerns

- ✅ Maven build management
 
---
 
## 👨‍💻 Author
 
**Naveen Injety**
 
---
 
⭐ If you find this framework helpful, feel free to star the repository!
GitHub - naveeninjety77/wizzAirApp
Contribute to naveeninjety77/wizzAirApp development by creating an account on GitHub.
 
