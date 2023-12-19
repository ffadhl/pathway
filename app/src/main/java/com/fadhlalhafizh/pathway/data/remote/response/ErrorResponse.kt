package com.fadhlalhafizh.pathway.data.remote.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("errors")
	val errors: Errors? = null
)

data class Errors(

	@field:SerializedName("email")
	val email: String? = null
)
