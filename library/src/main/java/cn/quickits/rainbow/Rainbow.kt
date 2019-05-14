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
    internal var themePrimaryColor: Int = -1

    @StyleRes
    internal var themeSecondaryColor: Int = -1

    internal fun setupThemeOverlays(activity: Activity?, themePrimaryColor: Int, themeSecondaryColor: Int) {
        this.themePrimaryColor = themePrimaryColor
        this.themeSecondaryColor = themeSecondaryColor

        activity?.recreate()
    }

    fun applyThemeOverlays(activity: Activity) {
        apply(activity, themePrimaryColor)
        apply(activity, themeSecondaryColor)
    }

    private fun apply(activity: Activity, @StyleRes theme: Int) {
        if (theme != -1) activity.setTheme(theme)
    }

}