package com.blackfox.mypasswordsafe.android.di.repository

data class Vault(val name : String, val accountNameList:List<String>)

interface VaultRepository {
    fun findUser(name : String): User?
    fun addUsers(users : List<User>)
}

class VaultRepositoryImpl : VaultRepository {
    private val _users = arrayListOf<User>()

    override fun findUser(name: String): User? {
        return _users.firstOrNull { it.name == name }
    }

    override fun addUsers(users : List<User>) {
        _users.addAll(users)
    }
}