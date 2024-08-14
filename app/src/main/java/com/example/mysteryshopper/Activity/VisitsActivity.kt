package com.example.mysteryshopper.Activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.mysteryshopper.ExData.MyExData
import com.example.mysteryshopper.Model.MyVisits
import com.example.mysteryshopper.R
import com.example.mysteryshopper.RecyclerView.MyVisitsRecyclerViewAdapter
import com.example.mysteryshopper.databinding.ActivityVisitsBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Calendar

class VisitsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVisitsBinding
    private var myVisitsListForEx: ArrayList<MyVisits>? = MyExData().SetVisitData()
    private var myVisitsList: ArrayList<MyVisits>? = ArrayList()
    private var myVisitsRecyclerViewAdapter: MyVisitsRecyclerViewAdapter? = null
    private val calendar = Calendar.getInstance()
    @SuppressLint("UseCompatLoadingForDrawables")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVisitsBinding.inflate(layoutInflater)
        WindowCompat.setDecorFitsSystemWindows( window, false)
        window.statusBarColor = Color.TRANSPARENT
        setContentView(binding.root)

        binding.txtSNotivication.text = MyExData().SetVisitData().filter { it.VisitType.equals("Scheduled") }.size.toString()
        binding.txtANotivication.text = MyExData().SetVisitData().filter { it.VisitType.equals("Accepted") }.size.toString()
        binding.txtINotivication.text = MyExData().SetVisitData().filter { it.VisitType.equals("Inporgress") }.size.toString()
        binding.txtRNotivication.text = MyExData().SetVisitData().filter { it.VisitType.equals("Returned") }.size.toString()

        if (binding.txtSNotivication.text.toString().equals("0")) {
            binding.txtSNotivication.visibility = View.INVISIBLE
        }
        if (binding.txtANotivication.text.toString().equals("0")) {
            binding.txtANotivication.visibility = View.INVISIBLE
        }
        if (binding.txtINotivication.text.toString().equals("0")) {
            binding.txtINotivication.visibility = View.INVISIBLE
        }
        if (binding.txtRNotivication.text.toString().equals("0")) {
            binding.txtRNotivication.visibility = View.INVISIBLE
        }

    }

    override fun onResume() {
        super.onResume()
        BackToDefault(intent.extras?.getString("type").toString())
    }

    fun onclick(view: View) {
        when (view) {
            binding.imgScheduled0 -> { BackToDefault("Scheduled") }
            binding.imgAccepted0 -> { BackToDefault("Accepted") }
            binding.imgInprogress0 -> { BackToDefault("Inporgress") }
            binding.imgReturned0 -> { BackToDefault("Returned") }
            binding.txtDateRange -> {

                MsgCalander()
            }
            binding.imgTheDate->{
                binding.txtTheDate.visibility = View.GONE
                binding.imgTheDate.visibility = View.GONE
            }
            binding.imgVisitBack -> { finishMe() }
            binding.txtVisitBack -> { finishMe() }
        }
    }

    @SuppressLint("ResourceAsColor")
    fun BackToDefault(typeVisit: String) {
        myVisitsList!!.clear()
        myVisitsListForEx!!.forEach { if (it.VisitType.equals(typeVisit)) { myVisitsList?.add(it) } }
        myVisitsRecyclerViewAdapter = MyVisitsRecyclerViewAdapter(typeVisit)
        myVisitsRecyclerViewAdapter?.setLise(myVisitsList!!)

        binding.rvAllVisit.adapter = myVisitsRecyclerViewAdapter

        binding.loScheduledDate.visibility = View.GONE
        binding.imgScheduled0.setImageResource(R.drawable.scheduled_0)
        binding.imgAccepted0.setImageResource(R.drawable.accepted_0)
        binding.imgInprogress0.setImageResource(R.drawable.inprogess_0)
        binding.imgReturned0.setImageResource(R.drawable.returned_0)

        binding.txtScheduled.setTextColor( ContextCompat.getColor(this, R.color.visits_scheduled_text1))
        binding.txtAccepted.setTextColor(ContextCompat.getColor(this, R.color.visits_scheduled_text1))
        binding.txtInprogress.setTextColor(ContextCompat.getColor(this, R.color.visits_scheduled_text1))
        binding.txtReturned.setTextColor(ContextCompat.getColor(this, R.color.visits_scheduled_text1))

        if (typeVisit.equals("Scheduled")) {
            binding.loScheduledDate.visibility = View.VISIBLE
            binding.imgScheduled0.setImageResource(R.drawable.scheduled_1)
            binding.txtScheduled.setTextColor(ContextCompat.getColor(this, R.color.white))
        } else if (typeVisit.equals("Accepted")) {
            binding.imgAccepted0.setImageResource(R.drawable.accepted_1)
            binding.txtAccepted.setTextColor(ContextCompat.getColor(this, R.color.white))
        } else if (typeVisit.equals("Inporgress")) {
            binding.imgInprogress0.setImageResource(R.drawable.inprogress_1)
            binding.txtInprogress.setTextColor(ContextCompat.getColor(this, R.color.white))
        } else if (typeVisit.equals("Returned")) {
            binding.imgReturned0.setImageResource(R.drawable.returned_1)
            binding.txtReturned.setTextColor(ContextCompat.getColor(this, R.color.white))
        }

    }
    fun finishMe() { finish() }

    @SuppressLint("ResourceAsColor")
    fun MsgCalander() {
        val messageBoxView = LayoutInflater.from(this).inflate(R.layout.msg_calander, null)
        val messageBoxBuilder = AlertDialog.Builder(this).setView(messageBoxView)
        val btn_apply_date: Button = messageBoxView.findViewById(R.id.btn_apply_date)
        val txt_date_range : TextView =  messageBoxView.findViewById(R.id.txt_count_days)
        val the_calander : CalendarView = messageBoxView.findViewById(R.id.the_calendar)
        val messageBoxInstance = messageBoxBuilder.show()
        var yF: Int? = null
        var mF: Int? = null
        var dF: Int? = null
        var yS: Int? = null
        var mS: Int? = null
        var dS: Int? = null
        var the_f_Date = ""
        var the_s_Date = ""
        var rangeDate: Long? = null
        var dateF: LocalDate? = null
        var dateS: LocalDate? = null

        the_calander.setOnDateChangeListener { view, year, month, dayOfMonth ->

            if(the_f_Date == "")
            { the_f_Date = "${dayOfMonth}/${month+1}/${year}"
                yF = year
                mF = month+1
                dF = dayOfMonth
                dateF = LocalDate.parse(the_f_Date, DateTimeFormatter.ofPattern("d/M/yyyy"))
                Toast.makeText(this,"First $the_f_Date", Toast.LENGTH_SHORT).show()
            }else{
                yS = year
                mS = month+1
                dS = dayOfMonth
              the_s_Date = "${dayOfMonth}/${month+1}/${year}"
                dateS = LocalDate.parse(the_s_Date, DateTimeFormatter.ofPattern("d/M/yyyy"))
                Toast.makeText(this,"Second $the_s_Date", Toast.LENGTH_SHORT).show()
                 rangeDate = ChronoUnit.DAYS.between(dateF, dateS)
                if (yF!! > yS!!){
                    val dateF0 = the_f_Date
                    val dateS0 = the_s_Date
                    the_f_Date = dateS0
                    the_s_Date = dateF0
                    rangeDate = ChronoUnit.DAYS.between(dateS, dateF)
                }else {
                    if (mF!! > mS!!){
                        val dateF0 = the_f_Date
                        val dateS0 = the_s_Date
                        the_f_Date = dateS0
                        the_s_Date = dateF0
                        rangeDate = ChronoUnit.DAYS.between(dateS, dateF)
                    }else{
                        if (dF!! > dS!!){
                            val dateF0 = the_f_Date
                            val dateS0 = the_s_Date
                            the_f_Date = dateS0
                            the_s_Date = dateF0
                            rangeDate = ChronoUnit.DAYS.between(dateS, dateF)
                        }
                    }
                }
                txt_date_range.visibility = View.VISIBLE
                txt_date_range.text = "${(rangeDate!! +1)} Days Selected "
            }
        }
        btn_apply_date.setOnClickListener {
            if (the_f_Date == "" || the_s_Date == ""){
                messageBoxInstance.dismiss()
            }else{
                binding.txtTheDate.visibility = View.VISIBLE
                binding.txtTheDate.text = "${the_f_Date} - ${the_s_Date}"
                binding.imgTheDate.visibility = View.VISIBLE
                messageBoxInstance.dismiss()
            }
        }
    }

}
