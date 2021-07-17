package com.techdot.stackoverflowapp.retrofit

import com.techdot.stackoverflowapp.model.Question
import com.techdot.stackoverflowapp.model.Questions
import com.techdot.stackoverflowapp.retrofit.Constants.Companion.ORDER
import com.techdot.stackoverflowapp.retrofit.Constants.Companion.SITE
import com.techdot.stackoverflowapp.retrofit.Constants.Companion.SORT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionApi {
    @GET("/questions?")
    fun getQuestions(@Query(ORDER) order: String,
                     @Query(SORT) sort: String,
                     @Query(SITE) site: String): Call<Questions>
}