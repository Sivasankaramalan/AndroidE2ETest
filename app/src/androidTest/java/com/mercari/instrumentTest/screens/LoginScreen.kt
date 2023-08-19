package com.mercari.instrumentTest.screens

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput

/**
 * @author sivasankaramalan
 * Created On 19/08/23
 */
class LoginScreen(private val composeTestRule: ComposeTestRule) {
    fun performLogin(username: String, password: String) {
        composeTestRule.onNodeWithContentDescription("Username")
            .performTextInput(username)
        composeTestRule.onNodeWithContentDescription("Password")
            .performTextInput(password)
        composeTestRule.onNodeWithContentDescription("Login Button")
            .performClick()
    }
}
