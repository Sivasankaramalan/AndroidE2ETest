package com.compose.instrumentTest.e2e

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule

/*
 * @author sivasankaramalan
 * Created On 22/08/23
 */


/**
 * Base page class for all the screens in the app.
 * This class contains the common actions and assertions that can be performed on any screen.
 */

open class BasePage(private val composeTestRule: ComposeTestRule) {

    /**
     * This method is used to navigate to a specific screen - identified by the screen name
     * @param expectedScreen The screen to which the app should navigate to
     */
    internal fun verifyCurrentScreen(expectedScreen: String, expectedToolbarTitle: String) {

        composeTestRule.onNodeWithContentDescription(expectedScreen).assertExists()

        composeTestRule.onNodeWithText(expectedToolbarTitle).assertExists()

        println("User is in: $expectedScreen")
    }

    /**
     * This method is used to verify if a screen is loaded or not.
     */
    internal fun verifyScreenLoaded(expectedScreenName: String, timeoutMillis: Long = 10000) {
        var elapsedTime = 0
        val retryIntervalMillis = 500

        while (elapsedTime < timeoutMillis) {
            try {
                composeTestRule.onNodeWithContentDescription(expectedScreenName)
                composeTestRule.onNodeWithText(expectedScreenName)

                println("Navigated to: $expectedScreenName")
                return
            } catch (e: Exception) {
                elapsedTime += retryIntervalMillis
            }
        }

        error("Timed out waiting for $expectedScreenName to load")
    }

    /**
    This method is used to get the current screen name
     */
    fun getCurrentScreenName(composeTestRule: ComposeTestRule): String {
        val uniqueElement = composeTestRule.onNodeWithContentDescription("UniqueElementOnThisScreen")
        val screen = uniqueElement
            .assertExists()
            .fetchSemanticsNode().id ?: "Unknown Screen"
        return screen.toString()
    }

    /**
     * This method is used to get the current page header
     */
    fun getCurrentPageHeader(): String {
        return composeTestRule.onNodeWithContentDescription("Header").toString()
    }

}
