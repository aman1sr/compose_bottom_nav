package com.pahadi.composebottomnav.base

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pahadi.composebottomnav.screens.FilterScreen
import com.pahadi.composebottomnav.screens.NewsScreen
import com.pahadi.composebottomnav.screens.SavedScreen
import com.pahadi.composebottomnav.screens.SearchScreen

@Composable
fun NewsNavHost(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    val currentScreen = bottomScreenList.find { it.name == currentDestination?.route } ?: Route.TopNews

    Scaffold(
        topBar = {
            NewsAppBar(
                currentScreen = currentScreen.toString(),
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
        bottomBar = {
            NewsBottomNavigation(
                currentScreen = currentScreen,
                onIconSelected = { selectedScreen ->
                    navController.navigate(selectedScreen.name) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.TopNews.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = Route.TopNews.name){
                NewsScreen()
            }
            composable(route = Route.FilterNews.name){
                FilterScreen()
            }
             composable(route = Route.SavedNews.name){
                SavedScreen()
            }
             composable(route = Route.SearchNews.name){
                SearchScreen()
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsAppBar(
    currentScreen: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(currentScreen) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Composable
fun NewsBottomNavigation(
    currentScreen: Route,
    onIconSelected: (Route)-> Unit
) {
    NavigationBar {
        bottomScreenList.forEach { screen ->
            NavigationBarItem(
                selected =  (screen.name == currentScreen.name),
                label = {
                    Text(text = stringResource(screen.title))
                },
                icon = {
                Icon(painter = painterResource(id = screen.icon),null)
                },
                onClick = {
                    onIconSelected.invoke(screen)
                }
            )
        }
    }
}


