package com.clone.detector

import android.content.Context

private const val APP_ID_999 = "999"

class AppCloneDetector private constructor(private val context: Context) {

    private var shouldKillApp = false
    private var onCloningDetect: () -> Unit = {}

    fun onCloningDetect(action: () -> Unit) = apply { onCloningDetect = action }

    fun enableKillApp() = apply { shouldKillApp = true }

    fun start() = with(context) {
        val appPath = filesDir.path
        if (appPath.contains(APP_ID_999) || (appPath.countDots() > packageName.countDots())) {
            onCloningDetect()
            if (shouldKillApp) killApp()
        }
    }

    private fun String.countDots(): Int {
        return this.split(".").size
    }

    private fun killApp() {
        throw UnsupportedOperationException("App should not run in cloned environment!")
    }

    companion object {
        @JvmStatic
        fun create(context: Context) = AppCloneDetector(context)
    }
}