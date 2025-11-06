package com.example.diceroller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diceroller.databinding.ItemHistoryBinding

class HistoryAdapter(private val items: MutableList<String>) :
    RecyclerView.Adapter<HistoryAdapter.VH>() {

    inner class VH(val b: ItemHistoryBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.b.tvItem.text = items[position]
    }

    override fun getItemCount() = items.size

    fun add(entry: String) {
        items.add(0, entry)
        notifyItemInserted(0)
    }
}
