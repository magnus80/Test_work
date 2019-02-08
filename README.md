# Test_work
1. Example web application provides REST API that make available to execute CRUD operations with an "User" entities, that are persisted in the in-memory Derby database. 
   REST API is configured in com.peterservice.example.camel.restjdbc.ExampleUsersRouteConfiguration class. 
   
   U can to start that app by typing **mvn jetty:run** at your console (be sure that 28080 port is free).
2. clone project from github using command https://github.com/magnus80/Test_work.git
3. Open current test project
4. Make sure you have Lombok plugin installed and processing annotations is switched on
 (see https://www.jetbrains.com/help/idea/compiler-annotation-processors.html) 
5. in terminal type **gradlew clean testApis** (**./gradlew clean testApis** for Mac and Linux) or
 call **testApis** task from gradle right panel
6. After finishing tests call allureServe task  from gradle right panel
    
  
