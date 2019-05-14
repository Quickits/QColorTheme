package cn.quickits.rainbow.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import cn.quickits.rainbow.theme.ThemeSwitcher
import kotlinx.android.synthetic.main.fragment_demo.*


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 16:33
 **/
class DemoFragment : Fragment() {

    lateinit var themeSwitcher: ThemeSwitcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        themeSwitcher = ThemeSwitcher(childFragmentManager)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_demo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        themeSwitcher = ThemeSwitcher((activity as AppCompatActivity).supportFragmentManager)
        btn.setOnClickListener {
            themeSwitcher.show()
        }
    }

}