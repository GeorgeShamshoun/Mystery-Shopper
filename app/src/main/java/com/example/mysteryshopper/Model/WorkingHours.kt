package com.example.mysteryshopper.Model

data class WorkingHours (

    val BranchId: String,
    val WorhingDay: String,
    val WorkindTime: String,

    )
{
    constructor() : this("", "", "")
}