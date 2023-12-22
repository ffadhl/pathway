package com.fadhlalhafizh.pathway.data.remote.response

import com.google.gson.annotations.SerializedName

data class ResultMajorResponse(

	@field:SerializedName("Recommended alternatif")
	val recommendedAlternatif: List<String>,

	@field:SerializedName("Rekomendasi Karir")
	val rekomendasiKarir: List<String>,

	@field:SerializedName("similarities")
	val similarities: List<Any>,

	@field:SerializedName("Prediksi Jurusan")
	val prediksiJurusan: String,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("id_question")
	val idQuestion: String
)
