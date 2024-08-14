package com.example.mysteryshopper.Model

data class MySelectionQuestion (
    val QuestionId: Int,
    val SelectionNumber: Int,
    val Selectiontext: String,
    )
{
    constructor() : this(0, 0,  "")
}