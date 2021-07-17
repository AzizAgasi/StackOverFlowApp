package com.techdot.stackoverflowapp.model

import com.google.gson.annotations.SerializedName

data class Question (

	@SerializedName("tags") val tags : List<String>,
	@SerializedName("is_answered") val is_answered : Boolean,
	@SerializedName("view_count") val view_count : Int,
	@SerializedName("answer_count") val answer_count : Int,
	@SerializedName("score") val score : Int,
	@SerializedName("last_activity_date") val last_activity_date : Int,
	@SerializedName("creation_date") val creation_date : Int,
	@SerializedName("question_id") val question_id : Int,
	@SerializedName("content_license") val content_license : String,
	@SerializedName("link") val link : String,
	@SerializedName("title") val title : String
)