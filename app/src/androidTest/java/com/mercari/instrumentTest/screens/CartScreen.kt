package com.mercari.instrumentTest.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.mercari.instrumentTest.e2e.BasePage

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


    fun verifyUserIsInAddressScreen(expectedScreen: String, expectedToolbarTitle: String) {
        verifyCurrentScreen(expectedScreen, expectedToolbarTitle)
    }

    fun navigateToCart() {
        cartIcon.performClick()
    }

    fun verifyItemCountInCart(cartItem: String) {
        cartIcon.assertIsDisplayed()
        cartIcon.assertTextEquals(cartItem)
    }

    fun verifyItemsInCart(firstItemName: String, secondItemName: String) {
        firstItem.assertIsDisplayed()
        secondItem.assertIsDisplayed()
        firstItem.assertTextEquals(firstItemName)
        secondItem.assertTextEquals(secondItemName)


    }

    fun startPurchase() {
        checkout.assertIsDisplayed()
        checkout.performClick()
    }
}
