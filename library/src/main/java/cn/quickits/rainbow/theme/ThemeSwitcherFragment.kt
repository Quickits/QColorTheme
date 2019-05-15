package cn.quickits.rainbow.theme

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.collection.ArrayMap
import cn.quickits.arch.mvvm.base.BaseFragment
import cn.quickits.rainbow.R
import cn.quickits.rainbow.Rainbow
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.fragment_switcher.*


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 19:19
 **/
class ThemeSwitcherFragment : BaseFragment() {

    private var themePrimaryColor: Int = -1

    private var themeSecondaryColor: Int = -1

    private var isLightStatusBar: Boolean = false

    private var isLightNavigationBar: Boolean = false

    private var arrayMap: ArrayMap<Int, ThemeValue> = ArrayMap()

    override fun bindLayoutId(): Int = R.layout.fragment_switcher

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupChipGroup(
            chip_group_primary,
            ThemeValueResourceProvider.primaryColors,
            intArrayOf(R.attr.colorPrimary),
            ThemeValueResourceProvider.colorDesc,
            true
        ) {
            themePrimaryColor = it?.res ?: -1
            isLightStatusBar = it?.isLightStatusBar ?: false
            isLightNavigationBar = it?.isLightNavigationBar ?: false
        }

        setupChipGroup(
            chip_group_secondary,
            ThemeValueResourceProvider.secondaryColors,
            intArrayOf(R.attr.colorAccent),
            ThemeValueResourceProvider.colorDesc,
            false
        ) {
            themeSecondaryColor = it?.res ?: -1
        }

        fab_apply.setOnClickListener {
            Rainbow.setupThemeOverlays(
                activity,
                intArrayOf(themePrimaryColor, themeSecondaryColor),
                isLightStatusBar,
                isLightNavigationBar
            )
        }
    }

    private fun setupChipGroup(
        chipGroup: ChipGroup,
        colors: Int,
        attr: IntArray,
        descs: Int,
        isPrimary: Boolean,
        select: (ThemeValue?) -> Unit
    ) {
        val colorValues = resources.obtainTypedArray(colors)
        val descValues = resources.obtainTypedArray(descs)

        var checkChipId = -1

        for (i in 0 until colorValues.length()) {
            val primaryValue = colorValues.getResourceId(i, 0)

            val a = context?.obtainStyledAttributes(primaryValue, attr)
            val value = a?.getColor(0, Color.TRANSPARENT) ?: 0
            a?.recycle()

            var isLightStatusBar = false
            var isLightNavigationBar = false

            if (isPrimary) {
                val a2 = context?.obtainStyledAttributes(primaryValue, R.styleable.SystemBarLightMode)
                isLightStatusBar = a?.getBoolean(R.styleable.SystemBarLightMode_isLightStatusBar, false) ?: false
                isLightNavigationBar =
                    a?.getBoolean(R.styleable.SystemBarLightMode_isLightNavigationBar, false) ?: false
                a2?.recycle()
            }

            val chip = layoutInflater.inflate(R.layout.item_theme_value_chip, chipGroup, false) as Chip
            chip.id = primaryValue
            chip.text = descValues.getString(i)
            chip.isCheckable = true
            chip.isCloseIconVisible = false
            chip.isCheckedIconVisible = false
            chip.setTextColor(value)

            when (chipGroup.id) {
                R.id.chip_group_primary -> if (themePrimaryColor == primaryValue) checkChipId = primaryValue
                R.id.chip_group_secondary -> if (themeSecondaryColor == primaryValue) checkChipId = primaryValue
            }

            arrayMap[primaryValue] = ThemeValue(primaryValue, value, isLightStatusBar, isLightNavigationBar)

            chipGroup.addView(chip)
        }

        chipGroup.check(checkChipId)
        chipGroup.setOnCheckedChangeListener { _, id -> select(arrayMap[id]) }

        colorValues.recycle()
        descValues.recycle()
    }

}