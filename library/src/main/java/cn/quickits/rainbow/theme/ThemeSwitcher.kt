package cn.quickits.rainbow.theme

import androidx.fragment.app.FragmentManager


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 14:41
 **/
class ThemeSwitcher(private val fragmentManager: FragmentManager) {

    fun show() {
        ThemeSwitcherDialogFragment().show(fragmentManager, "theme-switcher")
    }

}