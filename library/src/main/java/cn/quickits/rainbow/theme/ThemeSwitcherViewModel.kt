package cn.quickits.rainbow.theme

import android.content.res.Resources
import cn.quickits.arch.mvvm.QLceViewModel


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 17:17
 **/
class ThemeSwitcherViewModel : QLceViewModel<List<ThemeValue>>() {

    fun load(resource: Resources) {
        displayLoader(false)

        val primaryValues = resource.obtainTypedArray(ThemeValueResourceProvider.primaryColors)
        val secondaryValues = resource.obtainTypedArray(ThemeValueResourceProvider.secondaryColors)

        val list = arrayListOf<ThemeValue>()

        for (i in 0 until primaryValues.length()) {
            val primaryValue = primaryValues.getResourceId(i, 0)
            val secondaryValue = secondaryValues.getResourceId(i, 0)

            list.add(ThemeValue(primaryValue, secondaryValue))
        }

        primaryValues.recycle()
        secondaryValues.recycle()

        content.value = list
    }

}