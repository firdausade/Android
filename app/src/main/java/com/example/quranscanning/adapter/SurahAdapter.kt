package com.example.quranscanning.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.quranscanning.activity.DetailActivity
import com.example.quranscanning.Networking.ModelSurah
import com.example.quranscanning.R
import java.util.ArrayList

class SurahAdapter (private val mContext: Context) : RecyclerView.Adapter<SurahAdapter.ViewHolder>() {

        private val listSurah = ArrayList<ModelSurah>()

        fun setAdapter(items: ArrayList<ModelSurah>) {
            listSurah.clear()
            listSurah.addAll(items)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_surah, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val data = listSurah[position]

            holder.nomor.text = data.nomor
            holder.asma.text = data.asma
            holder.namaSurah.text = data.nama
            holder.info.text = data.arti

            holder.cvSurah.setOnClickListener {
                val intent = Intent(mContext, DetailActivity::class.java)
                intent.putExtra(DetailActivity.DETAIL_SURAH, listSurah[position])
                mContext.startActivity(intent)
            }
        }

        override fun getItemCount(): Int {
            return listSurah.size
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var surah: CardView
            var nomor: TextView
            var asma: TextView
            var info: TextView
            var namaSurah: TextView

            init {
                surah = itemView.cvSurah
                nomor = itemView.tvNomor
                asma = itemView.tvAyat
                info = itemView.tvInfo
                namaSurah = itemView.tvSurah
            }
        }
    }
}