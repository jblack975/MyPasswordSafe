package com.blackfox.mypasswordsafe.android

import androidx.lifecycle.ViewModel

class MpsViewModel() : ViewModel() {
    fun sayHello(name : String) : String{
        return "User '$name' not found!"
    }
}