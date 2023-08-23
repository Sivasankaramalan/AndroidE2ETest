package com.compose.instrumentTest.helpers

import android.graphics.Bitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.captureToImage
import androidx.test.platform.app.InstrumentationRegistry
import java.io.FileOutputStream

/**
 * @author sivasankaramalan
 * Created On 23/08/23
 */

fun saveScreenshot(
    fileNamePrefix: String,
    node: SemanticsNodeInteraction
) {
    val bitmap = node
        .captureToImage()
        .asAndroidBitmap()
    saveScreenshot(
        fileName = fileNamePrefix + System.currentTimeMillis().toString(),
        bitmap = bitmap
    )
}

private fun saveScreenshot(
    fileName: String,
    bitmap: Bitmap
) {
    val path = InstrumentationRegistry
        .getInstrumentation()
        .targetContext
        .filesDir
        .canonicalPath
    FileOutputStream("$path/$fileName.png").use { out ->
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
    }
    println("Saved screenshot to $path/$fileName.png")
}
