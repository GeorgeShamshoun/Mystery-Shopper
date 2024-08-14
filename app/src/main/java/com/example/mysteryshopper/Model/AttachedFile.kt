package com.example.mysteryshopper.Model

class AttachedFile(
    val AttachedId: Int,
    val VisitId: Int,
    val QuestionId: Int,
    val AttachedType : String,
    val AttachedName : String,
    val AttachedURL :String,
)
{

    constructor() : this(0,0,0,"","","")
}