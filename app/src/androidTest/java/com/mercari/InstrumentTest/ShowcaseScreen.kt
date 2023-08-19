package com.mercari.instrumentTest

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick

/**
 * @author sivasankaramalan
 * Created On 19/08/23
 */
class ShowcaseScreen(private val  composeTestRule: ComposeTestRule) {

    fun openItem(itemName: String) {
        composeTestRule.onNodeWithText(itemName).performClick()
    }

    fun addItemToCart() {
        composeTestRule.onNodeWithText("Add to Cart").performClick()
    }

    fun navigateBack() {
        composeTestRule.onNodeWithContentDescription("Navigate Up").performClick()
    }

}
