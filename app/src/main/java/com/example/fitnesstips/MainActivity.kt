package com.example.fitnesstips

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TipsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val tips = generateTips()
        adapter = TipsAdapter(tips) { tip ->
            val intent = Intent(this, TipDetailActivity::class.java).apply {
                putExtra("day_number", tip.dayNumber)
                putExtra("title", tip.title)
                putExtra("detailed_description", tip.detailedDescription)
                putExtra("image_res_id", tip.imageResId)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }

    private fun generateTips(): List<Tip> {
        val tips = mutableListOf<Tip>()
        for (day in 1..30) {
            val titleId = resources.getIdentifier("tip_title_$day", "string", packageName)
            val descId = resources.getIdentifier("tip_desc_$day", "string", packageName)
            val detailId = resources.getIdentifier("tip_detail_$day", "string", packageName)
            val imageId = resources.getIdentifier("tip_$day", "drawable", packageName)

            tips.add(
                Tip(
                    dayNumber = day,
                    title = getString(titleId),
                    description = getString(descId),
                    detailedDescription = getString(detailId),
                    imageResId = imageId
                )
            )
        }
        return tips
    }
}