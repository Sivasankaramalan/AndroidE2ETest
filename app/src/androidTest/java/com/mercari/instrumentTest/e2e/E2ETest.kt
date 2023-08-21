package com.mercari.instrumentTest.e2e

import androidx.compose.ui.test.junit4.createComposeRule
import com.mercari.instrumentTest.helpers.AssertionsHelper
import com.mercari.instrumentTest.screens.*
import com.mercari.instrumentTest.testdata.TestData
import com.mercari.instrumentTest.utilities.TestDataLoader
import org.junit.Rule
import org.junit.Test

/**
 * @author sivasankaramalan
 * Created On 19/08/23
 */
class E2ETest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val testData = TestDataLoader


    @Test
    fun testLoginFlow() {
        val loginScreen = LoginScreen(composeTestRule)

        composeTestRule.setContent {
            loginScreen.performLogin(testData.username, testData.password)

        }
    }

    @Test
    fun testPurchaseFlow() {
        val loginScreen = LoginScreen(composeTestRule)
        val showcaseScreen = ShowcaseScreen(composeTestRule)
        val cartScreen = CartScreen(composeTestRule)
        val addressScreen = AddressScreen(composeTestRule)
        val confirmPurchaseScreen = ConfirmPurchaseScreen(composeTestRule)

        composeTestRule.setContent {
            // Simulate login
            loginScreen.performLogin(testData.username, testData.password)

            // Simulate opening the first item
            showcaseScreen.openItem("Item 1")
            showcaseScreen.addItemToCart()

            // Go back to Showcase Screen
            showcaseScreen.navigateBack()

            // Add the second item to the cart
            showcaseScreen.openItem("Item 2")
            showcaseScreen.addItemToCart()

            // Start the purchase flow
            cartScreen.startPurchase()

            // Complete the address form
            addressScreen.completeAddress("123 Main St")

            // Finish the purchase and verify success
            confirmPurchaseScreen.confirmPurchase()
            // Use assertions to verify the success message or other expected behavior
        }
    }
}
