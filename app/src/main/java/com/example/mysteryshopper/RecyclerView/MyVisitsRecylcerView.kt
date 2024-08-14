package com.example.mysteryshopper.RecyclerView

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mysteryshopper.Activity.JobDetailsActivity
import com.example.mysteryshopper.Activity.QuestionsActivity
import com.example.mysteryshopper.Activity.SurveyActivity
import com.example.mysteryshopper.Activity.VisitsActivity
import com.example.mysteryshopper.Model.MyVisits
import com.example.mysteryshopper.R

class MyVisitsRecyclerViewAdapter(TypeVisit : String) :RecyclerView.Adapter<MyVisitsRecyclerViewAdapter.VisitsViewHolder>(){
    private var myVisitsList: List<MyVisits> = ArrayList()
    private var typeVisit = TypeVisit


    @SuppressLint("NotifyDataSetChanged")
    fun setLise(visitsListSet: List<MyVisits>) {
        this.myVisitsList = visitsListSet
        notifyDataSetChanged()
    }
    inner class VisitsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(myVisits: MyVisits) {
            if (typeVisit == "Scheduled") {
                val tvNameS: TextView = itemView.findViewById(R.id.txt_branch_s_name)
                val tvAddressS: TextView = itemView.findViewById(R.id.txt_branch_s_address)
                val tvKindS: TextView = itemView.findViewById(R.id.txt_branch_s_type)
                val tvDateS: TextView = itemView.findViewById(R.id.txt_visit_s_date)
                val btnSItem : Button = itemView.findViewById(R.id.btn_s_item)
                val loItem : View? = itemView.findViewById(R.id.lo_item_scheduled)
                tvNameS.text = myVisits.BranchName
                tvAddressS.text = myVisits.BranchAddress
                tvKindS.text = myVisits.BranchType
                tvDateS.text = myVisits.VisitDate
                loItem?.setOnClickListener {
                    val intent = Intent(it.context, JobDetailsActivity::class.java)
                    intent.putExtra("Visit_Id", myVisits.VisitId.toString())
                    intent.putExtra("Visit_Type", myVisits.VisitType)
                    intent.putExtra("Branch_id", myVisits.BranchId)
                    intent.putExtra("Branch_Name", myVisits.BranchName)
                    intent.putExtra("Branch_Address", myVisits.BranchAddress)
                    intent.putExtra("Branch_Type", myVisits.BranchType)
                    intent.putExtra("Branch_Phone", myVisits.BranchPhone)
                    intent.putExtra("Visit_Date", myVisits.VisitDate)
                    intent.putExtra("Visit_Per", myVisits.VisitPer)
                    it.context.startActivity(intent) }
                btnSItem.setOnClickListener {
                    val intent = Intent(it.context, JobDetailsActivity::class.java)
                    intent.putExtra("Visit_Id", myVisits.VisitId.toString())
                    intent.putExtra("Visit_Type", myVisits.VisitType)
                    intent.putExtra("Branch_id", myVisits.BranchId)
                    intent.putExtra("Branch_Name", myVisits.BranchName)
                    intent.putExtra("Branch_Address", myVisits.BranchAddress)
                    intent.putExtra("Branch_Type", myVisits.BranchType)
                    intent.putExtra("Branch_Phone", myVisits.BranchPhone)
                    intent.putExtra("Visit_Date", myVisits.VisitDate)
                    intent.putExtra("Visit_Per", myVisits.VisitPer)
                    it.context.startActivity(intent)
                }
                }

            if (typeVisit == "Accepted") {
                val tvNameA: TextView = itemView.findViewById(R.id.txt_branch_a_name)
                val tvAddressA: TextView = itemView.findViewById(R.id.txt_branch_a_address)
                val tvDateA: TextView = itemView.findViewById(R.id.txt_visit_a_date)
                val btnAItem : Button = itemView.findViewById(R.id.btn_a_item)
                tvNameA.text = myVisits.BranchName
                tvAddressA.text = myVisits.BranchAddress
                tvDateA.text =  myVisits.VisitDate
                itemView.setOnClickListener {
                    val intent = Intent(it.context, JobDetailsActivity::class.java)
                    intent.putExtra("Visit_Id", myVisits.VisitId.toString())
                    intent.putExtra("Visit_Type", myVisits.VisitType)
                    intent.putExtra("Branch_id", myVisits.BranchId)
                    intent.putExtra("Branch_Name", myVisits.BranchName)
                    intent.putExtra("Branch_Address", myVisits.BranchAddress)
                    intent.putExtra("Branch_Type", myVisits.BranchType)
                    intent.putExtra("Branch_Phone", myVisits.BranchPhone)
                    intent.putExtra("Visit_Date", myVisits.VisitDate)
                    intent.putExtra("Visit_Per", myVisits.VisitPer)
                    it.context.startActivity(intent) }
                btnAItem.setOnClickListener {
                    val intent = Intent(it.context, JobDetailsActivity::class.java)
                    intent.putExtra("Visit_Id", myVisits.VisitId.toString())
                    intent.putExtra("Visit_Type", myVisits.VisitType)
                    intent.putExtra("Branch_id", myVisits.BranchId)
                    intent.putExtra("Branch_Name", myVisits.BranchName)
                    intent.putExtra("Branch_Address", myVisits.BranchAddress)
                    intent.putExtra("Branch_Type", myVisits.BranchType)
                    intent.putExtra("Branch_Phone", myVisits.BranchPhone)
                    intent.putExtra("Visit_Date", myVisits.VisitDate)
                    intent.putExtra("Visit_Per", myVisits.VisitPer)
                    it.context.startActivity(intent)
                }
            }

            if (typeVisit == "Inporgress") {
                val tvNameI: TextView = itemView.findViewById(R.id.txt_branch_i_name)
                val tvAddressI: TextView = itemView.findViewById(R.id.txt_branch_i_address)
                val tvDateI: TextView = itemView.findViewById(R.id.txt_visit_i_date)
                val tvPerI: TextView = itemView.findViewById(R.id.txt_visit_i_per)
                val progressBar_i : ProgressBar = itemView.findViewById(R.id.progressBar_i)
                val btnIItem : Button = itemView.findViewById(R.id.btn_i_item)
                tvNameI.text = myVisits.BranchName
                tvAddressI.text = myVisits.BranchAddress
                tvDateI.text =  myVisits.VisitDate
                tvPerI.text = "${(myVisits.VisitPer*100).toInt()}%"
                progressBar_i.progress = (myVisits.VisitPer*100).toInt()
                itemView.setOnClickListener {
                    val intent = Intent(it.context, QuestionsActivity::class.java)
                    intent.putExtra("Visit_Id", myVisits.VisitId.toString())
                    it.context.startActivity(intent) }
                btnIItem.setOnClickListener {
                    val intent = Intent(it.context, QuestionsActivity::class.java)
                    intent.putExtra("Visit_Id", myVisits.VisitId.toString())
                    it.context.startActivity(intent) }
            }
            if (typeVisit == "Returned") {
                val tvNameR: TextView = itemView.findViewById(R.id.txt_branch_r_name)
                val tvAddressR: TextView = itemView.findViewById(R.id.txt_branch_r_address)
                val tvDateR: TextView = itemView.findViewById(R.id.txt_visit_r_date)
                val btnRItem : Button = itemView.findViewById(R.id.btn_r_item)
                tvNameR.text = myVisits.BranchName
                tvAddressR.text = myVisits.BranchAddress
                tvDateR.text =  myVisits.VisitDate
                itemView.setOnClickListener {
                    val activity : VisitsActivity = it.context as VisitsActivity
                    activity.finishMe()
                    it.context.startActivity(Intent(it.context, SurveyActivity::class.java)) }
                btnRItem.setOnClickListener {
                    val activity : VisitsActivity = it.context as VisitsActivity
                    activity.finishMe()
                    it.context.startActivity(Intent(it.context, SurveyActivity::class.java)) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitsViewHolder {

        val  view:View
        return when (typeVisit) {
            "Schedules" -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_scheduled, parent, false)
                VisitsViewHolder(view) }
            "Accepted" -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_accepted, parent, false)
                VisitsViewHolder(view) }
            "Inporgress" -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_inprogress, parent, false)
                VisitsViewHolder(view)
            }
            "Returned" -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_returned, parent, false)
                VisitsViewHolder(view) }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_scheduled, parent, false)
                VisitsViewHolder(view) }
        }

    }

    override fun onBindViewHolder(holder: VisitsViewHolder, position: Int) {
        val myVisits: MyVisits = myVisitsList.get(position)
        holder.bind(myVisits) }

    override fun getItemCount(): Int { return myVisitsList.size }
}