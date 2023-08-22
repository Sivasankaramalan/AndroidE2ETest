package com.compose.instrumentTest.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.compose.instrumentTest.e2e.BasePage

/*
 * @author sivasankaramalan
 * Created On 19/08/23
 */

/**
 * This class is used to perform actions on the Cart Screen
 */
class CartScreen(private val composeTestRule: ComposeTestRule) : BasePage(composeTestRule) {

    private val cartIcon = composeTestRule.onNodeWithTag("CartIcon")

    private val firstItem = composeTestRule.onNodeWithText("Sauce Labs Backpack")
    private val secondItem = composeTestRule.onNodeWithContentDescription("Sauce Labs Bolt T-Shirt")
    private val checkout = composeTestRule.onNodeWithText("Proceed to Checkout")


    // This function is used to verify the user is in the Cart Screen
    fun verifyUserIsInCartScreen(expectedScreen: String, expectedToolbarTitle: String) {
        verifyCurrentScreen(expectedScreen, expectedToolbarTitle)
    }

    // This function is used to navigate to the Cart Screen
    fun navigateToCart() {
        cartIcon.performClick()
    }

    // This function is used to verify the item count in the Cart
    fun verifyItemCountInCart(cartItem: String) {
        cartIcon.assertIsDisplayed()
        cartIcon.assertTextEquals(cartItem)
    }

    // This function is used to verify the items in the Cart Screen
    fun verifyItemsInCart(firstItemName: String, secondItemName: String) {
        firstItem.assertIsDisplayed()
        secondItem.assertIsDisplayed()
        firstItem.assertTextEquals(firstItemName)
        secondItem.assertTextEquals(secondItemName)
    }

    // This function is used to start the purchase flow
    fun startPurchase() {
        checkout.assertIsDisplayed()
        checkout.performClick()
    }
}
