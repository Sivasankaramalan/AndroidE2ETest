package com.compose.instrumentTest.e2e

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.test.espresso.Root
import androidx.test.platform.app.InstrumentationRegistry
import com.compose.instrumentTest.helpers.saveScreenshot
import com.compose.instrumentTest.screens.*
import com.compose.instrumentTest.utilities.TestDataLoader
import org.junit.Assert
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

/*
 * @author sivasankaramalan
 * Created On 19/08/23
 */

/**
 * This is an example of an end-to-end test that simulates a user flow.
 * It is not meant to be a comprehensive test, but rather a simple example of how to use the
 * testing framework.
 *
 * This test will:
 * 1. Login
 * 2. Add two items to the cart
 * 3. Start the purchase flow
 * 4. Complete the address form
 * 5. Finish the purchase and verify success
 */
class E2ETest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val testData = TestDataLoader

    private val base = BasePage(composeTestRule)

    private val currentScreenName = base.getCurrentScreenName(composeTestRule)
    private val pageHeader = base.getCurrentPageHeader()
    private val timeOut: Long = 10000
    private val retryInterval: Long = 1000

    // Context of the app under test.
    private fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.mercari.e2etest", appContext.packageName)
    }

    @Before
    fun testLoginFlow() {
        val loginScreen = LoginScreen(composeTestRule)

        useAppContext()
        composeTestRule.setContent {
            loginScreen.performLogin(testData.username, testData.password)
        }
    }

    @BeforeClass
    fun verifyPageProperties() {
        base.verifyCurrentScreen(currentScreenName, pageHeader)
        base.verifyScreenLoaded(composeTestRule, currentScreenName, timeOut, retryInterval)
        saveScreenshot("ScreenName", node = composeTestRule.onRoot())
    }


    @Test()
    fun testPurchaseFlow() {
        val showcaseScreen = ShowcaseScreen(composeTestRule)
        val cartScreen = CartScreen(composeTestRule)
        val addressScreen = AddressScreen(composeTestRule)
        val confirmPurchaseScreen = ConfirmPurchaseScreen(composeTestRule)

        composeTestRule.setContent {
            // verify the home page
            showcaseScreen.verifyHomePage(testData.homePageTitle)

            // Verify the Showcase Screen Items
            showcaseScreen.verifyItemList()

            // Opening the first item
            showcaseScreen.selectItemFirstItm(testData.firstItem, 1)

            // Adding the item to the cart
            showcaseScreen.addItemToCart()

            // Go back to Showcase Screen
            showcaseScreen.navigateBack()

            // Add the second item to the cart
            showcaseScreen.selectItemFirstItm(testData.secondItem, 2)

            // Adding the item to the cart
            showcaseScreen.addItemToCart()

            // Go back to Showcase Screen
            showcaseScreen.navigateBack()

            // Verify the items in the cart
            cartScreen.verifyItemCountInCart(testData.ItemsInCart)

            // Navigate to the cart
            cartScreen.navigateToCart()

            // Verify the items in the cart
            cartScreen.verifyItemsInCart(testData.firstItem, testData.secondItem)

            // Start the purchase flow
            cartScreen.startPurchase()

            // Verify the address page
            addressScreen.verifyAddressPageDetails()

            // Complete the address form
            addressScreen.completeAddress(testData.firstName, testData.lastName, testData.city, testData.zipCode)

            // Click on continue button
            addressScreen.clickContinueButton()

            // Verify the confirm purchase page
            confirmPurchaseScreen.verifyConfirmPurchasePageDetails()

            // Finish the purchase and verify success
            confirmPurchaseScreen.clickFinishButton()

            // Verify the success message
            confirmPurchaseScreen.confirmPurchase()

            // Navigate to home page
            confirmPurchaseScreen.navigateToHome()
        }
    }

}
