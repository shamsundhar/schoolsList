package com.shyam.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.shyam.composeui.ui.main.SchoolListScreen
import com.shyam.composeui.ui.main.SchoolsListViewModel
import com.shyam.composeui.ui.theme.SchoolsListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<SchoolsListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchoolsListTheme {
                AppScreen(viewModel)
            }
        }
    }
}

@Composable
fun AppScreen(viewModel: SchoolsListViewModel) {
    SchoolListScreen(
        viewModel = viewModel
    )
}
