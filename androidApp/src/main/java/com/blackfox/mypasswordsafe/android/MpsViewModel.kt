package com.blackfox.mypasswordsafe.android

import androidx.lifecycle.ViewModel
import com.blackfox.mypasswordsafe.android.di.repository.*
import net.zetetic.database.sqlcipher.SQLiteDatabase
import java.io.File

class MpsViewModel(private val userRepository: UserRepository, private val vaultRepository:VaultRepository, val accountRepository: AccountRepository) : ViewModel() {
    fun sayHello(name : String) : String{
        val foundUser = userRepository.findUser(name)
        return foundUser?.let { "Hello '$it' from $this" } ?: "User '$name' not found!"
    }

    fun initializeSQLCipher(databaseFile: File, password:String) {
        System.loadLibrary("sqlcipher")
        val database = SQLiteDatabase.openOrCreateDatabase(databaseFile, password, null, null)
        if (database != null) {
            database.execSQL("create table if not exists t1(a,b);")
            database.execSQL(
                "insert into t1(a,b) values(?, ?);",
                arrayOf("one for the money", "two for the show")
            )
        }
    }
}