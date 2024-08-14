package com.example.mysteryshopper.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mysteryshopper.ExData.MyExData
import com.example.mysteryshopper.Model.MySelectionQuestion
import com.example.mysteryshopper.RecyclerView.RadioButtonRecyclerViewAdapter
import com.example.mysteryshopper.databinding.FragmentQuestions3Binding


class QuestionsFragment3 : Fragment() {
    private var binding: FragmentQuestions3Binding? = null

    var questionId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { binding = FragmentQuestions3Binding.inflate(inflater, container, false)
        return binding!!.root }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questionId = arguments?.getInt("QuestionNumber")!!.toInt()
        binding?.txtQ3?.text = MyExData().SetQuestions().get(questionId - 1).QuestionText
        binding?.txtOtherQ3?.text = MyExData().SetQuestions().get(questionId - 1).QuestionOtherText

        val mySelectionList: ArrayList<MySelectionQuestion> = ArrayList()
        MyExData().SetSelectionQuestions().forEach {
            if (it.QuestionId.equals(questionId)) { mySelectionList.add(it) } }

        val radioButtonRecyclerViewAdapter = RadioButtonRecyclerViewAdapter("RadioButton")
        radioButtonRecyclerViewAdapter.setLise(mySelectionList)
        binding?.rvQ3?.adapter = radioButtonRecyclerViewAdapter


    }




}

