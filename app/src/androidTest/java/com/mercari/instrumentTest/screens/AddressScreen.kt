package com.mercari.instrumentTest.screens

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput

/**
 * @author sivasankaramalan
 * Created On 19/08/23
 */
class AddressScreen(private  val composeTestRule: ComposeTestRule) {

    fun completeAddress(address: String) {
        composeTestRule.onNodeWithText("Address Line 1").performTextInput(address)
        composeTestRule.onNodeWithText("Continue").performClick()
    }

}
