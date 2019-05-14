package cn.quickits.rainbow.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import cn.quickits.arch.mvvm.QLceViewFragment
import cn.quickits.arch.mvvm.util.NoneAnimator
import cn.quickits.rainbow.R


/**
 * @program: Rainbow
 * @description:
 * @author: gavinliu
 * @create: 2019-05-14 14:51
 **/
class ThemeSwitcherFragment : QLceViewFragment<List<ThemeValue>, ThemeSwitcherViewModel, RecyclerView>() {

    private lateinit var adapter: ThemeValueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lceAnimator = NoneAnimator()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_switcher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.load(resources)

        adapter = ThemeValueAdapter()
        contentView.adapter = adapter
    }

    override fun bindLayoutId(): Int = R.layout.fragment_switcher

    override fun createViewModel(): ThemeSwitcherViewModel =
        ViewModelProviders.of(this).get(ThemeSwitcherViewModel::class.java)

    override fun showContent(content: List<ThemeValue>?) {
        super.showContent(content)
        adapter.list = content
    }
}