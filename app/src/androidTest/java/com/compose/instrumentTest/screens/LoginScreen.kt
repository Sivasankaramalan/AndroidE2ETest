package com.compose.instrumentTest.screens

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.compose.instrumentTest.e2e.BasePage
import com.compose.instrumentTest.helpers.AssertionsHelper

/*
 * @author sivasankaramalan
 * Created On 19/08/23
 */

/** This class is used to perform actions on the Login Screen */

class LoginScreen(composeTestRule: ComposeTestRule) : BasePage(composeTestRule) {

    private val assertionsHelper = AssertionsHelper(composeTestRule)

    private val usernameField = composeTestRule.onNodeWithContentDescription("Username")
    private val passwordField = composeTestRule.onNodeWithContentDescription("Password")
    private val loginButton = composeTestRule.onNodeWithContentDescription("Login Button")


    // This method is used to verify the user is in the Login Screen
    fun verifyUserIsInLoginScreen(expectedScreen: String, expectedToolbarTitle: String) {
        verifyCurrentScreen(expectedScreen, expectedToolbarTitle)
    }

    // This method is used to enter the username
    private fun enterUsername(username: String) {
        assertionsHelper.assertIsDisplayed(usernameField)
        usernameField.performTextInput(username)
    }

    // This method is used to enter the password
    private fun enterPassword(password: String) {
        assertionsHelper.assertIsDisplayed(passwordField)
        passwordField.performTextInput(password)
    }

    // This method is used to click on the Login button
    private fun clickLoginButton() {
        assertionsHelper.assertIsDisplayed(passwordField)
        loginButton.performClick()
    }

    // This method is used to perform the login action
    fun performLogin(username: String, password: String) {
        enterUsername(username)
        enterPassword(password)
        clickLoginButton()
    }
}
