package com.example.mycity

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.ui.MyCityViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mycity.data.DataSource
import com.example.mycity.ui.MyCityList

enum class MyCityScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Coffee(title = R.string.category_coffee),
    Restaurant(title = R.string.category_restaurants),
    Kidfriendly(title = R.string.category_kidfriendly),
    Park(title = R.string.category_parks),
    Shopping(title = R.string.category_shopping),
    Details(title = R.string.coffee1)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyCityApp (
    viewModel: MyCityViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.Start.name
    )
    Scaffold(
        topBar = {
            MyCityAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = MyCityScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyCityScreen.Start.name) {
                MyCityList(
                    category = DataSource.getCategories(),
                    onClick = {
                        //viewModel.updateCurrentCategory(it)
                        navController.navigate(MyCityScreen.Coffee.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }

            composable(route = MyCityScreen.Start.name) {
                MyCityList(
                    category = DataSource.getCategories(),
                    onClick = {
                        //viewModel.updateCurrentCategory(it)
                        navController.navigate(MyCityScreen.Restaurant.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }

            composable(route = MyCityScreen.Start.name) {
                MyCityList(
                    category = DataSource.getCategories(),
                    onClick = {
                        //viewModel.updateCurrentCategory(it)
                        navController.navigate(MyCityScreen.Kidfriendly.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }

            composable(route = MyCityScreen.Start.name) {
                MyCityList(
                    category = DataSource.getCategories(),
                    onClick = {
                        //viewModel.updateCurrentCategory(it)
                        navController.navigate(MyCityScreen.Park.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }

            composable(route = MyCityScreen.Start.name) {
                MyCityList(
                    category = DataSource.getCategories(),
                    onClick = {
                        //viewModel.updateCurrentCategory(it)
                        navController.navigate(MyCityScreen.Shopping.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    currentScreen: MyCityScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}