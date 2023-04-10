package com.example.berita

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BeritaViewModel : ViewModel(){
    // Membuat variabel untuk menyimpan list data berita secara mutable
    val _listBerita = MutableLiveData<List<DataBerita>>()

    // Membuat variabel LiveData untuk list data berita agar dapat diobserve oleh View
    val listBerita: LiveData<List<DataBerita>>
        get() = _listBerita

    // Fungsi init yang dipanggil saat instance dibuat untuk menginisialisasi data
    init {
        loadData()
    }

    // Fungsi untuk mengisi data berita ke dalam list _listBerita
    private fun loadData() {
        val list = mutableListOf<DataBerita>()

        // Tambahkan data berita ke dalam list
        list.add(
            DataBerita(
                "All England",
                "10 April 2023",
                R.drawable.allengland,
                R.string.berita_1
            )
        )
        list.add(
            DataBerita(
                "Piala Dunia U-20 Resmi Batal di Indonesia",
                "10 April 2023",
                R.drawable.pilldun,
                R.string.berita_2
            )
        )
        list.add(
            DataBerita(
                "Chiharu Shida Pebulutangkis Ganda Puteri Asal Jepang",
                "10 April 2023",
                R.drawable.shida,
                R.string.berita_3
            )
        )
        // Set value dari _listBerita dengan list berita yang sudah diisi datanya
        _listBerita.value = list
    }
}