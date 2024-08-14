package com.example.mysteryshopper.Activity

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import com.example.mysteryshopper.ExData.MyExData
import com.example.mysteryshopper.Fragment.QuestionsFragment1
import com.example.mysteryshopper.Fragment.QuestionsFragment2
import com.example.mysteryshopper.Fragment.QuestionsFragment3
import com.example.mysteryshopper.Fragment.QuestionsFragment4
import com.example.mysteryshopper.Fragment.QuestionsFragment5
import com.example.mysteryshopper.Model.MyQuestion
import com.example.mysteryshopper.R
import com.example.mysteryshopper.databinding.ActivityQuestionsBinding


class QuestionsActivity : AppCompatActivity() {
     private lateinit var binding: ActivityQuestionsBinding
     private var myQuestionListForEx: ArrayList<MyQuestion>? = MyExData().SetQuestions()
     val countQuestion = myQuestionListForEx!!.size
     var currentQuestion = 1
     var Visit_Id = ""

     override fun onCreate(savedInstanceState: Bundle?) {

         super.onCreate(savedInstanceState)
         binding = ActivityQuestionsBinding.inflate(layoutInflater)
         WindowCompat.setDecorFitsSystemWindows( window, false)
         window.statusBarColor = Color.TRANSPARENT
         setContentView(binding.root)
         binding.progressBarQ.progress = (currentQuestion * 100 / countQuestion)
         binding.txtCountQuestion.text = ("1 of " + (countQuestion).toString())
     }

     override fun onResume() {
         super.onResume()
         Visit_Id = intent.extras?.getString("Visit_Id").toString()
         if (myQuestionListForEx?.get(0)!!.QuestionType == "Text") {
             SetFragment(QuestionsFragment1())
         } else if (myQuestionListForEx?.get(0)!!.QuestionType == "List") {
             SetFragment(QuestionsFragment2())
         } else if (myQuestionListForEx?.get(0)!!.QuestionType == "RadioButton") {
             SetFragment(QuestionsFragment3())
         } else if (myQuestionListForEx?.get(0)!!.QuestionType == "CheckBox") {
             SetFragment(QuestionsFragment4())
         } else if (myQuestionListForEx?.get(0)!!.QuestionType == "RadioButton2") {
             SetFragment(QuestionsFragment5())
         }
     }

     fun onclick(view: View) {
         when (view) {
             binding.btnNext -> {
                 if (currentQuestion < countQuestion) {
                     currentQuestion = currentQuestion + 1
                     binding.txtCountQuestion.text =
                         ((currentQuestion).toString() + " of " + (countQuestion).toString())
                     binding.progressBarQ.progress = (currentQuestion * 100 / countQuestion)
                     binding.btnPrevious.visibility = View.VISIBLE
                     if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "Text") {
                         SetFragment(QuestionsFragment1())
                     } else if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "List") {
                         SetFragment(QuestionsFragment2())
                     } else if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "RadioButton") {
                         SetFragment(QuestionsFragment3())
                     } else if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "CheckBox") {
                         SetFragment(QuestionsFragment4())
                     } else if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "RadioButton2") {
                         SetFragment(QuestionsFragment5())
                     }
                 } else if (currentQuestion == countQuestion) {
                     ShowFinishVisitDialog()
                 }
             }

             binding.btnPrevious -> {
                 if (currentQuestion == 2) {
                     currentQuestion = currentQuestion - 1
                     binding.progressBarQ.progress = (currentQuestion * 100 / countQuestion)
                     binding.txtCountQuestion.text =
                         ((currentQuestion).toString() + " of " + (countQuestion).toString())
                     binding.btnPrevious.visibility = View.GONE

                     if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "Text") {
                         SetFragment(QuestionsFragment1())
                     } else if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "List") {
                         SetFragment(QuestionsFragment2())
                     } else if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "RadioButton") {
                         SetFragment(QuestionsFragment3())
                     } else if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "CheckBox") {
                         SetFragment(QuestionsFragment4())
                     } else if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "RadioButton2") {
                         SetFragment(QuestionsFragment5())
                     }
                 } else if (currentQuestion <= countQuestion) {
                     currentQuestion = currentQuestion - 1
                     binding.progressBarQ.progress = (currentQuestion * 100 / countQuestion)
                     binding.txtCountQuestion.text =
                         ((currentQuestion).toString() + " of " + (countQuestion).toString())

                     if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "Text") {
                         SetFragment(QuestionsFragment1())
                     } else if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "List") {
                         SetFragment(QuestionsFragment2())
                     } else if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "RadioButton") {
                         SetFragment(QuestionsFragment3())
                     } else if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "CheckBox") {
                         SetFragment(QuestionsFragment4())
                     } else if (myQuestionListForEx?.get(currentQuestion - 1)!!.QuestionType == "RadioButton2") {
                         SetFragment(QuestionsFragment5())
                     }
                 }
             }

             binding.imgMsgSurvey -> {ShowSurveyOptions()}
             binding.txtCountQuestion -> { finish() }

         }
     }

     private fun SetFragment(myFragment: Fragment) {
         val fr = supportFragmentManager.beginTransaction()
         val bundle = Bundle()
         bundle.putInt("QuestionNumber", currentQuestion)
         bundle.putString("Visit_Id", Visit_Id)
         myFragment.arguments = bundle
         fr.replace(R.id.questions_content, myFragment)
         fr.commit()
     }

     fun ShowFinishVisitDialog() {
         val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog).create()
         val view = layoutInflater.inflate(R.layout.msg_finish_visit, null)
         val btn_cancel_visit = view.findViewById<Button>(R.id.btn_cancel_visit)
         val btn_send_visit = view.findViewById<Button>(R.id.btn_send_visit)
         btn_cancel_visit.setOnClickListener { builder.dismiss() }
         btn_send_visit.setOnClickListener {
             builder.dismiss()
             finish()
         }
         builder.setView(view)
         builder.setCanceledOnTouchOutside(true)
         builder.show()
     }

     fun ShowSurveyOptions() {
         val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
         val view = layoutInflater.inflate(R.layout.msg_survey_options, null)
         val btn_cancel_visit = view.findViewById<Button>(R.id.btn_cancel_survey)

         builder.setView(view)
         val alertDialog = builder.create()
         alertDialog.create()
         alertDialog.show()
         btn_cancel_visit.setOnClickListener { alertDialog.dismiss() }

         val layoutParams = WindowManager.LayoutParams()
         layoutParams.copyFrom(alertDialog.window?.attributes)
         layoutParams.width = (WindowManager.LayoutParams.MATCH_PARENT)
         layoutParams.height = (WindowManager.LayoutParams.WRAP_CONTENT)
         layoutParams.gravity = Gravity.BOTTOM
         alertDialog.window?.attributes = layoutParams
     }
 }

