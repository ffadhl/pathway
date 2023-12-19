package com.fadhlalhafizh.pathway.data.remote.response

import com.google.gson.annotations.SerializedName

data class GetUnivResponse(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class DataItem(

	@field:SerializedName("university")
	val university: String,

	@field:SerializedName("singkatan")
	val singkatan: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("npsn")
	val npsn: String,

	@field:SerializedName("alamat")
	val alamat: String
)
