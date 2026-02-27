package com.example.fitnesstips

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipsAdapter(
    private val tips: List<Tip>,
    private val onItemClick: (Tip) -> Unit
) : RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

    class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textDayNumber: TextView = itemView.findViewById(R.id.textDayNumber)
        val textTitle: TextView = itemView.findViewById(R.id.textTitle)
        val imageTip: ImageView = itemView.findViewById(R.id.imageTip)
        val textDescription: TextView = itemView.findViewById(R.id.textDescription)

        fun bind(tip: Tip, onItemClick: (Tip) -> Unit) {
            textDayNumber.text = tip.dayNumber.toString()
            textTitle.text = tip.title
            imageTip.setImageResource(tip.imageResId)
            textDescription.text = tip.description
            itemView.setOnClickListener { onItemClick(tip) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        holder.bind(tips[position], onItemClick)
    }

    override fun getItemCount(): Int = tips.size
}