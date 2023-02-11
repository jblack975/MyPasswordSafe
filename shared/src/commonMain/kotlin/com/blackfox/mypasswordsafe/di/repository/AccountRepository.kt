package com.blackfox.mypasswordsafe.android.di.repository

data class Account(val name:String, val url:String, val username:String, val password:ByteArray, val notes:String)

interface AccountRepository {
    fun findUser(name : String): User?
    fun addUsers(users : List<User>)
}

class AccountRepositoryImpl : AccountRepository {
    private val _users = arrayListOf<User>()

    override fun findUser(name: String): User? {
        return _users.firstOrNull { it.name == name }
    }

    override fun addUsers(users : List<User>) {
        _users.addAll(users)
    }
}