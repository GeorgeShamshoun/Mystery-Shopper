package com.example.mysteryshopper.ExData

import com.example.mysteryshopper.Model.AttachedFile
import com.example.mysteryshopper.Model.MyNotifications
import com.example.mysteryshopper.Model.MyQuestion
import com.example.mysteryshopper.Model.MySelectionQuestion
import com.example.mysteryshopper.Model.MyVisits
import com.example.mysteryshopper.Model.WorkingHours

class MyExData() {

fun SetVisitData (): ArrayList<MyVisits>{
    val myVisitsListForEx : ArrayList<MyVisits> = ArrayList()

    myVisitsListForEx.add(MyVisits(1,"Scheduled","1","Branch Name 1","Branch Address 1","Branch Type 1","0123456789","2020/1/11",.45F))
    myVisitsListForEx.add(MyVisits(2,"Scheduled","2","Branch Name 2","Branch Address 2","Branch Type 2","0123456789","2021/1/12",.65F))
    myVisitsListForEx.add(MyVisits(3,"Scheduled","3","Branch Name 3","Branch Address 3","Branch Type 3","0123456789", "2022/1/13",.15F))
    myVisitsListForEx.add(MyVisits(4,"Scheduled","4","Branch Name 4","Branch Address 4","Branch Type 4","0123456789", "2023/1/14",.35F))
    myVisitsListForEx.add(MyVisits(5,"Scheduled","5","Branch Name 5","Branch Address 5","Branch Type 5","0123456789","2024/1/15",.55F))

    myVisitsListForEx.add(MyVisits(6,"Accepted","1","Branch Name 1","Branch Address 1","Branch Type 1","0123456789", "2020/2/11",.45F))
    myVisitsListForEx.add(MyVisits(7,"Accepted","2","Branch Name 2","Branch Address 2","Branch Type 2","0123456789", "2021/2/12",.45F))
    myVisitsListForEx.add(MyVisits(8,"Accepted","3","Branch Name 3","Branch Address 3","Branch Type 3","0123456789","2022/2/13",.15F))
    myVisitsListForEx.add(MyVisits(9,"Accepted","4","Branch Name 4","Branch Address 4","Branch Type 4","0123456789", "2023/2/14",.35F))
    myVisitsListForEx.add(MyVisits(10,"Accepted","5","Branch Name 5","Branch Address 5","Branch Type 5","0123456789", "2024/2/15",.55F))
    myVisitsListForEx.add(MyVisits(11,"Accepted","6","Branch Name 6","Branch Address 6","Branch Type 6","0123456789", "2024/2/15",.55F))

    myVisitsListForEx.add(MyVisits(12,"Inporgress","1","Branch Name 1","Branch Address 1","Branch Type 1","0123456789", "2020/3/11",.45F))
    myVisitsListForEx.add(MyVisits(13,"Inporgress","2","Branch Name 2","Branch Address 2","Branch Type 2","0123456789", "2021/3/12",.65F))
    myVisitsListForEx.add(MyVisits(14,"Inporgress","3","Branch Name 3","Branch Address 3","Branch Type 3","0123456789", "2022/3/13",.15F))
    myVisitsListForEx.add(MyVisits(15,"Inporgress","4","Branch Name 4","Branch Address 4","Branch Type 4","0123456789", "2023/3/14",.35F))
    myVisitsListForEx.add(MyVisits(16,"Inporgress","5","Branch Name 5","Branch Address 5","Branch Type 5","0123456789", "2024/3/15",.55F))
    myVisitsListForEx.add(MyVisits(17,"Inporgress","6","Branch Name 6","Branch Address 6","Branch Type 6","0123456789", "2024/3/15",.55F))
    myVisitsListForEx.add(MyVisits(18,"Inporgress","7","Branch Name 7","Branch Address 7","Branch Type 7","0123456789", "2024/3/15",.55F))

    myVisitsListForEx.add(MyVisits(19,"Returned","1","Branch Name 1","Branch Address 1","Branch Type 1","0123456789", "2020/4/11",.45F))
    myVisitsListForEx.add(MyVisits(20,"Returned","2","Branch Name 2","Branch Address 2","Branch Type 2","0123456789", "2021/4/12",.65F))
    myVisitsListForEx.add(MyVisits(21,"Returned","3","Branch Name 3","Branch Address 3","Branch Type 3","0123456789", "2022/4/13",.15F))
    myVisitsListForEx.add(MyVisits(22,"Returned","4","Branch Name 4","Branch Address 4","Branch Type 4","0123456789", "2023/4/14",.35F))
    myVisitsListForEx.add(MyVisits(23,"Returned","5","Branch Name 5","Branch Address 5","Branch Type 5","0123456789", "2024/4/15",.55F))

    return myVisitsListForEx
}

    fun SetWorkingHours (): ArrayList<WorkingHours>{
        val workingHoursListForEx : ArrayList<WorkingHours> = ArrayList()
        workingHoursListForEx.add(WorkingHours("1","Saturday - Wednesday","01:00 AM - 11:11 PM"))
        workingHoursListForEx.add(WorkingHours("1","Thursday","01:00 AM - 11:10 PM"))
        workingHoursListForEx.add(WorkingHours("1","Friday","01:00 PM - 11:10 PM"))

        workingHoursListForEx.add(WorkingHours("2","Saturday - Wednesday","02:00 AM - 22:22 PM"))
        workingHoursListForEx.add(WorkingHours("2","Thursday","02:00 AM - 22:20 PM"))
        workingHoursListForEx.add(WorkingHours("2","Friday","02:00 PM - 22:20 PM"))

        return workingHoursListForEx
    }

    fun SetNotifications (): ArrayList<MyNotifications>{
        val myNotificationsListForEx : ArrayList<MyNotifications> = ArrayList()

        myNotificationsListForEx.add(MyNotifications(1,"System Notification","System Notification","2021/7/10-03:05 AM","NotificationSummary1","NotificationBody1",true))
        myNotificationsListForEx.add(MyNotifications(2,"Returned Notification","Returned Notification","2021/7/10-03:05 AM","NotificationSummary2","NotificationBody2",false))
        myNotificationsListForEx.add(MyNotifications(3,"General Notification","General Notification","2021/7/10-03:05 AM","NotificationSummary3","NotificationBody3",true))

        myNotificationsListForEx.add(MyNotifications(4,"System Notification","System Notification","2021/7/10-03:05 AM","NotificationSummary4","NotificationBody4",false))
        myNotificationsListForEx.add(MyNotifications(5,"Returned Notification","Returned Notification","2021/7/10-03:05 AM","NotificationSummary5","NotificationBody5",true))
        myNotificationsListForEx.add(MyNotifications(6,"General Notification","General Notification","2021/7/10-03:05 AM","NotificationSummary6","NotificationBody6",false))

        myNotificationsListForEx.add(MyNotifications(7,"System Notification","System Notification","2021/7/10-03:05 AM","NotificationSummary7","NotificationBody7",true))
        myNotificationsListForEx.add(MyNotifications(8,"Returned Notification","Returned Notification","2021/7/10-03:05 AM","NotificationSummary8","NotificationBody8",false))
        myNotificationsListForEx.add(MyNotifications(9,"General Notification","General Notification","2021/7/10-03:05 AM","NotificationSummary9","NotificationBody9",true))
        return myNotificationsListForEx
    }

    fun SetQuestions (): ArrayList<MyQuestion>{
        val mySetQuestionsListForEx : ArrayList<MyQuestion> = ArrayList()
        mySetQuestionsListForEx.add(MyQuestion(1,"Text","1- Describe how was the mask policy during COVID-19 in the branch","Select Classification",0))
        mySetQuestionsListForEx.add(MyQuestion(2,"List","2- Describe branch type and attach branch branding image","Select Classification",0))
        mySetQuestionsListForEx.add(MyQuestion(3,"RadioButton","3- Rate your experience dealing with the agent in the branch","1 = Unsatisfied   10 = Very Happy",0))
        mySetQuestionsListForEx.add(MyQuestion(4,"CheckBox","4- Outdoor appearance & comfort issue ?","Please Justify Your Answer",4))
        mySetQuestionsListForEx.add(MyQuestion(5,"RadioButton2","5- Outdoor appearance & comfort issue ?","Select Classification",3))
        return mySetQuestionsListForEx
    }


    fun SetSelectionQuestions (): ArrayList<MySelectionQuestion>{
        val mySetSelectionQuestionsListForEx : ArrayList<MySelectionQuestion> = ArrayList()
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(1,1,"Main1"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(1,2,"Sub1"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(1,3,"External1"))

        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(2,1,"Main2"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(2,2,"Sub2"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(2,3,"External2"))

        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(3,1,"1"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(3,2,"2"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(3,3,"3"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(3,4,"4"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(3,5,"5"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(3,6,"6"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(3,7,"7"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(3,8,"8"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(3,9,"9"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(3,10,"10"))

        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(4,1,"Cleaning"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(4,2,"No Concern"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(4,3,"Messy"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(4,4,"Non Of The Above"))

        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(5,1,"Yes"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(5,2,"No"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(5,3,"Yes With Concern"))
        mySetSelectionQuestionsListForEx.add(MySelectionQuestion(5,4,"N/A"))

        return mySetSelectionQuestionsListForEx
    }

    fun attachedFileForEx (): ArrayList<AttachedFile>{
        val myattachedFileForEx : ArrayList<AttachedFile> = ArrayList()
        myattachedFileForEx.add(AttachedFile(1,1,2,"Jpeg","Visit1_Question2_Jpeg","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(2,1,2,"Move","Visit1_Question2_Move","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(3,1,2,"Mp3","Visit1_Question2_Mp3","AttachedUrl"))

        myattachedFileForEx.add(AttachedFile(4,1,4,"Jpeg","Visit1_Question4_Jpeg","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(5,1,4,"Move","Visit1_Question4_Move","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(6,1,4,"Mp3","Visit1_Question4_Mp3","AttachedUrl"))

        myattachedFileForEx.add(AttachedFile(7,1,5,"Jpeg","Visit1_Question5_Jpeg","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(8,1,5,"Move","Visit1_Question5_Move","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(9,1,5,"Mp3","Visit1_Question5_Mp3","AttachedUrl"))


        myattachedFileForEx.add(AttachedFile(10,6,2,"Jpeg","Visit6_Question2_Jpeg","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(11,6,2,"Move","Visit6_Question2_Move","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(12,6,2,"Mp3","Visit6_Question2_Mp3","AttachedUrl"))

        myattachedFileForEx.add(AttachedFile(13,6,4,"Jpeg","Visit6_Question4_Jpeg","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(14,6,4,"Move","Visit6_Question4_Move","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(15,6,4,"Mp3","Visit6_Question4_Mp3","AttachedUrl"))

        myattachedFileForEx.add(AttachedFile(16,6,5,"Jpeg","Visit6_Question5_Jpeg","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(17,6,5,"Move","Visit6_Question5_Move","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(18,6,5,"Mp3","Visit6_Question5_Mp3","AttachedUrl"))


        myattachedFileForEx.add(AttachedFile(19,12,2,"Jpeg","Visit12_Question2_Jpeg","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(20,12,2,"Move","Visit12_Question2_Move","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(21,12,2,"Mp3","Visit12_Question2_Mp3","AttachedUrl"))

        myattachedFileForEx.add(AttachedFile(22,12,4,"Jpeg","Visit12_Question4_Jpeg","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(23,12,4,"Move","Visit12_Question4_Move","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(24,12,4,"Mp3","Visit12_Question4_Mp3","AttachedUrl"))

        myattachedFileForEx.add(AttachedFile(25,12,5,"Jpeg","Visit12_Question5_Jpeg","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(26,12,5,"Move","Visit12_Question5_Move","AttachedUrl"))
        myattachedFileForEx.add(AttachedFile(27,12,5,"Mp3","Visit12_Question5_Mp3","AttachedUrl"))

        return myattachedFileForEx
    }

}