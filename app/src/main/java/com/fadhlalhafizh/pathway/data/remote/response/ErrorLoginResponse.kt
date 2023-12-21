package com.fadhlalhafizh.pathway.data.remote.response

import com.google.gson.annotations.SerializedName

data class ErrorLoginResponse(

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("errors")
	val errors: ErrorsLogin
)

data class ErrorsLogin(

	@field:SerializedName("message")
	val message: String
)
