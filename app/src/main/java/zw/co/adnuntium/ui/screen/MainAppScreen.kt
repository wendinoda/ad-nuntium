package zw.co.adnuntium.ui.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch
import zw.co.adnuntium.ui.NavGraph
import zw.co.adnuntium.ui.NavigationItem
import zw.co.adnuntium.ui.TopBar
import zw.co.adnuntium.ui.theme.AdNuntiumTheme
import zw.co.adnuntium.ui.theme.BottomNavBar
import java.lang.reflect.Modifier

@Composable
fun MainAppScreen() {
    AdNuntiumTheme {
        ProvideWindowInsets {
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
            }

            val navController = rememberNavController()
            val scaffoldState = rememberScaffoldState()

            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    TopBar()
                },
                bottomBar = {
                    BottomNavBar(
                        navController
                    )
                },
            ) {
                NavGraph()
            }
        }
    }
}