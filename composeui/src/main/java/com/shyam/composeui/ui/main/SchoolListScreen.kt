package com.shyam.composeui.ui.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.shyam.composeui.R
import com.shyam.composeui.domain.model.Record

@Composable
fun SchoolListScreen(
    viewModel: SchoolsListViewModel
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val schoolList by viewModel.schools.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SchoolListAppBar()
        },
    ) { padding ->
        Box(
            modifier = Modifier.padding(padding)
        ) {
            if(isLoading) LoadingScreen()
            SchoolList(schoolList)
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
    listItems: List<Record>
) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(listItems) { item ->
            SchoolItemRow(item = item)
        }
    }
}

@Composable
fun SchoolItemRow(
    item: Record
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Row(modifier = Modifier.animateContentSize()) {
            SchoolItemDetails(
                item = item,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 24.dp,
                        bottom = 24.dp
                    )
                    .fillMaxWidth(0.80f)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun SchoolItemDetails(
    item: Record?,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = item?.School_Id.toString(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle1,
            maxLines = 2
        )
        if (item?.Org_Name?.trim()?.isNotEmpty() == true)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = item.Org_Name.trim(),
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.caption,
                )
            }
    }
}

@Composable
fun LoadingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}