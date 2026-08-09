package com.taqwa.guard.accessibility

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.util.Log

class TaqwaAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event == null) return

        when (event.eventType) {
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED,
            AccessibilityEvent.TYPE_WINDOWS_CHANGED -> {
                Log.d("TaqwaProtection", "Window changed")
            }
        }
    }

    override fun onInterrupt() {
        Log.d("TaqwaProtection", "Service interrupted")
    }
}
