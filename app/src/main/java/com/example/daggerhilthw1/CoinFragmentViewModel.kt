package com.example.daggerhilthw1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoinFragmentViewModel: ViewModel()
{
    val coins = mutableListOf(
        CoinModel("Dollar USA", R.drawable.dollar),
        CoinModel("Dollar Australia", R.drawable.australiandollar),
        CoinModel("Dollar Canada", R.drawable.canadiandollar),
        CoinModel("Euro EU", R.drawable.euro),
        CoinModel("Pound UK", R.drawable.pound),
        CoinModel("Rouble Russia", R.drawable.rouble),
        CoinModel("Rupee India", R.drawable.rupee),
        CoinModel("Franc Swiss", R.drawable.swissfranc),
        CoinModel("Yen Japan", R.drawable.yen),
        CoinModel("Yuan China", R.drawable.yuan),
    )

    val coinsData: MutableLiveData<MutableList<CoinModel>> by lazy { MutableLiveData<MutableList<CoinModel>>() }
}