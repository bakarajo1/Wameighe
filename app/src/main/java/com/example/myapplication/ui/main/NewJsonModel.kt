package com.example.myapplication.ui.main


import com.google.gson.annotations.SerializedName

data class NewJsonModel(
    @SerializedName("content")
    var content: List<Content>?
)