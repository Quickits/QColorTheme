package cn.quickits.rainbow.theme

import android.graphics.Color
import android.os.Bundle
import android.view.View
import cn.quickits.arch.mvvm.base.BaseFragment
import cn.quickits.rainbow.R
import cn.quickits.rainbow.Rainbow
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.fragment_switcher2.*


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 19:19
 **/
class ThemeSwitcherFragment2 : BaseFragment() {

    override fun bindLayoutId(): Int = R.layout.fragment_switcher2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupChipGroup(
            chip_group_primary,
            ThemeValueResourceProvider.primaryColors,
            intArrayOf(R.attr.colorPrimary)
        ) {
            Rainbow.themePrimaryColor = it.res
        }

        setupChipGroup(
            chip_group_secondary,
            ThemeValueResourceProvider.secondaryColors,
            intArrayOf(R.attr.colorAccent)
        ) {
            Rainbow.themeSecondaryColor = it.res
        }

        fab_apply.setOnClickListener {
            Rainbow.apply(activity)
        }
    }

    private fun setupChipGroup(chipGroup: ChipGroup, colors: Int, attr: IntArray, select: (ThemeValue) -> Unit) {
        val primaryValues = resources.obtainTypedArray(colors)

        for (i in 0 until primaryValues.length()) {
            val primaryValue = primaryValues.getResourceId(i, 0)

            val a = context?.obtainStyledAttributes(primaryValue, attr)
            val value = a?.getColor(0, Color.TRANSPARENT) ?: 0
            a?.recycle()

            val chip = Chip(context)
            chip.isCheckable = true
            chip.text = "Hello"
            chip.tag = ThemeValue(primaryValue, value)
            chip.setTextColor(value)
            chip.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    select(buttonView.tag as ThemeValue)
                }
            }

            chipGroup.addView(chip)
        }

        primaryValues.recycle()
    }

}