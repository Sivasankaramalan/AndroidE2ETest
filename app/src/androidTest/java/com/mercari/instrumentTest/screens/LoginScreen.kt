package com.mercari.instrumentTest.screens

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.mercari.instrumentTest.e2e.BasePage
import com.mercari.instrumentTest.helpers.AssertionsHelper

/*
 * @author sivasankaramalan
 * Created On 19/08/23
 */

/** This class is used to perform actions on the Login Screen */

class LoginScreen(composeTestRule: ComposeTestRule) : BasePage(composeTestRule){

    private val assertionsHelper = AssertionsHelper(composeTestRule)

    private val usernameField = composeTestRule.onNodeWithContentDescription("Username")
    private val passwordField = composeTestRule.onNodeWithContentDescription("Password")
    private val loginButton = composeTestRule.onNodeWithContentDescription("Login Button")

    fun verifyUserIsInAddressScreen(expectedScreen: String, expectedToolbarTitle: String) {
        verifyCurrentScreen(expectedScreen, expectedToolbarTitle)
    }

    private fun enterUsername(username: String) {
        assertionsHelper.assertIsDisplayed(usernameField)
        usernameField.performTextInput(username)
    }

    private fun enterPassword(password: String) {
        assertionsHelper.assertIsDisplayed(passwordField)
        passwordField.performTextInput(password)
    }

    private fun clickLoginButton() {
        assertionsHelper.assertIsDisplayed(passwordField)
        loginButton.performClick()
    }

    fun performLogin(username: String, password: String) {
        enterUsername(username)
        enterPassword(password)
        clickLoginButton()
    }
}
