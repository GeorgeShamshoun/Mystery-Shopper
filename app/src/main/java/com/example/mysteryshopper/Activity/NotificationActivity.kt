package com.example.mysteryshopper.Activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.mysteryshopper.ExData.MyExData
import com.example.mysteryshopper.Model.MyNotifications
import com.example.mysteryshopper.RecyclerView.MyNotificationsRecyclerViewAdapter
import com.example.mysteryshopper.databinding.ActivityNotificationBinding


class NotificationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNotificationBinding

    private var myNotificationsListForEx: ArrayList<MyNotifications> = MyExData().SetNotifications()
    private var myNotificationsRecyclerViewAdapter: MyNotificationsRecyclerViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        WindowCompat.setDecorFitsSystemWindows( window, false)
        window.statusBarColor = Color.TRANSPARENT
        setContentView(binding.root)

        myNotificationsRecyclerViewAdapter =  MyNotificationsRecyclerViewAdapter()
        myNotificationsRecyclerViewAdapter?.setLise(myNotificationsListForEx)
        binding.rvNotification.adapter = myNotificationsRecyclerViewAdapter

    }
        fun onclick(view: View) {
        when (view) {
            binding.imgNotificationBack ->{finish()}
            binding.txtNotificationBack->{finish()}

        }
    }
    fun finishMe() { finish() }
}