package com.example.mysteryshopper.Fragment

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.mysteryshopper.ExData.MyExData
import com.example.mysteryshopper.Model.AttachedFile
import com.example.mysteryshopper.Model.OnPreviewClick
import com.example.mysteryshopper.RecyclerView.AttachedFileRecyclerViewAdapter
import com.example.mysteryshopper.databinding.FragmentQuestions2Binding

class QuestionsFragment2 : Fragment() ,OnPreviewClick{


    private var binding: FragmentQuestions2Binding? = null

    var questionId = 0
    var Visit_Id = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestions2Binding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questionId = arguments?.getInt("QuestionNumber")!!.toInt()
        binding?.txtQ2?.text = MyExData().SetQuestions().get(questionId-1).QuestionText
        Visit_Id = arguments?.getString("Visit_Id").toString()

        val theSelectionQuestionL: ArrayList<String> = ArrayList()
        MyExData().SetSelectionQuestions().forEach { if (it.QuestionId == questionId ) {
            theSelectionQuestionL.add(it.Selectiontext) } }
        val myAdapter = ArrayAdapter<String>(requireActivity(), R.layout.simple_list_item_1,theSelectionQuestionL)
        binding?.spinnerQ2?.adapter = myAdapter

        val myAttachedFileList: ArrayList<AttachedFile> = ArrayList()
        MyExData().attachedFileForEx().forEach {
            if (it.QuestionId.equals(questionId) && it.VisitId == Visit_Id.toInt()) {
                myAttachedFileList.add(it) }
        }

        val attachedFileRecyclerViewAdapter = AttachedFileRecyclerViewAdapter()
        attachedFileRecyclerViewAdapter.setLise(myAttachedFileList)
        binding?.rvQ2Upload?.adapter = attachedFileRecyclerViewAdapter
        attachedFileRecyclerViewAdapter.onPreviewClick = this

    }

    override fun PreviewClick(t: String) {
        val builder = AlertDialog.Builder(binding?.root!!.context, com.example.mysteryshopper.R.style.CustomAlertDialog).create()
        var viewx: View? = null
        if (t ==  "Jpeg"){
             viewx = layoutInflater.inflate(com.example.mysteryshopper.R.layout.msg_preview_image,null)
            val  btn_image_done = viewx.findViewById<Button>(com.example.mysteryshopper.R.id.btn_image_done)
            btn_image_done.setOnClickListener { builder.dismiss() }
        }else if(t ==  "Move"){
             viewx = layoutInflater.inflate(com.example.mysteryshopper.R.layout.msg_preview_video,null)
            val  btn_video_done = viewx.findViewById<Button>(com.example.mysteryshopper.R.id.btn_video_done)
            btn_video_done.setOnClickListener { builder.dismiss() }

        }else if(t ==  "Mp3"){
             viewx = layoutInflater.inflate(com.example.mysteryshopper.R.layout.msg_preview_oudio,null)
            val  btn_oudio_done = viewx.findViewById<Button>(com.example.mysteryshopper.R.id.btn_oudio_done)
            btn_oudio_done.setOnClickListener { builder.dismiss() }
        }
        builder.setView(viewx)
        builder.setCanceledOnTouchOutside(true)
        builder.show()
    }


}