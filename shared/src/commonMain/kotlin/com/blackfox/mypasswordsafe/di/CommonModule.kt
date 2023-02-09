package com.blackfox.mypasswordsafe.di

import com.blackfox.mypasswordsafe.Greeting
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    singleOf(::Greeting)
}