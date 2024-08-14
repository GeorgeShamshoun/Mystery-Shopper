package com.example.mysteryshopper.Activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.mysteryshopper.databinding.ActivitySurveyBinding

class SurveyActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySurveyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyBinding.inflate(layoutInflater)
        WindowCompat.setDecorFitsSystemWindows( window, false)
        window.statusBarColor = Color.TRANSPARENT
        setContentView(binding.root)

    }

    fun onclick(view: View) {
        when (view){
            binding.txtSurveyPreview->{finish()}
            binding.imgSurveyPreviewBack->{finish()}
            binding.btnExitSurvey->{finish()
                VisitsActivity().finishMe()}

        }
    }
}