package com.example.quranscanning.Networking

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ModelSurah : Serializable {

    @SerializedName("nomor")
    lateinit var nomor: String

    @SerializedName("nama")
    lateinit var nama: String

    @SerializedName("arti")
    lateinit var arti: String

    @SerializedName("asma")
    lateinit var asma: String

}