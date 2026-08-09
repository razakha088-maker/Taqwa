package com.taqwa.guard.accessibility

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class TaqwaAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Screen monitoring will be added in the next step.
    }

    override fun onInterrupt() {
        // Service interrupted by the system.
    }
}
