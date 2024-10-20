package com.plcoding.cryptotracker.crypto.presentation.coil_list

import com.plcoding.cryptotracker.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class onCoinClick(val coinUi: CoinUi): CoinListAction

    data object onRefresh: CoinListAction
}