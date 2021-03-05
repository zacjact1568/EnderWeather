package net.zackzhang.code.haze.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*
import net.zackzhang.code.haze.databinding.ActivityHome1Binding

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val binding = ActivityHome1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.vNavBar) { v, insets ->
            v.updatePaddingRelative(top = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top)
            WindowInsetsCompat.CONSUMED
        }
    }
}