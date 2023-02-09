package com.blackfox.mypasswordsafe.di

import com.blackfox.mypasswordsafe.Platform
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val platformModule = module {
    singleOf(::Platform)
}