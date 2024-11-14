package com.example.daggerhilthw1

interface CoinRepository {

    fun getCoinsModels(): MutableList<CoinModel>
}