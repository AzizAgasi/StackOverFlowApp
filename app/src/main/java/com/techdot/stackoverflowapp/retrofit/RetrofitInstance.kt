package com.techdot.stackoverflowapp.retrofit

import com.techdot.stackoverflowapp.retrofit.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    public val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    public val api by lazy {
        retrofit.create(QuestionApi::class.java)
    }
}