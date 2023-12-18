package com.fadhlalhafizh.pathway.data.remote.response.register

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReqBodyRegisterResponse(

	@field:SerializedName("“email”")
	val email: String? = null,

	@field:SerializedName("“name”")
	val name: String? = null,

	@field:SerializedName("“password”")
	val password: String? = null
) : Parcelable
