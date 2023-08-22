package com.compose.instrumentTest.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.compose.instrumentTest.e2e.BasePage

/*
 * @author sivasankaramalan
 * Created On 19/08/23
 */

/**
 * This class is used to perform actions on the Confirm Purchase Screen
 */
class ConfirmPurchaseScreen(private val composeTestRule: ComposeTestRule) : BasePage(composeTestRule) {


    private val paymentInformation = composeTestRule.onNodeWithContentDescription("Payment Information")
    private val shippingInformation = composeTestRule.onNodeWithContentDescription("Shipping Information")
    private val finishButton = composeTestRule.onNodeWithContentDescription("Finish")
    private val orderMessage = composeTestRule.onNodeWithContentDescription("Thank you for your order!")
    private val backHome = composeTestRule.onNodeWithContentDescription("Back Home")

    // This function is used to verify if the user is in the Confirm Purchase screen
    fun verifyUserIsInConfirmPurchaseScreen(expectedScreen: String, expectedToolbarTitle: String) {
        verifyCurrentScreen(expectedScreen, expectedToolbarTitle)
    }

    // This function is used to verify the details in the Confirm Purchase screen
    fun verifyConfirmPurchasePageDetails() {
        paymentInformation.assertIsDisplayed()
        shippingInformation.assertIsDisplayed()
    }

    // This function is used to click on the Finish button
    fun clickFinishButton() {
        finishButton.assertIsEnabled()
        finishButton.performClick()
    }

    // This function is used to verify the order confirmation message
    fun confirmPurchase() {
        orderMessage.assertIsDisplayed()
        backHome.assertIsDisplayed()
    }

    // This function is used to navigate to the Home screen
    fun navigateToHome() {
        backHome.performClick()
    }
}
