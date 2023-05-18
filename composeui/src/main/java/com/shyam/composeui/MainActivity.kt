package com.shyam.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shyam.composeui.domain.model.Record
import com.shyam.composeui.ui.base.UiState
import com.shyam.composeui.ui.main.SchoolsListViewModel
import com.shyam.composeui.ui.theme.SchoolsListTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.StateFlow

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchoolsListTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
    val viewModel: SchoolsListViewModel = hiltViewModel()
    SchoolListScreen(
        state = viewModel.uiState
    )
}

@Composable
fun SchoolListScreen(
    state: StateFlow<UiState<List<Record>>>
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SchoolListAppBar()
        },
    ) { padding ->
        Box(
            modifier = Modifier.padding(padding)
        ) {
            SchoolList(ArrayList<Record>())
        }
    }
}

@Composable
private fun SchoolListAppBar() {
    TopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        backgroundColor = MaterialTheme.colors.background
    )
}

@Composable
fun SchoolList(
    foodItems: List<Record>
) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(foodItems) { item ->
//            FoodItemRow(item = item, itemShouldExpand = true, onItemClicked = onItemClicked)
            Text(text = "shyam")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SchoolsListTheme {
        AppScreen()
    }
}