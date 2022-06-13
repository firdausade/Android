package com.example.quranscanning

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quranscanning.Networking.ApiInterface
import com.example.quranscanning.Networking.ApiService
import com.example.quranscanning.Networking.ModelAyat
import com.example.quranscanning.Networking.ModelSurah
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SurahViewModel {
    private val suratMutableLiveData = MutableLiveData<ArrayList<ModelSurah>>()
    private val ayatMutableLiveData = MutableLiveData<ArrayList<ModelSurah>>()
    fun setSurah() {
        val apiService: ApiInterface = ApiService.getSurah()
        val call = apiService.getListSurah()

        call.enqueue(object : Callback<ArrayList<ModelSurah>> {
            override fun onResponse(call: Call<ArrayList<ModelSurah>>, response: Response<ArrayList<ModelSurah>>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString())
                } else if (response.body() != null) {
                    val items: ArrayList<ModelSurah> = ArrayList(response.body())
                    suratMutableLiveData.postValue(items)
                }
            }

            override fun onFailure(call: Call<ArrayList<ModelSurah>>, t: Throwable) {
                Log.e("failure", t.toString())
            }
        })
    }
    fun getSurah(): LiveData<ArrayList<ModelSurah>> = suratMutableLiveData

    fun setDetailSurah(nomor: String) {
        val apiService: ApiInterface = ApiService.getSurah()
        val call = apiService.getDetailSurah(nomor)

        call.enqueue(object : Callback<ArrayList<ModelAyat>> {
            override fun onResponse(call: Call<ArrayList<ModelAyat>>, response: Response<ArrayList<ModelAyat>>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString())
                } else if (response.body() != null) {
                    val items: ArrayList<ModelAyat> = ArrayList(response.body())
                    ayatMutableLiveData.postValue(items)
                }
            }

            override fun onFailure(call: Call<java.util.ArrayList<ModelAyat>>, t: Throwable) {
                Log.e("failure", t.toString())
            }
        })
    }
    fun getDetailSurah(): LiveData<ArrayList<ModelAyat>> = ayatMutableLiveData

}