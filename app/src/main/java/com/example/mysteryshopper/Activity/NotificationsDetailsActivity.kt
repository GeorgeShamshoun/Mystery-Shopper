package com.example.mysteryshopper.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.mysteryshopper.R
import com.example.mysteryshopper.databinding.ActivityNotificationsDetailsBinding

class NotificationsDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationsDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationsDetailsBinding.inflate(layoutInflater)
        WindowCompat.setDecorFitsSystemWindows( window, false)
        window.statusBarColor = Color.TRANSPARENT
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.txtNotificationDTitel.text = intent.extras?.getString("notification_titel").toString()
        binding.txtNotificationDBody.text = intent.extras?.getString("notification_body").toString()
        if (intent.extras?.getString("notification_type").toString() == "System Notification"){
            binding.imgNotificationDType.setImageResource(R.drawable.notifcaition_system)
        }else if (intent.extras?.getString("notification_type").toString() == "Returned Notification"){
            binding.imgNotificationDType.setImageResource(R.drawable.notifcaition_return)
        }else if (intent.extras?.getString("notification_type").toString() == "General Notification"){
            binding.imgNotificationDType.setImageResource(R.drawable.notifcaition_general)
        }

    }
    fun onclick(view: View) {
        when (view) {
            binding.imgNotificationDetailsBack -> {
                startActivity(Intent(this, NotificationActivity ::class.java))
                finish() }
            binding.txtNotificationDetailsBack -> {
                startActivity(Intent(this, NotificationActivity ::class.java))
                finish() }
            binding.txtNotificationDVList -> {
                startActivity(Intent(this, VisitsActivity ::class.java).putExtra("type","Scheduled"))
                finish()
               }
        }
    }


}