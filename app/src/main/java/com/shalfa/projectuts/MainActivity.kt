package com.shalfa.projectuts

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)

    val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
    recyclerView.layoutManager = LinearLayoutManager(this)

    // Set adapter with your data
    recyclerView.adapter = MyAdapter(myDataList)
}
