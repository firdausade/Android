package com.example.quranscanning.Networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.ArrayList

interface ApiInterface {
    @GET("/quran/format/json/surat")
    fun getListSurah(): Call<ArrayList<ModelSurah>>

    @GET("/quran/format/json/surat/{nomorsurat}/ayat/{nomorayat}")
    fun getDetailSurah(
        @Path("nomorsurat") nomorsurat : String,
        @Path("nomorayat") nomorayat: String
    ): Call<ArrayList<ModelAyat>>
}