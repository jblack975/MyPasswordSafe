package com.blackfox.mypasswordsafe.android

import com.blackfox.mypasswordsafe.Greeting

class GreetPresenter(val greeting: Greeting) {
    fun print() = greeting.greeting()
}