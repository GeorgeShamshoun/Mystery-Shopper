package com.example.mysteryshopper.Activity

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.mysteryshopper.ExData.MyExData
import com.example.mysteryshopper.Model.WorkingHours
import com.example.mysteryshopper.R
import com.example.mysteryshopper.RecyclerView.WorkingHoursRecyclerViewAdapter
import com.example.mysteryshopper.databinding.ActivityJobDetailsBinding


class JobDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJobDetailsBinding
    private var workingHoursList : ArrayList<WorkingHours>? = ArrayList()
    private var workingHoursListForEx : ArrayList<WorkingHours>? = MyExData().SetWorkingHours()
    private var workingHoursRecyclerViewAdapter: WorkingHoursRecyclerViewAdapter? = null
    private var Visit_Id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobDetailsBinding.inflate(layoutInflater)
        WindowCompat.setDecorFitsSystemWindows( window, false)
        window.statusBarColor = Color.TRANSPARENT
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        binding.txtBranchName.text = intent.extras?.getString("Branch_Name").toString()
        binding.txtBranchAddress.text = intent.extras?.getString("Branch_Address").toString()
        binding.txtBranchType.text = intent.extras?.getString("Branch_Type").toString()
        binding.txtBranchPhone.text = intent.extras?.getString("Branch_Phone").toString()
        binding.txtJobDate.text=  intent.extras?.getString("Visit_Date").toString()
        Visit_Id = intent.extras?.getString("Visit_Id").toString()
        workingHoursListForEx!!.forEach{ if (it.BranchId.equals(intent.extras?.getString("Branch_id").toString())){ workingHoursList?.add(it)} }
        workingHoursRecyclerViewAdapter =  WorkingHoursRecyclerViewAdapter()
        workingHoursRecyclerViewAdapter?.setLise(workingHoursList!!)
        binding.rvWorkingHours.adapter = workingHoursRecyclerViewAdapter

    }

    fun onclick(view: View) {
        when (view) {
            binding.imgJobDetailsBack -> { finish() }
            binding.txtJobDetailsBack -> { finish() }

            binding.btnAVisit -> {
                if (binding.btnAVisit.getText().toString() == "Accept Visit") {
                    binding.btnAVisit.text = "Start Now"
                    binding.btnDVisit.text = "Start Later"
                } else if (binding.btnAVisit.getText().toString() == "Start Now") {
                    startActivity(Intent(this, QuestionsActivity ::class.java).putExtra("Visit_Id", Visit_Id))
                    finish()
                }
            }

            binding.btnDVisit ->{
                if(binding.btnDVisit.getText().toString() == "Decline Visit"){
                    ShowDeclineAlertDialog()
                }else if(binding.btnDVisit.getText().toString() == "Start Later"){
                    finish()
                }
            }

            binding.imgBranchMap ->{
                val address = intent.extras?.getString("Branch_Address").toString()
                val url = "http://maps.google.com/maps?daddr=$address"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
            binding.txtViewLocation ->{
                val address = intent.extras?.getString("Branch_Address").toString()
                val url = "http://maps.google.com/maps?daddr=$address"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }

        }
    }

    fun ShowDeclineAlertDialog(){

        val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog).create()
        val view = layoutInflater.inflate(R.layout.msg_decline_visit,null)
        val  btn_cancel_decline = view.findViewById<Button>(R.id.btn_cancel_decline)
        val  btn_done_decline = view.findViewById<Button>(R.id.btn_done_decline)
        btn_cancel_decline.setOnClickListener { builder.dismiss() }
        btn_done_decline.setOnClickListener { builder.dismiss()
                                              finish() }
        builder.setView(view)
        builder.setCanceledOnTouchOutside(true)
        builder.show()


    }
}
