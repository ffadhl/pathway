package com.fadhlalhafizh.pathway.data.remote.response

import com.google.gson.annotations.SerializedName

data class ResultMajorResponse(

	@field:SerializedName("Prediksi Jurusan")
	val prediksiJurusan: String,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("id_question")
	val idQuestion: String
)
