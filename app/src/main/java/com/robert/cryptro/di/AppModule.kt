package com.robert.cryptro.di

import com.robert.cryptro.core.data.networking.RetrofitFactory
import com.robert.cryptro.crypto.data.networking.RemoteCoinDataSource
import com.robert.cryptro.crypto.data.networking.dto.CoinApiService
import com.robert.cryptro.crypto.domain.CoinDataSource
import com.robert.cryptro.crypto.presentation.coin_list.CoinListViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {

    single { RetrofitFactory.create() }
    single { get<Retrofit>().create(CoinApiService::class.java) }
    single<CoinDataSource> { RemoteCoinDataSource(get()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}