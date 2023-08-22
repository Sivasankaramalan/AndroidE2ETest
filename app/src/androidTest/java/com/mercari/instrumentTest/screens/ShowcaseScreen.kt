package com.mercari.instrumentTest.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.mercari.instrumentTest.e2e.BasePage
import com.mercari.instrumentTest.helpers.AssertionsHelper

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

    fun verifyUserIsInAddressScreen(expectedScreen: String, expectedToolbarTitle: String) {
        verifyCurrentScreen(expectedScreen, expectedToolbarTitle)
    }

    fun verifyHomePage(text: String) {
        productsHeader.assertExists()
        swagLabText.assertIsDisplayed()
        swagLabText.assertTextEquals(text)

    }

    fun verifyItemList() {
        firstItem.assertExists()
        secondItem.assertExists()
    }

    fun selectItemFirstItm(contentDescription: String, index: Int) {
        val item = composeTestRule.onNodeWithContentDescription("$contentDescription $index")
        item.assertExists()
        item.performClick()
    }

    fun addItemToCart() {
        addToCart.performClick()
    }

    fun navigateBack() {
        navigateUp.performClick()
    }

}
