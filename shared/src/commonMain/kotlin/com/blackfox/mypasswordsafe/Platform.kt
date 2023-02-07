package com.blackfox.mypasswordsafe

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform