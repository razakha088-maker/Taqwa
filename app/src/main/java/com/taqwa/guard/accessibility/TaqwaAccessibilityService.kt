package com.taqwa.guard

import android.accessibilityservice.AccessibilityService
import android.graphics.Color
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.view.accessibility.AccessibilityEvent

class TaqwaAccessibilityService : AccessibilityService() {

    private var windowManager: WindowManager? = null
    private var blurView: View? = null

    override fun onServiceConnected() {
        super.onServiceConnected()
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Service is intentionally passive for now.
        //
        // Later:
        // Female gender-content detection -> showBlur()
        // male gender content -> hideBlur()
    }

    override fun onInterrupt() {
        hideBlur()
    }

    private fun showBlur() {
        if (blurView != null) return

        val view = View(this).apply {
            setBackgroundColor(Color.argb(235, 0, 0, 0))
        }

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.TYPE_ACCESSIBILITY_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            PixelFormat.TRANSLUCENT
        )

        params.gravity = Gravity.TOP or Gravity.START

        try {
            windowManager?.addView(view, params)
            blurView = view
        } catch (_: Exception) {
            blurView = null
        }
    }

    private fun hideBlur() {
        blurView?.let { view ->
            try {
                windowManager?.removeView(view)
            } catch (_: Exception) {
            }
        }

        blurView = null
    }

    override fun onDestroy() {
        hideBlur()
        windowManager = null
        super.onDestroy()
    }
}
