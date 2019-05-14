package cn.quickits.rainbow.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.quickits.rainbow.Rainbow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Rainbow.applyThemeOverlays(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
