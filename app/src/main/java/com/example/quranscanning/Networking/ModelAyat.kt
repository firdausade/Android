package com.example.quranscanning.Networking

import com.google.gson.annotations.SerializedName

class ModelAyat {
    @SerializedName("ar")
    lateinit var arab: String

    @SerializedName("id")
    lateinit var indo: String

    @SerializedName("surat")
    lateinit var nomorsurat: String

    @SerializedName("ayat")
    lateinit var nomorayat: String
}