package com.blackfox.mypasswordsafe.android

import com.blackfox.mypasswordsafe.Greeting
import kotlin.reflect.KProperty

class GreetPresenter(val greeting: Greeting) {
    fun print() = greeting.greeting()
    operator fun getValue(nothing: Nothing?, property: KProperty<*>): GreetPresenter {
        return this
    }
}