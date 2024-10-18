package com.second.connect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.second.connect.ui.login.LoginScreen
import com.second.connect.ui.theme.ConnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConnectTheme {
                ConnectApp()
            }
        }
    }
}

@Composable
fun ConnectApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onLoginButtonClick = {
                    // 로그인
                    navController.navigate("main")
                }
            )
        }

        composable("main") {
            ConnectScreen(
                navController = navController
            )
        }
    }
}

@Composable
fun ConnectScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
}