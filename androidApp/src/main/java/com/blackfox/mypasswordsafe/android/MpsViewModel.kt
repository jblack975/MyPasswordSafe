package com.blackfox.mypasswordsafe.android

import android.content.Context
import androidx.lifecycle.ViewModel
import com.blackfox.mypasswordsafe.android.di.repository.*
import com.blackfox.mypasswordsafe.shared.cache.AppDatabase
import com.blackfox.mypasswordsafe.shared.cache.Database
import com.blackfox.mypasswordsafe.shared.cache.DatabaseDriverFactory
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import net.zetetic.database.sqlcipher.SQLiteDatabase
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory
import java.io.File

class MpsViewModel() : ViewModel() {
    var conn:SqlDriver? = null
    var dbconn:Database? = null

    fun sayHello(name : String) : String{
        //val foundUser = userRepository.findUser(name)
        return "User '$name' not found!"
    }

    fun closeDatabase() {
        conn?.close()
    }
    fun initializeUserSQLCipher(databasePath: File, password: String, context: Context) {
        val d = DatabaseDriverFactory(context)
        conn = d.createDriver()
        val factory = SupportOpenHelperFactory(password.toByteArray())
        dbconn = Database(
            DatabaseDriverFactory(context), AndroidSqliteDriver(
                AppDatabase.Schema,
                context,
                "AppDatabase",
                factory
            )
        )
        initializeSQLCipher(
            databasePath,
            password,
            "create table if not exists account(a,b);"
        ) as SQLiteDatabase?
    }
}