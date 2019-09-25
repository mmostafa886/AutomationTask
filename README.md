# AutomationTask

## 1. Introduction
   - This reposirtory is supposed to contain the developed script for the task (Devloping 6 test cases to test the provided android apk)
   - The project has been eveloped using (Java, Selenium, Appium & TestNG) 
   - All the needed resources has been attached to the project (The APK to be tested & the test data file [Data.csv])

## 2. Environment Needs
  - OS that accepts installing Java (although we used Windows in our case but so far all the famous OSs (Windows, Mac, Linux) support Java)
  - Java JDK (needs to be nstalled & the JAVA_HOME environment variabale must be defined)
  - Android SDK (Needs to be installed & the ANDROID_HOME environment variable must be defined)
  - Development IDE (In our case, we used Eclipse but we can use anyother one like IntelliJ)
  - Project Mangement tools (Maven, to manage the project dependancies & enable getting the project running whatever the user OS environment)

## 3. Running Tests
  - Open the IDE (Eclipse)
  - Use the github repository URL (https://github.com/mmostafa886/AutomationTask.git) to clone the project
  - After cloning the project, Right click on it >> Maven >> Update Project
  - Expand the folder (Data) & open the (Numbers.csv) file
  - Provide the numbers to be used as test data (NOTE: what ever the number of rows that are intended to be used as test data, it is mandatory to provide 2 numbers per row)
  - For whatever the used OS, The user can run the tests by

     - Expand the package (src/test/java/mobile.AutomationTask)
     - Open the class (AppTest) & right click inside it
     - Select (Run As) >> (TestNG test)
     - The same can be performed by Right click on the (TestNG.xml) file >> Select Run As >> TestNG test
  - For Windows only, Right click on the batch file (Run_Test.bat) & select (Run As Administartor) without openeing the the IDE will run the test cases with the same manner like the previous config

## 4. Viewing Test Report
   After executing the tests (either form the IDE or from the batch file) navigate to ([Project_Folder]/test-output/emailable-report.html) to view the test results
