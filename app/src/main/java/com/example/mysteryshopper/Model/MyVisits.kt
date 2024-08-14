package com.example.mysteryshopper.Model

data class MyVisits (
    val VisitId: Int,
    val VisitType: String,
    val BranchId: String,
    val BranchName: String,
    val BranchAddress: String,
    val BranchType: String,
    val BranchPhone: String,
    val VisitDate: String,
    val VisitPer: Float,
    )
{
    constructor() : this(0, "", "", "", "", "","","", 0.0F)
}