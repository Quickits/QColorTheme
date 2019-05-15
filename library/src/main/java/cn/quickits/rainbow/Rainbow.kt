package cn.quickits.rainbow

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
import androidx.annotation.StyleRes
import java.util.*
import android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 14:35
 **/
object Rainbow {

    @StyleRes
    private var themeOverlays = IntArray(0)

    private var isLightStatusBar = false

    private var isLightNavigationBar = false

    internal fun setupThemeOverlays(
        activity: Activity?,
        themeOverlays: IntArray,
        isLightStatusBar: Boolean,
        isLightNavigationBar: Boolean
    ) {
        if (!Arrays.equals(this.themeOverlays, themeOverlays)) {
            this.themeOverlays = themeOverlays
            this.isLightStatusBar = isLightStatusBar
            this.isLightNavigationBar = isLightNavigationBar
            activity?.recreate()
        }
    }

    fun applyThemeOverlays(activity: Activity) {
        themeOverlays.forEach { apply(activity, it) }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isLightStatusBar) {
                activity.window.decorView.systemUiVisibility.let {
                    activity.window.decorView.systemUiVisibility = it or SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            } else {
                activity.window.decorView.systemUiVisibility.let {
                    activity.window.decorView.systemUiVisibility = it and SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (isLightNavigationBar) {
                activity.window.navigationBarColor = Color.WHITE
                activity.window.decorView.systemUiVisibility.let {
                    activity.window.decorView.systemUiVisibility = it or SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                }
            } else {
                activity.window.decorView.systemUiVisibility.let {
                    activity.window.decorView.systemUiVisibility = it and SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
                }
            }
        }
    }

    private fun apply(activity: Activity, @StyleRes theme: Int) {
        if (theme != -1) activity.setTheme(theme)
    }

}