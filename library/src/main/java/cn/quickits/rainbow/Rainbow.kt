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
    private var themeOverlays: Array<Int> = emptyArray()

    fun setThemeOverlays(activity: Activity?) {
        activity ?: return

        themeOverlays =
            arrayOf(R.style.ThemeOverlay_PrimaryPalette_Blue, R.style.ThemeOverlay_SecondaryPalette_BlueGrey)

        activity.recreate()
    }

    fun applyThemeOverlays(activity: Activity) {
        for (themeOverlay in themeOverlays) {
            activity.setTheme(themeOverlay)
        }
    }

}