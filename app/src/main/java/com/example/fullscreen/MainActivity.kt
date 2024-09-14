package com.example.fullscreen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fullscreen.databinding.ActivityMainBinding
import eightbitlab.com.blurview.BlurAlgorithm
import eightbitlab.com.blurview.RenderEffectBlur
import eightbitlab.com.blurview.RenderScriptBlur

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnFullScreen.setOnClickListener {
            startActivity(Intent(this, FullscreenActivity::class.java))
        }
        //set background, if your root layout doesn't have one

        //set background, if your root layout doesn't have one
        val windowBackground = window.decorView.background
        val algorithm: BlurAlgorithm = getBlurAlgorithm()
        binding.btnFullStatusbar.setOnClickListener {
            startActivity(Intent(this, Fullstatusbar::class.java))
        }
        binding.apply {
            blurView.setupWith(root, RenderScriptBlur(this@MainActivity))
                .setBlurRadius(2f)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.hide(WindowInsets.Type.statusBars())
            window.insetsController?.systemBarsBehavior =
                WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        } else {
            val flags = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

            window.decorView.systemUiVisibility = flags
        }
    }

    private fun getBlurAlgorithm(): BlurAlgorithm {
        val algorithm: BlurAlgorithm = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            RenderEffectBlur()
        } else {
            RenderScriptBlur(this)
        }
        return algorithm
    }
    override fun onBackPressed() {
        CustomToast.makeText(
            this,
            "dsadsada",
            Toast.LENGTH_LONG,
            R.layout.custom_toast_finish_warning
        ).show()
    }
}