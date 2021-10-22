package com.example.myapplication

import com.example.myapplication.ui.main.NewJsonModel
import retrofit2.Response
import retrofit2.http.GET

interface Todoapi {

    @GET("/v3/f4864c66-ee04-4e7f-88a2-2fbd912ca5ab")
    suspend fun getTodos(): Response<NewJsonModel>

}