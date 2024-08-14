package com.example.mysteryshopper.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.mysteryshopper.ExData.MyExData
import com.example.mysteryshopper.R
import com.example.mysteryshopper.databinding.ActivityHomePageBinding

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)

        WindowCompat.setDecorFitsSystemWindows( window, false)
        window.statusBarColor = Color.TRANSPARENT

        setContentView(binding.root)

        binding.txtNotification.text = MyExData().SetNotifications().size.toString()
        binding.txtVSchedules.text = MyExData().SetVisitData().filter { it.VisitType.equals("Scheduled") }.size.toString() + " Visits"
        binding.txtVCvAccepted.text = MyExData().SetVisitData().filter { it.VisitType.equals("Accepted") }.size.toString() + " Visits"
        binding.txtVInporgress.text = MyExData().SetVisitData().filter { it.VisitType.equals("Inporgress") }.size.toString() + " Visits"
        binding.txtVReturned.text = MyExData().SetVisitData().filter { it.VisitType.equals("Returned") }.size.toString() + " Visits"

    }

    override fun onResume() {
        super.onResume()
        binding.txtUserName.setText(intent.extras?.getString("userName").toString())
    }


    fun onclick(view: View) {
        when (view){
            binding.cvSchedules->
                startActivity(Intent(this, VisitsActivity ::class.java).putExtra("type","Scheduled"))
            binding.cvAccepted->
                startActivity(Intent(this, VisitsActivity ::class.java).putExtra("type","Accepted"))
            binding.cvInporgress->
                startActivity(Intent(this, VisitsActivity ::class.java).putExtra("type","Inporgress"))
            binding.cvReturned->
                startActivity(Intent(this, VisitsActivity ::class.java).putExtra("type","Returned"))
            binding.imgNotification-> startActivity(Intent(this, NotificationActivity ::class.java))
            binding.imgLogout->{
                ShowLogOfDialog()
            }

        }
    }
    fun ShowLogOfDialog(){

        val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog).create()
        val view = layoutInflater.inflate(R.layout.msg_log_out,null)
        val  btn_cancel_log_out = view.findViewById<Button>(R.id.btn_cancel_log_out)
        val  btn_send_log_out = view.findViewById<Button>(R.id.btn_log_out)
        btn_cancel_log_out.setOnClickListener { builder.dismiss() }
        btn_send_log_out.setOnClickListener { builder.dismiss()
            startActivity(Intent(this, SplashScreenActivity ::class.java))
            finish() }
        builder.setView(view)
        builder.setCanceledOnTouchOutside(true)
        builder.show()
    }

}