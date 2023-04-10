package com.example.berita

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BeritaAdapter(private val listBerita: List<DataBerita>) : RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>(){

    // panggil data dari layout dengan metode find view by Id
    class BeritaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageBerita: ImageView = itemView.findViewById(R.id.image_berita)
        val textJudul: TextView = itemView.findViewById(R.id.text_judul)
        val textTanggal: TextView = itemView.findViewById(R.id.text_tanggal)
        val textIsi: TextView = itemView.findViewById(R.id.text_isi)

    }

    // Method ini digunakan untuk membuat dan menginisialisasi tampilan item pada RecyclerView
    // dan mengembalikan instance dari BeritaViewHolder yang akan digunakan pada method onBindViewHolder()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return BeritaViewHolder(view)
    }


    //inisialisasi berita dengan isi sesuai list berita
    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        val berita = listBerita[position]
        holder.textJudul.text = berita.judul
        holder.textTanggal.text = berita.tanggal
        holder.textIsi.text = holder.itemView.context.resources.getString(berita.isiResId)
        holder.imageBerita.setImageResource(berita.img)

    }


    override fun getItemCount(): Int {
        return listBerita.size
    }


}
