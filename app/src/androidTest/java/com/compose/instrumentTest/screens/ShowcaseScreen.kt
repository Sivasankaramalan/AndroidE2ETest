package com.compose.instrumentTest.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.compose.instrumentTest.e2e.BasePage

/*
 * @author sivasankaramalan
 * Created On 19/08/23
 */

/**
 * This class is used to perform actions on the Showcase Screen
 */
class ShowcaseScreen(private val composeTestRule: ComposeTestRule) : BasePage(composeTestRule) {


    private val productsHeader = composeTestRule.onNodeWithText("Products")
    private val swagLabText = composeTestRule.onNodeWithContentDescription("Swag Labs")
    private val addToCart = composeTestRule.onNodeWithText("Add to Cart")
    private val navigateUp = composeTestRule.onNodeWithContentDescription("Navigate Up")
    private val firstItem = composeTestRule.onNodeWithContentDescription("Item 0")
    private val secondItem = composeTestRule.onNodeWithContentDescription("Item 1")


    // This function is used to verify the user is in Showcase Screen
    fun verifyUserIsInShowcaseScreen(expectedScreen: String, expectedToolbarTitle: String) {
        verifyCurrentScreen(expectedScreen, expectedToolbarTitle)
    }

    // This function is used to verify the home page details
    fun verifyHomePage(text: String) {
        productsHeader.assertExists()
        swagLabText.assertIsDisplayed()
        swagLabText.assertTextEquals(text)

    }

    // This function is used to verify the item list
    fun verifyItemList() {
        firstItem.assertExists()
        secondItem.assertExists()
    }

    // This function is used to select the item
    fun selectItemFirstItm(contentDescription: String, index: Int) {
        val item = composeTestRule.onNodeWithContentDescription("$contentDescription $index")
        item.assertExists()
        item.performClick()
    }

    // This function is used to add the item to cart
    fun addItemToCart() {
        addToCart.performClick()
    }

    // This function is used to navigate back
    fun navigateBack() {
        navigateUp.performClick()
    }

}
