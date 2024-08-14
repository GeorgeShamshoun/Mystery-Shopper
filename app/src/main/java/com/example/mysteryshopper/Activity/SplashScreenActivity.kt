package com.example.mysteryshopper.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.mysteryshopper.databinding.ActivitySplashScreenBinding


class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding :ActivitySplashScreenBinding
    private lateinit var runnable: Runnable
    private var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(binding.root)

        binding.splashScreenLayout.setOnClickListener {
            handler.removeCallbacks(runnable)
            startActivity(Intent(this, WelcomeActivity ::class.java))
            finish()

        }

        runnable = Runnable {
            startActivity(Intent(this, WelcomeActivity ::class.java))
            finish()
        }

        handler.postDelayed(runnable, 3000)

    }

}



