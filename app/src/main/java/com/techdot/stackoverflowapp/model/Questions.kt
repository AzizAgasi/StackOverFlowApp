package com.techdot.stackoverflowapp.model

import com.google.gson.annotations.SerializedName

data class Questions (

	@SerializedName("items") val items : List<Question>,
	@SerializedName("has_more") val has_more : Boolean,
	@SerializedName("quota_max") val quota_max : Int,
	@SerializedName("quota_remaining") val quota_remaining : Int
)