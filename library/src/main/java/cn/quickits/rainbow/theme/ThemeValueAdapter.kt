package cn.quickits.rainbow.theme

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.quickits.rainbow.R
import cn.quickits.rainbow.Rainbow
import kotlinx.android.synthetic.main.item_theme_value.view.*


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 17:47
 **/
class ThemeValueAdapter : RecyclerView.Adapter<ThemeValueAdapter.ThemeValueViewHolder>() {

    var list: List<ThemeValue>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeValueViewHolder {
        return ThemeValueViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_theme_value,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list?.size ?: 0

    override fun onBindViewHolder(holder: ThemeValueViewHolder, position: Int) {
        val value = list?.get(position) ?: return

        holder.itemView.text.setTextColor(value.value)
        holder.itemView.btn.setOnClickListener {
            Rainbow.themePrimaryColor = value.res
            Rainbow.apply(it.context as Activity)
        }
    }

    inner class ThemeValueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}