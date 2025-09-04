package com.pinnedmode

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import android.os.Build
import android.util.Log
import android.app.ActivityManager
import android.content.Context
import com.facebook.react.bridge.*

@ReactModule(name = PinnedModeModule.NAME)
class PinnedModeModule(reactContext: ReactApplicationContext) :
  NativePinnedModeSpec(reactContext) {

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  override fun enablePinnedMode(promise: Promise) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
      Log.e(TAG, "App Pinning requires Android 5.0 or higher")
      promise.reject("VERSION_ERROR","App Pinning requires Android 5.0 or higher")
      return
    }

    val currentActivity = reactApplicationContext.currentActivity
    if (currentActivity == null) {
      Log.e(TAG, "Current activity is null")
      promise.reject("ACTIVITY_NULL","Current activity is null")
      return
    }

    currentActivity.runOnUiThread {
      try {
        currentActivity.startLockTask()
        Log.d(TAG, "App is now pinned")
        promise.resolve(true)
      } catch (se: SecurityException) {
        Log.e(TAG, "SecurityException: ${se.message}", se)
        promise.reject("SECURITY_ERROR", "Security policy prevents enabling pinning mode", se)
      } catch (e: Exception) {
        Log.e(TAG, "Exception: ${e.message}", e)
        promise.reject("ERROR",e.message)
      }
    }
  }

  /**
   * Disable App Pinning (Lock Task Mode)
   */
  override fun disablePinnedMode(promise: Promise) {
    try {
      Log.d(TAG, "Disabling Pinning Mode...")

      val currentActivity = reactApplicationContext.currentActivity
      if (currentActivity == null) {
        Log.e(TAG, "Current activity is null")
        promise.reject("ACTIVITY_NULL","Current activity is null")
        return
      }

      val am = reactApplicationContext.getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager

      if (am?.lockTaskModeState != ActivityManager.LOCK_TASK_MODE_NONE) {
        Log.d(TAG, "Stopping Lock Task Mode...")
        currentActivity.stopLockTask()
      }

      promise.resolve(true)

    } catch (e: Exception) {
      Log.e(TAG, "Error disabling Pinning Mode: ${e.message}", e)
      promise.reject("ERROR",e.message)
    }
  }

  override fun isPinnedModeActive():Boolean {
    try {
      val am = reactApplicationContext.getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager
      val isPinned = am?.lockTaskModeState != ActivityManager.LOCK_TASK_MODE_NONE
      return isPinned
    } catch (e: Exception) {
      return false
    }
  }


  companion object {
    const val NAME = "PinnedMode"
    const val TAG = "PinnedMode"
  }
}
