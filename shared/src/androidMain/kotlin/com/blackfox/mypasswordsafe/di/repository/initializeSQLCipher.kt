package com.blackfox.mypasswordsafe.android.di.repository

import net.zetetic.database.sqlcipher.SQLiteDatabase
import java.io.File

fun initializeSQLCipher(databaseFile: Any, password:String, createTableSql:String?) : Any? {
    System.loadLibrary("sqlcipher")
    val database = SQLiteDatabase.openOrCreateDatabase(databaseFile as File, password, null, null)
    if (database != null) {
        if (createTableSql != null) {
            database.execSQL(createTableSql)
        }
        /*
        database.execSQL(
            "insert into t1(a,b) values(?, ?);",
            arrayOf("one for the money", "two for the show")
        )
         */
    }
    return database
}
