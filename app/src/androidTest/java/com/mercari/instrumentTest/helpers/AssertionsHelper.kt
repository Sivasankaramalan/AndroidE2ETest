package com.mercari.instrumentTest.helpers

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule

/**
 * @author sivasankaramalan
 * Created On 21/08/23
 */

class AssertionsHelper(private val composeTestRule: ComposeTestRule) {

    fun assertTextEquals(expectedText: String) {
        composeTestRule.onNodeWithText(text = expectedText).assertExists()
        composeTestRule.onNodeWithText(text = expectedText).assertTextEquals(expectedText)
    }

    fun assertTextEquals(expectedText: String, contentDescription: String) {
        composeTestRule.onNodeWithText(text = expectedText).assertExists()
        composeTestRule.onNodeWithText(text = expectedText).assertTextEquals(expectedText)
    }

    fun assertTextContains(expectedSubstring: String, contentDescription: String) {
        composeTestRule.onNodeWithText(hasText(expectedSubstring).toString()).assertExists()
        composeTestRule.onNodeWithText(hasText(expectedSubstring).toString()).assertTextContains(expectedSubstring)
    }

    fun assertIsDisplayed(contentDescription: String) {
        composeTestRule.onNodeWithContentDescription(contentDescription).assertExists()
        composeTestRule.onNodeWithContentDescription(contentDescription).assertIsDisplayed()
    }

    fun assertIsSelected(contentDescription: String) {
        composeTestRule.onNodeWithContentDescription(contentDescription).assertExists()
        composeTestRule.onNodeWithContentDescription(contentDescription).assertIsSelected()
    }
}
