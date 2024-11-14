package com.example.daggerhilthw1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class CoinFragmentViewModel @Inject constructor(): ViewModel()
{

    @Inject
    lateinit var coins: CoinsModelsDataBase

    val coinsData: MutableLiveData<MutableList<CoinModel>> by lazy { MutableLiveData(coins.getCoinsModels()) }
}