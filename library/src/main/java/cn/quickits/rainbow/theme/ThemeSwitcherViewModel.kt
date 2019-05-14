package cn.quickits.rainbow.theme

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import cn.quickits.arch.mvvm.QLceViewModel
import cn.quickits.rainbow.R


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 17:17
 **/
class ThemeSwitcherViewModel : QLceViewModel<List<ThemeValue>>() {

    fun load(context: Context, resource: Resources) {
        displayLoader(false)

        val primaryValues = resource.obtainTypedArray(ThemeValueResourceProvider.primaryColors)

        val list = arrayListOf<ThemeValue>()

        for (i in 0 until primaryValues.length()) {
            val primaryValue = primaryValues.getResourceId(i, 0)
            val attr = IntArray(1)
            attr[0] = R.attr.colorPrimary
            val a = context.obtainStyledAttributes(primaryValue, attr)
            val value = a.getColor(0, Color.TRANSPARENT)
            a.recycle()
            list.add(ThemeValue(primaryValue, value))
        }

        primaryValues.recycle()


        content.value = list
    }

}