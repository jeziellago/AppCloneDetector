# App Clone Detector
## How it works?
<img src="logo.png" width="80">

Kill app if it is running under a cloned environment in Android device.

*App cloning is nothing but a technique which allows you to run two different instances of an android app at the same time.*
> A cloned app can never function the same as the originally installed apps. The main problems comes in while accessing the internal or external storage from cloned application.
## Configuration
Add `AppCloneDetector` to your Application:
```kotlin
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppCloneDetector.create(this)
            .enableKillApp() // kill app on cloning detect
            .onCloningDetect {
                // do something on clone detect
            }.start()
    }
}
```
### Add dependency
- Project `build.gradle`
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
- Module `build.gradle`
```
dependencies {
    implementation 'com.github.jeziellago:AppCloneDetector:0.1.0'
}
```

> This solution is inspired by [Siddhant Panhalkar](https://proandroiddev.com/preventing-android-app-cloning-e3194269bcfa)
