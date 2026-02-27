package com.example.fitnesstips

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class TipDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_detail)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.tip_detail_title)

        val imageDetail = findViewById<ImageView>(R.id.imageDetail)
        val textDayNumber = findViewById<TextView>(R.id.textDayNumber)
        val textTitle = findViewById<TextView>(R.id.textTitle)
        val textDetailedDescription = findViewById<TextView>(R.id.textDetailedDescription)

        val dayNumber = intent.getIntExtra("day_number", 0)
        val title = intent.getStringExtra("title") ?: ""
        val description = intent.getStringExtra("detailed_description") ?: ""
        val imageResId = intent.getIntExtra("image_res_id", 0)

        textDayNumber.text = String.format("%s %d", getString(R.string.day_prefix), dayNumber)
        textTitle.text = title
        textDetailedDescription.text = description
        imageDetail.setImageResource(imageResId)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}