package com.mercari.instrumentTest

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

/**
 * @author sivasankaramalan
 * Created On 19/08/23
 */
class E2ETest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testPurchaseFlow() {
        val loginScreen = LoginScreen(composeTestRule)

        composeTestRule.setContent {
            loginScreen.performLogin()

        }
    }
}
