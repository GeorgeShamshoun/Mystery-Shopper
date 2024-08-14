package com.example.mysteryshopper.RecyclerView

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mysteryshopper.Model.WorkingHours
import com.example.mysteryshopper.R

class WorkingHoursRecyclerViewAdapter : RecyclerView.Adapter<WorkingHoursRecyclerViewAdapter.WorkingHoursViewHolder>(){

    private var workingHoursList: List<WorkingHours> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setLise(workingHoursListSet: List<WorkingHours>) {
        this.workingHoursList = workingHoursListSet
        notifyDataSetChanged()
    }
    inner class WorkingHoursViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(workingHours: WorkingHours) {
            val tvWorkingDay: TextView = itemView.findViewById(R.id.txt_working_day)
            val tvWorkingTime: TextView = itemView.findViewById(R.id.txt_working_time)
            tvWorkingDay.text=workingHours.WorhingDay
            tvWorkingTime.text=workingHours.WorkindTime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkingHoursViewHolder {
        val  view:View
        view = LayoutInflater.from(parent.context).inflate(R.layout.item_working_hours, parent, false)
        return  WorkingHoursViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkingHoursViewHolder, position: Int) {
        val workingHours: WorkingHours = workingHoursList.get(position)
        holder.bind(workingHours)

    }

    override fun getItemCount(): Int { return workingHoursList.size }
}