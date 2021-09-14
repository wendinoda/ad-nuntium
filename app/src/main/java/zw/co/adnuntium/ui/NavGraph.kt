package zw.co.adnuntium.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import zw.co.adnuntium.R
import zw.co.adnuntium.ui.screen.HomeScreen
import zw.co.presentation.feature.headlines.HeadlinesViewModel

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Headlines :
        NavigationItem("headlines", R.drawable.ic_baseline_local_fire_department_24, "Headlines")
    object Stories : NavigationItem("stories", R.drawable.ic_baseline_auto_stories_24, "Stories")
    object Saved : NavigationItem("saved", R.drawable.ic_baseline_bookmarks_24, "Saved")
}

@Composable
fun NavGraph() {
    val navController: NavHostController = rememberNavController()
    val viewModel = viewModel<HeadlinesViewModel>()
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Headlines.route
    ) {
        composable(NavigationItem.Headlines.route) {
            HomeScreen(viewModel)
        }
    }
}
