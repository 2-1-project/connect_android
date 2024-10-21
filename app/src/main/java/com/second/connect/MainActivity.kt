package com.second.connect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.second.connect.ui.login.LoginScreen
import com.second.connect.ui.theme.Black
import com.second.connect.ui.theme.ConnectTheme
import com.second.connect.ui.theme.Pretendard
import com.second.connect.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            ConnectTheme {
                ConnectApp()
            }
        }
    }
}

@Composable
fun ConnectApp() {
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
//                navController = navController
            )
        }
    }
}

@Composable
fun ConnectScreen(
    modifier: Modifier = Modifier,
//    navController: NavHostController
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { ConnectBottomNavigation(navController = navController) }
    ) {
        Box(modifier.padding(it)) {
            ConnectGraph(navController = navController)
        }
    }
}

@Composable
fun ConnectTopBar(
    modifier: Modifier = Modifier,
    title: String,
    isScanner: Boolean
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(White)
            .padding(
                start = 30.dp,
                end = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontFamily = Pretendard,
                fontWeight = FontWeight.Bold,
                color = Black,
                fontSize = 20.sp
            )
        )
        if (isScanner) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = modifier.wrapContentSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.scan),
                    contentDescription = "scanner",
                    modifier = modifier.size(28.dp)
                )
            }
        }
    }
}