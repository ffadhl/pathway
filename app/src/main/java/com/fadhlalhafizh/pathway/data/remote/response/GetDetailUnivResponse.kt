package com.fadhlalhafizh.pathway.data.remote.response

import com.google.gson.annotations.SerializedName

data class GetDetailUnivResponse(

	@field:SerializedName("data")
	val data: DataGetDetail,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class DataGetDetail(

	@field:SerializedName("jalan")
	val jalan: String,

	@field:SerializedName("website")
	val website: String,

	@field:SerializedName("universitas")
	val universitas: String,

	@field:SerializedName("telephone")
	val telephone: String,

	@field:SerializedName("wilayah")
	val wilayah: String,

	@field:SerializedName("npsn")
	val npsn: String,

	@field:SerializedName("jumlahProdiAkreditasi")
	val jumlahProdiAkreditasi: JumlahProdiAkreditasi,

	@field:SerializedName("rektor")
	val rektor: String,

	@field:SerializedName("jumlahProdi")
	val jumlahProdi: Int,

	@field:SerializedName("kodePos")
	val kodePos: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("fax")
	val fax: String,

	@field:SerializedName("tanggalBerdiri")
	val tanggalBerdiri: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("status")
	val status: String
)

data class JumlahProdiAkreditasi(

	@field:SerializedName("Baik Sekali")
	val baikSekali: Int,

	@field:SerializedName("A")
	val a: Int,

	@field:SerializedName("B")
	val b: Int,

	@field:SerializedName("Unggul")
	val unggul: Int,

	@field:SerializedName("Baik")
	val baik: Int
)
