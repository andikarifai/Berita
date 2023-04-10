package com.example.berita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BeritaActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: BeritaAdapter
    lateinit var viewModel: BeritaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)

        // Inisialisasi RecyclerView dan adapter
        recyclerView = findViewById(R.id.rvBerita)
        adapter = BeritaAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inisialisasi ViewModel dan observe perubahan data
        viewModel = ViewModelProvider(this)[BeritaViewModel::class.java]
        viewModel.listBerita.observe(this) { it ->
            adapter = BeritaAdapter(it)
            recyclerView.adapter = adapter
        }
    }
}