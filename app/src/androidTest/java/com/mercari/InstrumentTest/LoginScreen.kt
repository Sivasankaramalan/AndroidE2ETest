package com.mercari.instrumentTest

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick

/**
 * @author sivasankaramalan
 * Created On 19/08/23
 */
class LoginScreen(private val composeTestRule: ComposeTestRule) {
    fun performLogin() {
        composeTestRule.onNodeWithContentDescription("Login").performClick()
    }
}
