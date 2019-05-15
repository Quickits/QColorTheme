package cn.quickits.rainbow

import android.app.Activity
import androidx.annotation.StyleRes
import java.util.*


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 14:35
 **/
object Rainbow {

    @StyleRes
    private var themeOverlays = IntArray(0)

    internal fun setupThemeOverlays(activity: Activity?, themeOverlays: IntArray) {
        if (!Arrays.equals(this.themeOverlays, themeOverlays)) {
            this.themeOverlays = themeOverlays
            activity?.recreate()
        }
    }

    fun applyThemeOverlays(activity: Activity) {
        themeOverlays.forEach { apply(activity, it) }
    }

    private fun apply(activity: Activity, @StyleRes theme: Int) {
        if (theme != -1) activity.setTheme(theme)
    }

}