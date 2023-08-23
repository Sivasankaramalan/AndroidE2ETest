package com.compose.instrumentTest.e2e

import android.util.Log
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

        Log.d("ScreenVerification", "User is in: $expectedScreen")
    }

    /**
     * This method is used to verify if a screen is loaded or not.
     */
    internal fun verifyScreenLoaded(
        composeTestRule: ComposeTestRule,
        expectedScreenName: String,
        timeoutMillis: Long,
        retryIntervalMillis: Long
    ) {
        val startTime = System.currentTimeMillis()
        var elapsedTime = 0L

        while (elapsedTime < timeoutMillis) {
            try {
                composeTestRule.onNodeWithContentDescription(expectedScreenName)
                composeTestRule.onNodeWithText(expectedScreenName)

                Log.d("ScreenVerification", "Navigated to: $expectedScreenName")
                return
            } catch (e: Exception) {
                elapsedTime = System.currentTimeMillis() - startTime
                Thread.sleep(retryIntervalMillis)
            }
        }
        Log.e("ScreenVerification", "Failed to navigate to: $expectedScreenName within timeout")
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
