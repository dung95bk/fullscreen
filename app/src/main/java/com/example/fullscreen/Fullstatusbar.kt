package com.example.fullscreen

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.fullscreen.databinding.ActivityFullstatusbarBinding

class Fullstatusbar : AppCompatActivity() {

    private lateinit var binding: ActivityFullstatusbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFullstatusbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        WindowCompat.setDecorFitsSystemWindows(window, false)


    }


}