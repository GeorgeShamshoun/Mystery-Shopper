package com.example.mysteryshopper.RecyclerView

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysteryshopper.ExData.MyExData
import com.example.mysteryshopper.Model.MySelectionQuestion
import com.example.mysteryshopper.Model.OnSelectedClick
import com.example.mysteryshopper.R

class RadioButtonRecyclerViewAdapter(TypeSelection : String) : RecyclerView.Adapter<RadioButtonRecyclerViewAdapter.RadioButtonViewHolder>(){

    private var RadioButtonList: List<MySelectionQuestion> = ArrayList()
    private var typeSelection = TypeSelection
    private var lastCheckedRB: RadioButton? = null
    var onSelectedClick: OnSelectedClick? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setLise(radioButtonListSet: List<MySelectionQuestion>) {
        this.RadioButtonList = radioButtonListSet
        notifyDataSetChanged()
    }
    inner class RadioButtonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bind(mySelectionQuestion: MySelectionQuestion) {
            val d_Selection = MyExData().SetQuestions().get(mySelectionQuestion.QuestionId-1).QuestionDifferentSelection
            if (typeSelection == "RadioButton"){
                val rBtn : RadioButton = itemView.findViewById(R.id.rbtn_q)
                val gRBtn : RadioGroup = itemView.findViewById(R.id.g_rbtn_q)
                rBtn.text = mySelectionQuestion.Selectiontext
                rBtn.setOnClickListener {
                    onSelectedClick?.SelectClick(position+1,d_Selection,rBtn.isChecked)
                        if (lastCheckedRB != null) {
                           lastCheckedRB?.isChecked = false
                        }
                        lastCheckedRB = rBtn
                        gRBtn.clearCheck()
                        rBtn.isChecked=true
                    }
            }else if (typeSelection == "CheckBox"){
                val cBox : CheckBox = itemView.findViewById(R.id.check_box_q)
                cBox.text=mySelectionQuestion.Selectiontext
                cBox.setOnClickListener {
                    onSelectedClick?.SelectClick(position+1,d_Selection,cBox.isChecked)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioButtonViewHolder {
        val  view:View
        return when (typeSelection) {
            "RadioButton" -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_radio_button, parent, false)
                RadioButtonViewHolder(view) }
            "CheckBox" -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_check_box, parent, false)
                RadioButtonViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_radio_button, parent, false)
                RadioButtonViewHolder(view)

            }
        }
    }

    override fun onBindViewHolder(holder: RadioButtonViewHolder, position: Int) {
        val mySelectionQuestion: MySelectionQuestion = RadioButtonList.get(position)
        holder.bind(mySelectionQuestion) }

    override fun getItemCount(): Int { return RadioButtonList.size }
}
