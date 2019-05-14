package cn.quickits.rainbow

import android.app.Activity
import androidx.annotation.StyleRes


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 14:35
 **/
object Rainbow {

    @StyleRes
    internal var themePrimaryColor: Int = 0

    @StyleRes
    internal var themeSecondaryColor: Int = 0

    internal fun apply(activity: Activity?) {
        activity?.recreate()
    }

    fun applyThemeOverlays(activity: Activity) {
        apply(activity, themePrimaryColor)
        apply(activity, themeSecondaryColor)
    }

    private fun apply(activity: Activity, @StyleRes theme: Int) {
        if (theme != 0) activity.setTheme(theme)
    }

}