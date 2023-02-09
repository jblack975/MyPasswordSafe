package com.blackfox.mypasswordsafe.android.di

import com.blackfox.mypasswordsafe.android.GreetPresenter
import com.blackfox.mypasswordsafe.android.MpsViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val androidModule = module {
    singleOf(::GreetPresenter)
    viewModel { MpsViewModel() }
}