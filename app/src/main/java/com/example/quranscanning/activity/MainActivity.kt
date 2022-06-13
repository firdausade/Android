package com.example.quranscanning.activity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quranscanning.Networking.ModelSurah
import com.example.quranscanning.R
import com.example.quranscanning.SurahViewModel
import com.example.quranscanning.adapter.SurahAdapter
import java.util.ArrayList


//private const val REQUEST_CODE = 42

class MainActivity : AppCompatActivity() {

    lateinit var adapter : SurahAdapter
    lateinit var surahView : SurahViewModel
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    private fun setInitLayout(){
        adapter = SurahAdapter(this)
        rvSurah.setHasFixedSize(true)
        rvSurah.setLayoutManager(LinearLayoutManager(this))
        rvSurah.setAdapter(adapter)

    }

    private fun setViewModel() {
        progressDialog.show()
        surahView = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            SurahViewModel::class.java)
        surahView.setSurah()
        surahView.getSurah()
            .observe(this, { modelSurah: ArrayList<ModelSurah> ->
                if (modelSurah.size != 0) {
                    adapter.setAdapter(modelSurah)
                    progressDialog.dismiss()
                } else {
                    Toast.makeText(this, "Data Tidak Ditemukan!", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
                progressDialog.dismiss()
            })
    }

}