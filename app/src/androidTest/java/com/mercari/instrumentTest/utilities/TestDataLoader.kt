package com.mercari.instrumentTest.utilities

import java.util.*

/**
 * @author sivasankaramalan
 * Created On 20/08/23
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

}
