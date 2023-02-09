package com.blackfox.mypasswordsafe.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.blackfox.mypasswordsafe.Greeting
import com.blackfox.mypasswordsafe.Platform
import com.blackfox.mypasswordsafe.android.GreetPresenter
import com.blackfox.mypasswordsafe.android.MpsViewModel
import com.blackfox.mypasswordsafe.android.R

@Composable
fun HomeScreen() {
    //val viewModel: MpsViewModel by koinViewModel()
    val viewModel = MpsViewModel()
    //val presenter: GreetPresenter by get()
    val presenter = GreetPresenter(greeting = Greeting(Platform()))
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column() {
            Text(text = stringResource(id = R.string.screen_title_home))
            Text(text = presenter.print())
            Text(text = viewModel.sayHello("Jason"))
        }
    }
}