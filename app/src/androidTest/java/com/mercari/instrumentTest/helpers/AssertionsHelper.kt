package com.mercari.instrumentTest.helpers

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule

/*
 * @author sivasankaramalan
 * Created On 21/08/23
 */

/**
 * This class contains all the custom assertions that are used in the tests, which are not available in the compose library.
 **/
class AssertionsHelper(private val composeTestRule: ComposeTestRule) {


    // This is a custom assertion to check if a node is displayed on the screen
    fun assertIsDisplayed(contentDescription: SemanticsNodeInteraction) {
        composeTestRule.onNodeWithContentDescription(contentDescription.toString()).assertExists()
        composeTestRule.onNodeWithContentDescription(contentDescription.toString()).assertIsDisplayed()
    }

    // This is a custom assertion to check if a node is enabled on the screen
    fun assertTextEquals(expectedText: String) {
        composeTestRule.onNodeWithText(text = expectedText).assertExists()
        composeTestRule.onNodeWithText(text = expectedText).assertTextEquals(expectedText)
    }

    // This is a custom assertion to check if a node is enabled on the screen and has the expected text
    fun assertTextEquals(expectedText: String, contentDescription: String) {
        composeTestRule.onNodeWithText(text = expectedText).assertExists()
        composeTestRule.onNodeWithText(text = expectedText).assertTextEquals(expectedText)
    }

    // This is a custom assertion to check if a text contains on the object
    fun assertTextContains(expectedSubstring: String, contentDescription: String) {
        composeTestRule.onNodeWithText(hasText(expectedSubstring).toString()).assertExists()
        composeTestRule.onNodeWithText(hasText(expectedSubstring).toString()).assertTextContains(expectedSubstring)
    }


}
