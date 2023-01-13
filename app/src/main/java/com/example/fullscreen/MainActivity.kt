package com.example.fullscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fullscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnFullScreen.setOnClickListener {
            startActivity(Intent(this, FullscreenActivity::class.java))
        }
        binding.btnFullStatusbar.setOnClickListener {
            startActivity(Intent(this, Fullstatusbar::class.java))
        }
    }
}