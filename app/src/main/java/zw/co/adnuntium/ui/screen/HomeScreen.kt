package zw.co.adnuntium.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import zw.co.adnuntium.R
import zw.co.adnuntium.ui.composable.*
import zw.co.adnuntium.utils.categories
import zw.co.presentation.error.ErrorUi
import zw.co.presentation.feature.headlines.HeadlinesIntent
import zw.co.presentation.feature.headlines.HeadlinesState
import zw.co.presentation.feature.headlines.HeadlinesViewModel
import zw.co.presentation.model.ArticlesView

@Composable
fun HomeScreen(
    viewModel: HeadlinesViewModel
) {
    val scaffoldState = rememberScaffoldState()

    viewModel.setIntent(HeadlinesIntent.LoadHeadlines)
    val headlinesState by viewModel.uiState.collectAsState()

    when (headlinesState.state) {
        is HeadlinesState.Error -> {
            when (headlinesState.state.error) {
                ErrorUi.AccessDenied -> ErrorMessage(
                    "Access denied",
                    R.drawable.img_access_denied
                )
                ErrorUi.Network -> TODO()
                ErrorUi.NetworkUnavailable -> TODO()
                ErrorUi.NotFound -> ErrorMessage(
                    "Page not found",
                    R.drawable.img_page_not_found
                )
                ErrorUi.ServiceUnavailable -> ErrorMessage(
                    "Service unavailable",
                    R.drawable.img_server_down
                )
                ErrorUi.Unknown -> ErrorMessage(
                    "Error unknown",
                    R.drawable.img_cancel
                )
            }
        }
        is HeadlinesState.Idle -> {

        }
        is HeadlinesState.InProgress -> {
            LoadingNews()
        }
        is HeadlinesState.Success -> {
            Headlines(
                headlinesState.state.headlines!!.articles,
                scaffoldState
            )
        }
    }
}

@Composable
fun Headlines(
    headlinesList: List<ArticlesView>,
    scaffoldState: ScaffoldState
) {
    Scaffold(
        scaffoldState = scaffoldState,
    ) { padding ->
        val modifier = Modifier.padding(padding)

        LazyColumn(
            modifier = modifier,
            contentPadding = rememberInsetsPaddingValues(
                insets = LocalWindowInsets.current.systemBars,
                applyTop = false
            )
        ) {
            item { CategoriesLazyList() }
            item {
                TopHeadlinesLazyList(headlinesList.subList(0, 4))
            }
            item {
                NewsLazyList(headlinesList.subList(5, 14))
            }
        }
    }
}

@Composable
fun LoadingNews() {
    LazyColumn {
        repeat(4) {
            item {
                ShimmerAnimation()
            }
        }
    }
}

@Composable
fun TopHeadlinesLazyList(
    headlines: List<ArticlesView>
) {
    Column {
        Text(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.top_headlines),
            style = MaterialTheme.typography.subtitle1
        )
        LazyRow(modifier = Modifier.padding(end = 16.dp)) {
            items(headlines) { headline ->
                HeadlineNewsCard(
                    article = headline,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(280.dp, 260.dp)
                        .clickable(onClick = { }),
                    Modifier
                        .height(180.dp)
                        .fillMaxWidth()
                )
                Spacer(Modifier.width(8.dp))
            }
        }
        ArticleDivider()
    }
}

@Composable
fun NewsLazyList(
    headlines: List<ArticlesView>
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        headlines.forEach { headline ->
            HeadlineNewsCard(
                article = headline,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clickable(onClick = { }),
                Modifier
                    .heightIn(min = 120.dp)
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
        }
    }
    ArticleDivider()
}

@Composable
fun CategoriesLazyList() {
    LazyRow(modifier = Modifier.padding(top = 16.dp, end = 4.dp)) {
        items(categories) {
            CategoryChip(
                label = it
            )
        }
    }
    ArticleDivider()
}
