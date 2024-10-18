package com.second.connect.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.second.connect.R
import com.second.connect.ui.theme.Black
import com.second.connect.ui.theme.ConnectBackground
import com.second.connect.ui.theme.Main
import com.second.connect.ui.theme.Pretendard
import com.second.connect.ui.theme.White

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginButtonClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ConnectBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Logo()
        Spacer(
            modifier = modifier
                .height(26.dp)
        )
        LoginButton(onLoginButtonClick = onLoginButtonClick)
        Spacer(modifier = modifier.height(80.dp))
    }
}

@Composable
fun Logo() {
    Text(
        text = "CONNECT",
        style = TextStyle(
            brush = Main,
            fontFamily = Pretendard,
            fontWeight = FontWeight.Black,
            fontSize = 46.sp
        )
    )
}

@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    onLoginButtonClick: () -> Unit
) {
    Button(
        onClick = onLoginButtonClick,
        contentPadding = PaddingValues(
            horizontal = 18.dp,
            vertical = 14.dp
        ),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp
        )
    ) {
        Image(
            modifier = modifier
                .size(20.dp),
            painter = painterResource(id = R.drawable.instagram),
            contentDescription = "Instagram Logo"
        )
        Text(
            text = "Sign in with Instagram",
            modifier = modifier
                .padding(start = 10.dp),
            color = Black
        )
    }
}