package com.example.daggerhilthw1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilthw1.databinding.ListItemBinding

class CustomAdapter(private var coins: List<CoinModel>) :
    RecyclerView.Adapter<CustomAdapter.CoinItemHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoinItemHolder {

        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CoinItemHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CoinItemHolder,
        position: Int
    ) {
        val coin = coins[position]
        holder.binding.coinName.text = coin.name
        holder.binding.coinImage.setImageResource(coin.image)
    }

    override fun getItemCount() = coins.size

    class CoinItemHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }

    fun updateList(newList: List<CoinModel>) {
        coins = newList
        notifyDataSetChanged()
    }


}