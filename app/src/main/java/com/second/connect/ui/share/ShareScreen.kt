package com.second.connect.ui.share

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.second.connect.ConnectTopBar
import com.second.connect.R
import com.second.connect.ui.theme.Black
import com.second.connect.ui.theme.ConnectBackground
import com.second.connect.ui.theme.Gray100
import com.second.connect.ui.theme.Gray400
import com.second.connect.ui.theme.Main
import com.second.connect.ui.theme.Pretendard
import com.second.connect.ui.theme.White

@Preview
@Composable
fun ShareScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ConnectBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConnectTopBar(
            title = "명함 공유",
            isScanner = true
        )
        Spacer(modifier = modifier.height(70.dp))
        AsyncImage(
            modifier = modifier
                .size(200.dp)
                .background(Gray100),
            model = "", // imageUrl
            contentDescription = "QR Image"
        )
        Spacer(modifier = modifier.height(40.dp))
        ShareLink(
            linkUrl = "connect/hseun"
        )
        Spacer(modifier = modifier.height(50.dp))
        ShareWay()
    }
}

@Composable
fun ShareLink(
    modifier: Modifier = Modifier,
    linkUrl: String
) {
    Row(
        modifier = modifier
            .padding(
                start = 30.dp,
                end = 30.dp
            )
            .fillMaxWidth()
            .background(
                color = White,
                shape = RoundedCornerShape(4.dp)
            )
            .border(
                width = 1.dp,
                color = Gray400,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(
                start = 20.dp,
                end = 16.dp,
                top = 14.dp,
                bottom = 14.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = linkUrl,
            style = TextStyle(
                color = Black,
                fontFamily = Pretendard,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        )
        Image(
            painter = painterResource(id = R.drawable.url_share),
            contentDescription = "Url Share",
            modifier = modifier.size(24.dp)
        )
    }
}

@Composable
fun ShareWay(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(
                start = 60.dp,
                end = 60.dp
            )
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ShareWayItem(
            way = "이미지 저장",
            icon = R.drawable.save_image
        )
        ShareWayItem(
            way = "QR 저장",
            icon = R.drawable.save_qr
        )
        ShareWayItem(
            way = "Instagram",
            icon = R.drawable.instagram
        )
    }
}

@Composable
fun ShareWayItem(
    modifier: Modifier = Modifier,
    way: String,
    icon: Int
) {
    Column(
        modifier = modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = modifier.size(50.dp)
        )
        Text(
            text = way,
            style = TextStyle(
                fontFamily = Pretendard,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Black
            ),
            modifier = modifier.padding(top = 2.dp)
        )
    }
}