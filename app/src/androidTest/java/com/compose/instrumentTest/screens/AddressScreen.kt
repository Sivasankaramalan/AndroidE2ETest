package com.compose.instrumentTest.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.compose.instrumentTest.e2e.BasePage
import com.compose.instrumentTest.objects.AddressScreenLocators

/*
 * @author sivasankaramalan
 * Created On 19/08/23
 */

/**
 * This class contains all the actions that can be performed on the Address screen
 */
class AddressScreen(private val composeTestRule: ComposeTestRule) : BasePage(composeTestRule) {


    // This function is used to verify if the user is in the Address screen
    fun verifyUserIsInAddressScreen() {
        composeTestRule.onNodeWithContentDescription("Navigate to Address Screen").performClick()
        verifyCurrentScreen("Address Screen", "Address")
    }

    // This function is used to verify the details in the Address screen
    fun verifyAddressPageDetails() {
        with(AddressScreenLocators) {
            composeTestRule.onNodeWithText(firstName).assertExists()
            composeTestRule.onNodeWithText(lastName).assertExists()
            composeTestRule.onNodeWithText(city).assertExists()
            composeTestRule.onNodeWithText(zipCode).assertExists()
            composeTestRule.onNodeWithText(continueButton).assertExists()
        }
    }

    // This function is used to enter the details in the Address screen
    fun completeAddress(firstNameInput: String, lastNameInput: String, cityInput: String, zipCodeInput: String) {
        with(AddressScreenLocators) {
            composeTestRule.onNodeWithText(firstName).assertIsEnabled()
            composeTestRule.onNodeWithText(firstName).performTextInput(firstNameInput)
            composeTestRule.onNodeWithText(firstName).performTextInput(lastNameInput)
            composeTestRule.onNodeWithText(firstName).performTextInput(cityInput)
            composeTestRule.onNodeWithText(firstName).performTextInput(zipCodeInput)
        }
    }

    // This function is used to click on the Continue button
    fun clickContinueButton() {
        with(AddressScreenLocators) {
            composeTestRule.onNodeWithText(continueButton).assertIsEnabled()
            composeTestRule.onNodeWithText(continueButton).performClick()
        }
    }

}
