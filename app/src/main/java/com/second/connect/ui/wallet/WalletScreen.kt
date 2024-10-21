package com.second.connect.ui.wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.second.connect.ConnectTopBar
import com.second.connect.ui.theme.Black
import com.second.connect.ui.theme.ConnectBackground
import com.second.connect.ui.theme.Gray100
import com.second.connect.ui.theme.Gray200
import com.second.connect.ui.theme.Gray700
import com.second.connect.ui.theme.Pretendard
import com.second.connect.ui.theme.White

@Preview
@Composable
fun WalletScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ConnectBackground)
    ) {
        ConnectTopBar(
            title = "My Connects",
            isScanner = false
        )
        LazyColumn {
            item {
                WalletListItem(
                    name = "이름",
                    introduce = "한 줄 소개"
                )
            }
        }
    }
}

@Composable
fun WalletListItem(
    modifier: Modifier = Modifier,
    name: String,
    introduce: String
) {
    Row(
        modifier = modifier
            .padding(
                start = 30.dp,
                end = 30.dp,
                top = 12.dp
            )
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(White)
            .border(
                width = 1.dp,
                color = Gray200,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                start = 20.dp,
                end = 12.dp,
                top = 14.dp,
                bottom = 14.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = "",
            contentDescription = null,
            modifier = modifier
                .size(62.dp)
                .clip(shape = RoundedCornerShape(31.dp))
                .background(Gray100),
        )
        Column(
            modifier = modifier
                .padding(
                    start = 18.dp
                )
        ) {
            Text(
                text = name,
                style = TextStyle(
                    fontFamily = Pretendard,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Black
                )
            )
            Text(
                text = introduce,
                style = TextStyle(
                    fontFamily = Pretendard,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp,
                    color = Gray700
                ),
                modifier = modifier
                    .padding(top = 4.dp)
            )
        }
    }
}