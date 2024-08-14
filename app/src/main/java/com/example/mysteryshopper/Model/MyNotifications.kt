package com.example.mysteryshopper.Model

data class MyNotifications (
    val NotificationId: Int,
    val NotificationType: String,
    val NotificationTitel: String,
    val NotificationDate: String,
    val NotificationSummary: String,
    val NotificationBody: String,
    val NotificationRead : Boolean

    )
{
    constructor() : this(0, "", "","", "", "",false)
}