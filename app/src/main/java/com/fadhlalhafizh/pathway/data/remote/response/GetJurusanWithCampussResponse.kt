package com.fadhlalhafizh.pathway.data.remote.response

import com.google.gson.annotations.SerializedName

data class GetJurusanWithCampussResponse(

	@field:SerializedName("GetJurusanWithCampussResponse")
	val getJurusanWithCampussResponse: List<GetJurusanWithCampussResponseItem>
)

data class GetJurusanWithCampussResponseItem(

	@field:SerializedName("universitas")
	val universitas: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("prodi")
	val prodi: String,

	@field:SerializedName("jenjang")
	val jenjang: String
)
