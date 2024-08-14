package com.example.mysteryshopper.Fragment

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.mysteryshopper.ExData.MyExData
import com.example.mysteryshopper.databinding.FragmentQuestions1Binding

class QuestionsFragment1 : Fragment() {
    private var binding: FragmentQuestions1Binding? = null

    var questionId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestions1Binding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questionId = arguments?.getInt("QuestionNumber")!!.toInt()
        binding?.txtQ1?.text = MyExData().SetQuestions().get(questionId-1).QuestionText
        binding?.txtOtherQ1?.text = MyExData().SetQuestions().get(questionId-1).QuestionOtherText

       val theSelectionQuestionL: ArrayList<String> = ArrayList()
        MyExData().SetSelectionQuestions().forEach { if (it.QuestionId == questionId ) {
            theSelectionQuestionL.add(it.Selectiontext)
        } }
        val myAdapter = ArrayAdapter<String>(requireActivity(), R.layout.simple_list_item_1,theSelectionQuestionL)
        binding?.spinnerQ1?.adapter = myAdapter
    }
}