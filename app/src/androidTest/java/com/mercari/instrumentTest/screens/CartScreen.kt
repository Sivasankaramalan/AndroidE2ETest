package com.mercari.instrumentTest.screens

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick

/**
 * @author sivasankaramalan
 * Created On 19/08/23
 */
class CartScreen(private  val  composeTestRule: ComposeTestRule) {

    fun startPurchase() {
        composeTestRule.onNodeWithText("Proceed to Checkout").performClick()
    }
}
