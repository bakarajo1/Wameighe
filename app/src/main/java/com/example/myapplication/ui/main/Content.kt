package com.example.myapplication.ui.main


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("category")
    var category: String?,
    @SerializedName("cover")
    var cover: String?,
    @SerializedName("created_at")
    var createdAt: Long?,
    @SerializedName("descriptionEN")
    var descriptionEN: String?,
    @SerializedName("descriptionKA")
    var descriptionKA: String?,
    @SerializedName("descriptionRU")
    var descriptionRU: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("isLast")
    var isLast: Boolean?,
    @SerializedName("publish_date")
    var publishDate: String?,
    @SerializedName("published")
    var published: Int?,
    @SerializedName("titleEN")
    var titleEN: String?,
    @SerializedName("titleKA")
    var titleKA: String?,
    @SerializedName("titleRU")
    var titleRU: String?,
    @SerializedName("updated_at")
    var updatedAt: Long?
)