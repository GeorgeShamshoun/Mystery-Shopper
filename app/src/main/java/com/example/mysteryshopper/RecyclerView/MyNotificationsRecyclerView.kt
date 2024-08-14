package com.example.mysteryshopper.RecyclerView

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mysteryshopper.Activity.NotificationActivity
import com.example.mysteryshopper.Activity.NotificationsDetailsActivity
import com.example.mysteryshopper.Model.MyNotifications
import com.example.mysteryshopper.R

class MyNotificationsRecyclerViewAdapter : RecyclerView.Adapter<MyNotificationsRecyclerViewAdapter.NotificationsViewHolder>(){

    private var notificationsList: List<MyNotifications> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setLise(notificationsListListSet: List<MyNotifications>) {
        this.notificationsList = notificationsListListSet
        notifyDataSetChanged()
    }
    inner class NotificationsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        @SuppressLint("ResourceAsColor")
        fun bind(myNotifications: MyNotifications) {
            val imgNotificationType : ImageView = itemView.findViewById(R.id.img_notification_type)
            val txtNotificationTitel: TextView = itemView.findViewById(R.id.txt_notification_titel)
            val txtNotificationSummary: TextView = itemView.findViewById(R.id.txt_notification_summary)
            val txtNotificationDate: TextView = itemView.findViewById(R.id.txt_notification_date)
            val imgNotificationPoint : ImageView = itemView.findViewById(R.id.img_notification_point)
            val loItem : View = itemView.findViewById(R.id.lo_item_notification)

            txtNotificationTitel.text = myNotifications.NotificationTitel
            txtNotificationSummary.text = myNotifications.NotificationSummary
            txtNotificationDate.text = myNotifications.NotificationDate
            when (myNotifications.NotificationType) {
                "System Notification" -> { imgNotificationType.setImageResource(R.drawable.notifcaition_system) }
                "Returned Notification" -> { imgNotificationType.setImageResource(R.drawable.notifcaition_return) }
                "General Notification" -> { imgNotificationType.setImageResource(R.drawable.notifcaition_general) }
            }
            if (myNotifications.NotificationRead == true){
                imgNotificationPoint.visibility = View.INVISIBLE
                loItem.setBackgroundColor(Color.parseColor("#F3F3F3"))
            }else{
                imgNotificationPoint.visibility = View.VISIBLE
            }
            itemView.setOnClickListener {
                val activity = it.context as NotificationActivity
                activity.finishMe()

                val intent = Intent(it.context, NotificationsDetailsActivity::class.java)
                intent.putExtra("notification_id", myNotifications.NotificationId)
                intent.putExtra("notification_type",myNotifications.NotificationType)
                intent.putExtra("notification_titel",myNotifications.NotificationTitel)
                intent.putExtra("notification_date", myNotifications.NotificationDate)
                intent.putExtra("notification_summary", myNotifications.NotificationSummary)
                intent.putExtra("notification_body", myNotifications.NotificationBody)
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent, false)
        return  NotificationsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationsViewHolder, position: Int) {
        val  myNotifications: MyNotifications = notificationsList.get(position)
        holder.bind(myNotifications) }

    override fun getItemCount(): Int { return notificationsList.size }
}