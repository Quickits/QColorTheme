package cn.quickits.rainbow.util


import android.content.SharedPreferences
import android.content.ContentValues
import android.content.Context
import android.content.Context.MODE_PRIVATE


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-15 11:43
 **/
class PreferenceUtils(ctx: Context) {

    private var preference: SharedPreferences = ctx.applicationContext.getSharedPreferences("rainbow", MODE_PRIVATE)

    fun putString(key: String, value: String): Boolean {
        return preference.edit().putString(key, value).commit()
    }

    fun putInt(key: String, value: Int): Boolean {
        return preference.edit().putInt(key, value).commit()
    }

    fun putBoolean(key: String, value: Boolean): Boolean {
        return preference.edit().putBoolean(key, value).commit()
    }

    fun putValues(values: ContentValues): Boolean {
        val editor = preference.edit()
        for ((key, value1) in values.valueSet()) {
            editor.putString(key, value1.toString())
        }
        return editor.commit()
    }

    fun getString(key: String): String? {
        return getString(key, "")
    }

    fun getString(key: String, defValue: String): String? {
        return preference.getString(key, defValue)
    }

    fun getInt(key: String): Int {
        return getInt(key, -1)
    }

    fun getInt(key: String, defValue: Int): Int {
        return preference.getInt(key, defValue)
    }

    fun getBoolean(key: String): Boolean {
        return getBoolean(key, false)
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return preference.getBoolean(key, defValue)
    }

    companion object {

        private var INSTANCE: PreferenceUtils? = null

        fun getInstance(context: Context): PreferenceUtils {
            return INSTANCE ?: synchronized(PreferenceUtils::class.java) {
                INSTANCE ?: PreferenceUtils(context)
            }
        }

    }

}