# Test_work
This project covers by tests example web application. 
File project structure
 .gitignore - files which doesn't push to repo
 build.gradle - file with project dependencies
 README.md - file with project description
src/main/java
1) /condition - folder with conditional helper classes 
2) /dataBase - folder to work with DB
2) /entity - folder with user class
3) /service - folder with all kinds of API methods
4) ApiResponse - class for response methods
src/main/resourses
1) logback.xml - file with formatting logback logger
src/test/java/work:
1) .BaseTest.java - base test class
2) .test*.java - test classes
src/test/resourses
1) .allure-prperties - allure properties file
2) .testng-APIs.xml - configurative file to run test task

1. Example web application provides REST API that make available to execute CRUD operations with an "User" entities, that are persisted in the in-memory Derby database. 
   REST API is configured in com.peterservice.example.camel.restjdbc.ExampleUsersRouteConfiguration class. 
   
   U can to start that app by typing **mvn jetty:run** at your console (be sure that 28080 port is free).
2. Сlone project from github using command https://github.com/magnus80/Test_work.git
3. Open current test project
4. Make sure you have Lombok plugin installed and processing annotations is switched on
 (see https://www.jetbrains.com/help/idea/compiler-annotation-processors.html) 
5. In terminal type **gradlew clean testApis** in Windows (**./gradlew clean testApis** for Mac and Linux) or
 call **testApis** task from gradle right panel
6. After finishing tests call allureServe task  from gradle right panel
    
  
