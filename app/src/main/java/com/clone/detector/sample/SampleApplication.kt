package com.clone.detector.sample

import android.app.Application
import android.util.Log
import com.clone.detector.AppCloneDetector

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCloneDetector.create(this)
            .enableKillApp()
            .onCloningDetect {
                Log.d("CLONE", "Clone detected!")
            }.start()
    }
}