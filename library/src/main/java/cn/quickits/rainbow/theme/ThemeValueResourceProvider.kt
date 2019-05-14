package cn.quickits.rainbow.theme

import androidx.annotation.ArrayRes
import cn.quickits.rainbow.R

object ThemeValueResourceProvider {

    @ArrayRes
    var primaryColors: Int = R.array.mtrl_primary_palettes

    @ArrayRes
    var secondaryColors: Int = R.array.mtrl_secondary_palettes

    @ArrayRes
    val colorDesc: Int = R.array.mtrl_palettes_content_description

}