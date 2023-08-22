package com.compose.instrumentTest.utilities

import java.util.*

/*
 * @author sivasankaramalan
 * Created On 20/08/23
 */

/**
 * This is the data loader class which loads the test data from the properties file
 */
object TestDataLoader {

    private val properties: Properties by lazy {
        val inputStream = javaClass.classLoader?.getResourceAsStream("testdata.properties")
        Properties().apply {
            load(inputStream)
        }
    }

    val username: String
        get() = properties.getProperty("username")

    val password: String
        get() = properties.getProperty("password")

    val homePageTitle: String
        get() = properties.getProperty("home_page_title")

    val firstItem: String
        get() = properties.getProperty("firstItem")

    val secondItem: String
        get() = properties.getProperty("secondItem")

    val ItemsInCart: String
        get() = properties.getProperty("cartItem")

    val firstName: String
        get() = properties.getProperty("firstName")

    val lastName: String
        get() = properties.getProperty("lastName")

    val city: String
        get() = properties.getProperty("city")

    val zipCode: String
        get() = properties.getProperty("zipCode")

}
