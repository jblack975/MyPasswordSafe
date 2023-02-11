package com.blackfox.mypasswordsafe.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.blackfox.mypasswordsafe.android.di.repository.AccountRepositoryImpl
import com.blackfox.mypasswordsafe.android.di.repository.UserRepositoryImpl
import com.blackfox.mypasswordsafe.android.di.repository.VaultRepositoryImpl
import com.blackfox.mypasswordsafe.android.ui.BottomNavigationBar
import net.zetetic.database.sqlcipher.SQLiteDatabase
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.get
class MainActivity : ComponentActivity() {
    val password = "test12345"
//    val viewModel:MpsViewModel by viewModel(get(), get(), get())
    val viewModel:MpsViewModel = MpsViewModel(UserRepositoryImpl(), VaultRepositoryImpl(), AccountRepositoryImpl())
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initializeSQLCipher(getDatabasePath("test.db"), password)
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
}


