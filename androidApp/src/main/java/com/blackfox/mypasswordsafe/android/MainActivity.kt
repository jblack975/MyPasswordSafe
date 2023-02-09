package com.blackfox.mypasswordsafe.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.blackfox.mypasswordsafe.android.ui.BottomNavigationBar
import net.zetetic.database.sqlcipher.SQLiteDatabase

class MainActivity : ComponentActivity() {
    val password = "test12345"
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeSQLCipher()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = { BottomNavigationBar(navController) }
                    ) {
                        NavigationSetup(navController = navController)
                    }
                }
            }
        }
    }
    private fun initializeSQLCipher() {
        System.loadLibrary("sqlcipher")
        val databaseFile = getDatabasePath("test.db")
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


