package com.example.daggerhilthw1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CoinFragmentViewModel: ViewModel()
{

    @Inject
    lateinit var coins: CoinsModelsDataBase

    val coinsData: MutableLiveData<MutableList<CoinModel>> by lazy { MutableLiveData(coins.getCoinsModels()) }
}