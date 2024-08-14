package com.example.mysteryshopper.Model

data class MyQuestion (
    val QuestionId: Int,
    val QuestionType: String,
    val QuestionText: String,
    val QuestionOtherText: String,
    val QuestionDifferentSelection: Int,
    )
{
    constructor() : this(0, "",  "", "", 0)
}