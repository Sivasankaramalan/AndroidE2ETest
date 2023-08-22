Project File Structure
---------------

````
- app
    - src
        - androidTest
            - java
                - com.compose.instrumentTest
                    - e2e
                        - BasePage.kt
                        - E2ETest.kt
                    - helpers
                        - AssertionsHelpter.kt
                    - objects
                        - AddressScreenLocators.kt
                    - screens
                        - AddressScreen.kt
                        - CartScreen.kt
                        - ConfirmPurchaseScreen.kt
                        - LoginScreen.kt
                        - ShowCaseScreen.kt
                    - testdata
                        - TestData.kt
                    - utilities
                        - TestDataLoader.kt
            - resources
                - testdata.properties
````
Project File Structure Description
---------------

The project is structured in a way that it is easy to maintain and extend. 
The file structure is as follows:

    1. e2e - Contains all the test classes
    2. helpers - Contains all the helper classes
    3. objects - Contains all the object classes
    4. screens - Contains all the screen classes
    5. testdata - Contains all the test data classes
    6. utilities - Contains all the utility classes
    7. testdata.properties - Contains all the test data


Execution Steps
---------------
1. Clone the project from the repository
2. Open the project in Android Studio or IntelliJ
3. Open the e2e folder
4. Right-click on the E2ETest.kt file and click on Run 'E2ETest'
