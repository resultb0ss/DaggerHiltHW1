package com.example.daggerhilthw1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilthw1.databinding.ListItemBinding

class CustomAdapter(private val coins: MutableList<CoinModel>):
    RecyclerView.Adapter<CustomAdapter.CoinItemHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoinItemHolder {

        val lifecycleOwner = parent.context as LifecycleOwner
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return CoinItemHolder(binding, lifecycleOwner)
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

    class CoinItemHolder(val binding: ListItemBinding, private val lifeCycleOwner: LifecycleOwner):
        RecyclerView.ViewHolder(binding.root){


    }



}